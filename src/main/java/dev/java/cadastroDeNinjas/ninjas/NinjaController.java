package dev.java.cadastroDeNinjas.ninjas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/ninjas")
@RestController
public class NinjaController {

   private final NinjaService ninjaService;



    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasvindas() {
        return "Essa é a minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());

    }

    // Procurar Ninja por ID
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Mostrar ninja(READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        dev.java.cadastroDeNinjas.ninjas.NinjaDTO ninja  = ninjaService.listarNinjaPorId(id);
        if (ninja !=null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id: " + id + " nao existe nos nossos registros.");
        }
    }

    // Altera os dados dos ninjas (UPDATE)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarNinja(@PathVariable Long id,@RequestBody NinjaDTO ninjaAtualizado) {

        NinjaDTO ninja = ninjaService.atualizaNinja(id, ninjaAtualizado);
        if ( ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id: " + id + " nao existe nos nossos registros.");
        }
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public  ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {

        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.deletarNinjaPorid(id);
            return ResponseEntity.ok("Ninja com o ID " + id + " deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + " nao encontrado");
        }

    }

}
