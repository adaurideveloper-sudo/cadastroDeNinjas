package dev.java.cadastroDeNinjas.ninjas;

import dev.java.cadastroDeNinjas.missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name="img_url")
    private String imgUrl;

    @Column(name="idade")
    private int idade;

    // Relacionamento Many-to-One: muitos ninjas podem ter uma missão
    @ManyToOne
    @JoinColumn(name = "missao_id") // chave estrangeira
    private MissoesModel missao;
}
