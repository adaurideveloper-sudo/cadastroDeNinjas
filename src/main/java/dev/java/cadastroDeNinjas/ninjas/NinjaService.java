package dev.java.cadastroDeNinjas.ninjas;

import dev.java.cadastroDeNinjas.missoes.MissoesRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;
    private final MissoesRepository missoesRepository; // 1. Adicione o repositório de missões

    // 2. Atualize o construtor para injetar o novo repositório
    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper, MissoesRepository missoesRepository) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
        this.missoesRepository = missoesRepository;
    }

    public List<NinjaDTO> listarNinjas() {
        return ninjaRepository.findAll().stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO listarNinjaPorId(Long id) {
        return ninjaRepository.findById(id)
                .map(ninjaMapper::map)
                .orElse(null);
    }

    // 3. Criar Ninja com Interligação
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);

        // Se o DTO trouxer um ID de missão, buscamos no banco e associamos
        if (ninjaDTO.getMissaoId() != null) {
            missoesRepository.findById(ninjaDTO.getMissaoId())
                    .ifPresent(ninja::setMissoes);
        }

        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public void deletarNinjaPorid(Long id) {
        ninjaRepository.deleteById(id);
    }

    // 4. Atualizar Ninja com Interligação
    public NinjaDTO atualizaNinja(Long id, NinjaDTO ninjaDTO) {
        return ninjaRepository.findById(id)
                .map(existente -> {
                    // 1. Converte o DTO para o modelo (mantendo o ID da URL)
                    NinjaModel ninja = ninjaMapper.map(ninjaDTO);
                    ninja.setId(id);

                    // 2. Busca e vincula a missão se o ID foi enviado
                    if (ninjaDTO.getMissaoId() != null) {
                        missoesRepository.findById(ninjaDTO.getMissaoId())
                                .ifPresent(ninja::setMissoes);
                    }

                    // 3. Salva e converte de volta para DTO
                    return ninjaMapper.map(ninjaRepository.save(ninja));
                })
                .orElse(null); // Retorna null se o ID não for encontrado (o Controller trata o 404)
    }
}