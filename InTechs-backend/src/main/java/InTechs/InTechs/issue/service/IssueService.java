package InTechs.InTechs.issue.service;

import InTechs.InTechs.exception.exceptions.IssueNotFoundException;
import InTechs.InTechs.exception.exceptions.ProjectNotFoundException;
import InTechs.InTechs.issue.entity.Issue;
import InTechs.InTechs.issue.payload.IssueCreateRequest;
import InTechs.InTechs.issue.payload.IssueUpdateRequest;
import InTechs.InTechs.issue.repository.IssueRepository;
import InTechs.InTechs.issue.value.Tag;
import InTechs.InTechs.project.entity.Project;
import InTechs.InTechs.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class IssueService {
    private final IssueRepository issueRepository;
    private final ProjectRepository projectRepository;
    private final MongoTemplate mongoTemplate;

    public void issueCreate(String writer, int projectId, IssueCreateRequest issueRequest){
        Project project = projectRepository.findById(projectId).orElseThrow(ProjectNotFoundException::new);

        Issue issue = Issue.builder()
                .title(issueRequest.getTitle())
                .content(issueRequest.getContent())
                .state(issueRequest.getState())
                .progress(issueRequest.getProgress())
                .end_date(issueRequest.getEnd_date())
                .tags(issueRequest.getTags())
                .writer(writer)
                .userIds(issueRequest.getUserIds()) // USER 객체 저장...?
                .projectId(projectId)
                .build();

        issueRepository.save(issue);

        issueRequest.getTags().forEach(tag -> project.getTags().add(tag));

        project.addIssue(issue);
        projectRepository.save(project);
    }

    public void issueDelete(int projectId, String issueId){
        Project project = projectRepository.findById(projectId).orElseThrow(ProjectNotFoundException::new);
        project.getIssues().remove(issueRepository.findById(issueId).orElseThrow(IssueNotFoundException::new));
        projectRepository.save(project);
        issueRepository.deleteById(issueId);
    }

    public void issueUpdate(String issueId, IssueUpdateRequest request){
        Issue issue = issueRepository.findById(issueId).orElseThrow(IssueNotFoundException::new);
        if(request.getContent() != null) issue.setContent(request.getContent());
        if(request.getEnd_date() !=null) issue.setEnd_date(request.getEnd_date());
        if(request.getProgress()!=0) issue.setProgress(request.getProgress());
        if(request.getTitle() != null) issue.setTitle(request.getTitle());
        if(request.getTags() != null) tagChange(issue, request.getTags());
        if(request.getState() != null) issue.setState(request.getState());
        issueRepository.save(issue);
    }
    private void tagChange(Issue issue, Set<Tag> tags){
        Project project = projectRepository.findById(issue.getProjectId()).orElseThrow(ProjectNotFoundException::new);
        project.getTags().removeAll(tags);
        project.addTags(tags); // lambda
        projectRepository.save(project);
        issue.setTags(tags);
    }

    public void issueFiltering(int projectId, Set<String> tags, List<String> users, List<State> states){

        Criteria criteria = new Criteria("projectId");
        criteria.is(projectId);

        Query query = new Query(criteria);
        List<Issue> issue = mongoTemplate.find(query, Issue.class);
    }
}
