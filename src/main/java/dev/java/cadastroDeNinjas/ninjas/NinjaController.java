package dev.java.cadastroDeNinjas.ninjas;
import org.springframework.web.bind.annotation.*;
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
    public String criarNinja() {
        return "Ninja criado";
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
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Ninja deletado por id";
    }



}
