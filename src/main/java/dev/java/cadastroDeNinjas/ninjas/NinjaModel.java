package dev.java.cadastroDeNinjas.Ninjas;

import dev.java.cadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Entity ele transforma  uma classe em uma entidade do DB
// JPA - Java Persistence API
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class NinjaModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name ="name")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private  String imagUrl;

    @Column(name = "idade")
    private int idade;

    // @ManyToOne um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing Key ou chave estrangeira
    private List<MissoesModel> missoes;

}

