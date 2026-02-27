package dev.java.cadastroDeNinjas.ninjas;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ninjas")
@RestController
public class NinjaController {


    @GetMapping("/boasvindas")
    public String boasvindas() {
        return "Essa é a minha primeira mensagem nessa rota";
    }
}
