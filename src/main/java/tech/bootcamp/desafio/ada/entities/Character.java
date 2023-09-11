package tech.bootcamp.desafio.ada.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "caracter", nullable = false)
    private Long id;
}
