package festivalWeb.project.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "games")
public class Game {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "masterId")
    private UUID masterId;

    @Column(name = "title")
    private String title;

    @Column(name = "systemTtrpg")
    @Enumerated(EnumType.STRING)
    private SystemTtrpg system;

    @Column(name = "description")
    private String description;

    @Column(name = "maxPlayerValue")
    private Integer maxPlayerValue;

    @Column(name = "minPlayerValue")
    private Integer minPlayerValue;

    @Column(name = "dateTime")
    private LocalDateTime dateTime;

    @ManyToMany(fetch = FetchType.LAZY)
    @Column(name = "players")
    @JoinTable(
            name = "game_user",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @ToString.Exclude
    Set<User> players = new HashSet<>();

}
