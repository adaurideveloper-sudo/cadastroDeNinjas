package dev.java.cadastroDeNinjas.ninjas;
import dev.java.cadastroDeNinjas.missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "missoes")
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

    @Column(name = "rank")
    private String rank;



    // Relacionamento Many-to-One: muitos ninjas podem ter uma missão
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "missoes_id") // chave estrangeira
    private MissoesModel missoes;

}
