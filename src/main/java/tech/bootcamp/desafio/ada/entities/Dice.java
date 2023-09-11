package tech.bootcamp.desafio.ada.entities;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "dice_roll")
public class Dice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "dice_id", nullable = false)
    private Long id;

    @Column(name = "dice_type")
    private Integer diceType;
    @Column(name = "dice_roll_result")
    private Integer diceRollResult;
}
