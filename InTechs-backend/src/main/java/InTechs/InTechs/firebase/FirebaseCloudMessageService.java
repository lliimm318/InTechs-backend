package InTechs.InTechs.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;

// AccessToken 발급받기
public class FirebaseCloudMessageService {
    private String getAccessToken() throws IOException{
        String firebaseConfigPath = "firebase/friebase-adminsdk.json";

        GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(new
                        ClassPathResource(firebaseConfigPath).getInputStream())
                .createScoped(List.of("https://www.googleapis.com/auth/cloud-platform"));

        googleCredentials.refreshIfExpired();
        return googleCredentials.getAccessToken().getTokenValue();
    }
}
