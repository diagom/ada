package tech.bootcamp.desafio.ada.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id", nullable = false)
    private Long id;

    @Column(name = "damage_dice")
    private Integer damageDice;
    @Column(name = "dice_type")
    private Integer diceType;
    @Column(name = "health_points")
    private Integer healthPoints;
    private String type;
    private Integer strength;
    private Integer defence;
    private Integer agility;
    private String name;

}
