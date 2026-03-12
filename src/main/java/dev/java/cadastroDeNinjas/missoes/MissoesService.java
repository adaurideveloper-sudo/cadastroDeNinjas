package dev.java.cadastroDeNinjas.missoes;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesMapper missoesMapper;
    private  final MissoesRepository missoesRepository;

    public MissoesService(MissoesMapper missoesMapper, MissoesRepository missoesRepository) {
        this.missoesMapper = missoesMapper;
        this.missoesRepository = missoesRepository;
    }

    // Criar missoes
    public MissoesDTO criarMissoes(MissoesDTO missoesDTO) {
        MissoesModel missoes = missoesMapper.map(missoesDTO);
        missoes = missoesRepository.save(missoes);
        return missoesMapper.map(missoes);
    }

    // listar todas minha missoes
    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoes =missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    // listar missoes por id
    public MissoesDTO listarMissoesPorId(Long id) {
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.map(missoesMapper::map)
                .orElse(null);
    }

    //Deletar por id
    public  void deletarMissoesPorId(Long id) {
        missoesRepository.deleteById(id);
    }


    public MissoesDTO atualizarMissao(Long id, MissoesDTO missoesDTO) {
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);

        if (missaoExistente.isPresent()) {
            MissoesModel missaoAtualizada = missoesMapper.map(missoesDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }
}
