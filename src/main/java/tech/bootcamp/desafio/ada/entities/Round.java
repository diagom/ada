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
    @JoinColumn(name = "diceId")
    private List<Dice> diceRolls;

    private String AttackerName;
    private String DefenderName;
    private String rollDefender;
    private String rollAttacker;
    private String totalRollDefender;
    private String totalRollAttacker;
    private Boolean wasAttackSuccessful;
    private String damageTotalDamage;
}
