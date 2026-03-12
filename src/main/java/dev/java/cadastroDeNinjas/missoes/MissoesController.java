package dev.java.cadastroDeNinjas.missoes;


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

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }


    // Adicionar Missoes
    @PostMapping("/criar")
    public ResponseEntity<MissoesDTO> criarMissoes(@RequestBody MissoesDTO missoes) {
        MissoesDTO novaMissao = missoesService.criarMissoes(missoes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(novaMissao);
    }

    // Listar Missoes
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    //Listar Missoes por Id
    @GetMapping("/listar/{id}")
    public ResponseEntity<MissoesDTO> listarMissaoesPorId(@PathVariable Long id){
        MissoesDTO missao = missoesService.listarMissoesPorId(id);
        if ( missao != null) {
            return ResponseEntity.ok(missao);
        }
        return ResponseEntity.noContent().build();
    }

    // Altera os dados da missao
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        MissoesDTO atualizada = missoesService.atualizarMissao(id, missaoAtualizada);

        if (atualizada != null) {
            return ResponseEntity.ok(atualizada); // Retorna 200 OK com o objeto
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com ID " + id + " não encontrada."); // Retorna 404
        }
    }
    // Deletar missao
    @DeleteMapping("/deletar/{id}")
    public void deletarMissoesPorId(@PathVariable Long id){
        missoesService.deletarMissoesPorId(id);
    }

}
