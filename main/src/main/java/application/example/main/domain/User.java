package application.example.main.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User implements UserDetails {
    @Id
    @SequenceGenerator(name = "client_generator", sequenceName = "SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_generator")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @NotBlank(message = "Username cannot be empty")

    @Column(name = "username")
    private String username;
    @Email(message = "Email is not correct")
    @NotBlank(message = "Email cannot be empty")
    private String email;
    private String phone;
    @NotBlank(message = "Password cannot be empty")
    private String password;
    @Transient
    @NotBlank(message = "Password confirmation cannot be empty")
    private String password2;

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    private boolean active;
    private String activationCode;

//    @OneToMany(fetch = FetchType.EAGER)
//    @JsonManagedReference
//    private List<Settings> settingsList;

    public boolean isAdmin() {
        return roles.contains(Role.ADMIN);
    }

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User(String name, String email, String phone) {
        this.username = name;
        this.email = email;
        this.phone = phone;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
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

    public void setUsername(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", roles=" + roles +
                "\n";
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}