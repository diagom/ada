package tech.bootcamp.desafio.ada.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Log")
public class Player {

    @Id
    @Column(name = "PlayerEmail", nullable = false)
    private String id;

    private String name;
}
