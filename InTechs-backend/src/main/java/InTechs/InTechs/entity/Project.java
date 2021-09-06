package InTechs.InTechs.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@Getter
@Document(collection = "project")
public class Project {
    @Id
    @NotNull
    @Length(min = 6, max = 6)
    private int number;
    @NotBlank
    @Size(max = 26)
    private String name;
    private Image image;
    @DBRef(lazy = true)
    private List<User> users;
    @DBRef(lazy = true)
    private List<Issue> issues;

    public void addUser(User user){
        this.users.add(user);
    }

    public void removeUser(User user){
        this.users.remove(user);
    }
}