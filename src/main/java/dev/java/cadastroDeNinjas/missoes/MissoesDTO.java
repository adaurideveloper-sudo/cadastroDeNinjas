package dev.java.cadastroDeNinjas.missoes;
import com.fasterxml.jackson.annotation.JsonInclude;
import dev.java.cadastroDeNinjas.ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MissoesDTO {

    private Long id;
    private String dificuldade;
    private String nome;
    //private List<NinjaModel> ninjas;

}
