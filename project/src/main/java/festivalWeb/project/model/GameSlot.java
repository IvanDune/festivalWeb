package festivalWeb.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "game_slot")
public class GameSlot {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID gameSlotId;

    @Column(name = "date_time")
    private LocalDate dateTime;

    @Column(name = "max_game_value")
    private int maxGameValue;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id")
    private Set<Game> games;

}
