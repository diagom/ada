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
    @Column(name = "roundId", nullable = false)
    private Long id;

    @OneToMany
    @JoinColumn(name = "damage_dice_id")
    private List<Dice> diceRolls;

    @JoinColumn(name = "attacker_name")
    private String attackerName;
    @JoinColumn(name = "defender_name")
    private String defenderName;
    @JoinColumn(name = "roll_defender")
    private String rollDefender;
    @JoinColumn(name = "roll_attacker")
    private String rollAttacker;
    @JoinColumn(name = "total_rollDefender")
    private String totalRollDefender;
    @JoinColumn(name = "total_roll_attacker")
    private String totalRollAttacker;
    @JoinColumn(name = "damage_total_damage")
    private String damageTotalDamage;
    @JoinColumn(name = "was_attack_successful")
    private Boolean wasAttackSuccessful;
    @JoinColumn(name = "is_round_finished")
    private Boolean isRoundFinished;
}
