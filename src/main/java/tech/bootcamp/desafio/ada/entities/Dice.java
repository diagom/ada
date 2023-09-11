package tech.bootcamp.desafio.ada.entities;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "diceRoll")
public class Dice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "diceId", nullable = false)
    private Long id;

    private String diceType;
    private int dataResult;
}
