package InTechs.InTechs.service.project;

import InTechs.InTechs.entity.Image;
import InTechs.InTechs.entity.Project;
import InTechs.InTechs.entity.User;
import InTechs.InTechs.exception.exceptions.UserNotFoundException;
import InTechs.InTechs.repository.project.ProjectRepository;
import InTechs.InTechs.repository.user.UserRepository;
import InTechs.InTechs.service.file.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ProjectService{

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final FileUploadService fileUploadService;

    public String createProject(String proName, String userId, MultipartFile file) {
        int number = createProjectNumber();

        while (projectRepository.existsById(number)){
            number = createProjectNumber();
        }

        final String folder = "/project";
        final String miniFolder = "/project/mini";
        String fileUrl = fileUploadService.uploadImage(file, folder);

        String miniFileUrl=fileUploadService.imageResizeAndUpload(file, miniFolder);

        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);

        List<User> users = new ArrayList<>();
        users.add(user);

        Project project = Project.builder()
                .number(number)
                .name(proName)
                .images(Image.builder()
                            .image(fileUrl)
                            .miniImage(miniFileUrl)
                            .build())
                .users(users).build();

        projectRepository.save(project);

        return String.valueOf(number);
    }

    private int createProjectNumber(){
        final int len = 6;

        Random rand = new Random();

        StringBuilder id= new StringBuilder();

        for(int i = 0; i< len; i++){
            String ran = Integer.toString(rand.nextInt(10));
            id.append(ran);
        }

        return Integer.parseInt(id.toString());
    }
}
