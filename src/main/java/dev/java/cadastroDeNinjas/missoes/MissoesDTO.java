package dev.java.cadastroDeNinjas.missoes;
import dev.java.cadastroDeNinjas.ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    private Long id;
    private String dificuldade;
    private String nome;
    private List<NinjaModel> ninjas;

}
