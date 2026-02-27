package dev.java.cadastroDeNinjas.missoes;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/missoes")
public class MissoesControler {

    @GetMapping("/listar")
    public String listar() {
        return "Escolha sua missao nesta rota";
    }

}
