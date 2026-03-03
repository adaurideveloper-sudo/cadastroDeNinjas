package dev.java.cadastroDeNinjas.ninjas;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping("/ninjas")
@RestController
public class NinjaController {

   private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasvindas() {
        return "Essa é a minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Procurar Ninja por ID (CREATE)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinja() {
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja(READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarNinjaPorId(id);
    }

    // Altera os dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorid() {
        return "alterar Ninja por id";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public  void deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorid(id);
    }

}
