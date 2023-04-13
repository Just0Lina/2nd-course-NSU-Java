package application.example.main.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@ToString(includeFieldNames = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "usr")
public class User implements UserDetails {
    @Id
    @SequenceGenerator(name = "client_generator", sequenceName = "SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_generator")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @ToString.Include
    @NotBlank(message = "Username cannot be empty")
    @Column(name = "username")
    private String username;
    @ToString.Include
    @Email(message = "Email is not correct")
    @NotBlank(message = "Email cannot be empty")
    private String email;
    @ToString.Include
    private String phone;
    @ToString.Include
    @NotBlank(message = "Password cannot be empty")
    private String password;

    @ToString.Include
    private boolean active;
    private String activationCode;

    public boolean isAdmin() {
        return roles.contains(Role.ADMIN);
    }

    @ToString.Include
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", email='" + email + '\'' +
//                ", phone='" + phone + '\'' +
//                ", password='" + password + '\'' +
//                ", active=" + active +
//                ", roles=" + roles +
//                "\n";
//    }

//    @OneToMany(fetch = FetchType.EAGER)
//    @JsonManagedReference
//    private List<Settings> settingsList;


    public User() {
        username = "default user";
        email = "default email";
        phone = "default phone";
        password = "default password";
    }

    public User(Long id, String username, String email, String phone, String password, boolean active) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.active = active;
    }

    public User(String username, String email, String phone, String password) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public User(String name, String email, String phone) {
        this.username = name;
        this.email = email;
        this.phone = phone;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }


}