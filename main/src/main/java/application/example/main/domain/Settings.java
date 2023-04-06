package application.example.main.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;


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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Settings(String tag, User user) {
        this.tag = tag;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Settings() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Settings(String tag) {
        this.tag = tag;
    }

    public String getUsername() {
        return user != null ? user.getUsername() : "<none>";
    }

    public String getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", user=" + user +
                ", filename='" + filename + '\'' +
                '}';
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
