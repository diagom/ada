package tech.bootcamp.desafio.ada.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "round")
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "round_id", nullable = false)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "dice_roll")
    private List<Dice> diceRolls;

    @Column(name = "attacker_name")
    private String attackerName;
    @Column(name = "defender_name")
    private String defenderName;
    @Column(name = "roll_defender")
    private Integer rollDefender;
    @Column(name = "roll_attacker")
    private Integer rollAttacker;
    @Column(name = "total_rollDefender")
    private Integer totalRollDefender;
    @Column(name = "total_roll_attacker")
    private Integer totalRollAttacker;
    @Column(name = "total_damage")
    private Integer totalDamage;
    @Column(name = "was_attack_successful")
    private Boolean wasAttackSuccessful;
    @Column(name = "is_round_finished")
    private Boolean isRoundFinished;
}
