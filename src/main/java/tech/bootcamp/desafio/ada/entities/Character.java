package tech.bootcamp.desafio.ada.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "character_id", nullable = false)
    private Long id;

    @Column(name = "damage_dice", nullable = false)
    private String DamageDice;
    @Column(name = "dice_type", nullable = false)
    private String diceType;
    @Column(name = "health_points", nullable = false)
    private String HealthPoints;
    private String Type;
    private String Name;
    private String Strength;
    private String Defence;
    private String Agility;

}
