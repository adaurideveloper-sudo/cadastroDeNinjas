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
public class MissoesControler {

    private MissoesService missoesService;

    public MissoesControler(MissoesService missoesService) {
        this.missoesService = missoesService;
    }


    // Adicionar Missoes
    @PostMapping("/criar")
    public MissoesModel criarMissoes(@RequestBody MissoesModel missoes) {
        return missoesService.criarMissoes(missoes);
    }

    // Listar Missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(MissoesModel missoes) {
        return missoesService.listarMissoes();
    }

    //Listar Missoes por Id
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissaoesPorId(@PathVariable Long id){
        return missoesService.listarMissoesPorId(id);
    }

    // Altera os dados da missao
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody MissoesModel missao) {
        MissoesModel atualizada = missoesService.atualizarMissao(id, missao);

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
