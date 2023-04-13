package application.example.main.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@ToString(includeFieldNames = true)
@Entity
@Table(name = "settings")
public class Settings {
    @Id
    @SequenceGenerator(name = "settings_generator", sequenceName = "SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "settings_generator")
    private Long id;

    @NotBlank(message = "Please fill the tag")
    @Length(max = 50, message = "Tag too long (more than 50 char)")
    String tag;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User user;

    private String filename;


    public Settings(String tag, User user) {
        this.tag = tag;
        this.user = user;
    }


    public String getUsername() {
        return user != null ? user.getUsername() : "<none>";
    }


}
