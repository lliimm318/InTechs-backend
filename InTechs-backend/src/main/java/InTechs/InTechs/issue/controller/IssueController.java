package InTechs.InTechs.issue.controller;

import InTechs.InTechs.issue.payload.request.IssueCreateRequest;
import InTechs.InTechs.issue.payload.request.IssueFilterRequest;
import InTechs.InTechs.issue.payload.request.IssueUpdateRequest;
import InTechs.InTechs.issue.payload.response.IssueFilterResponse;
import InTechs.InTechs.issue.service.IssueService;
import InTechs.InTechs.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class IssueController {
    private final IssueService issueService;
    private final JwtTokenProvider jwtTokenProvider;
    @PostMapping("/{projectId}/issue")
    public void issueCreate(@RequestHeader("Authorization") String token,@PathVariable int projectId, @Valid @RequestBody IssueCreateRequest issueRequest){
        issueService.issueCreate(jwtTokenProvider.getEmail(token), projectId, issueRequest);
    }
    @DeleteMapping("/{projectId}/issue/{issueId}")
    public void issueDelete(@PathVariable int projectId, @PathVariable String issueId){
        issueService.issueDelete(projectId, issueId);
    }

    @PatchMapping("/issue/{issueId}")
    public void issueUpdate(@PathVariable String issueId, @RequestBody IssueUpdateRequest issueUpdateRequest){
        issueService.issueUpdate(issueId, issueUpdateRequest);
    }

    @GetMapping("/{projectId}/issue")
    public List<IssueFilterResponse> issueFiltering(@PathVariable int projectId, @RequestBody IssueFilterRequest issueFilterRequest){
        return issueService.issueFiltering(projectId,issueFilterRequest);
    }
}
