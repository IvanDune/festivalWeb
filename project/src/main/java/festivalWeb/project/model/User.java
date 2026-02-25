package festivalWeb.project.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "mail")
    private String mail;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "social_web")
    private String socialWeb;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    //TODO Сейчас реализована стандартная версия с ролями, но нужно
    // реализовать с ролями под каждый ивент.
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(mappedBy = "players")
    private Set<Game> games = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public @Nullable String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }
}
