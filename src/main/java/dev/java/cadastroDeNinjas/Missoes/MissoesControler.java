package dev.java.cadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MissoesControler {

    @GetMapping("/escolhaMissao")
    public String escolhaMissao() {
        return "Escolha sua missao nesta rota";
    }

}
