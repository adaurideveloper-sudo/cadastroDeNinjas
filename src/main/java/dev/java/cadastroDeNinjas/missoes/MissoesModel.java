package dev.java.cadastroDeNinjas.missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java.cadastroDeNinjas.ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="dificuldade")
    private String dificuldade;

    @Column(name="nome")
    private String nome;

    // Relacionamento One-to-Many: uma missão pode ter vários ninjas
    @OneToMany(mappedBy = "missao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<NinjaModel> ninjas;
}