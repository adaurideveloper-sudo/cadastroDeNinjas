package dev.java.cadastroDeNinjas.missoes;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private  MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Adicionar missoes
    public MissoesModel criarMissoes(MissoesModel missoes) {
        return missoesRepository.save(missoes);
    }

    // listar todas minha missoes
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    // listar missoes por id
    public MissoesModel listarMissoesPorId(Long id) {
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.orElse(null);
    }

    //Deletar por id
    public  void deletarMissoesPorId(Long id) {
        missoesRepository.deleteById(id);
    }


    public MissoesModel atualizarMissao(Long id, MissoesModel missao) {
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);

        if (missaoExistente.isPresent()) {
            MissoesModel missaoNoBanco = missaoExistente.get();

            missaoNoBanco.setNome(missao.getNome()); // mudei aqui
            missaoNoBanco.setDificuldade(missao.getDificuldade()); // e aqui

            return missoesRepository.save(missaoNoBanco);
        }
        return null;
    }
}
