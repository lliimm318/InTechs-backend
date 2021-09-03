package InTechs.InTechs.user;

import InTechs.InTechs.entity.User;
import InTechs.InTechs.repository.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserAddTests {
    @Autowired
    UserRepository userRepository;
    @Test
    public void userAdd(){
        User user = User.builder()
                .email("ddd@com")
                .image("dd.jpg")
                .password("dkssuddkssud")
                .isActive(true)
                .build();
        userRepository.save(user);
    }
}