package dev.java.cadastroDeNinjas.ninjas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    //private MissoesModel missao;
    private String rank;
    private Long missaoId;

}
