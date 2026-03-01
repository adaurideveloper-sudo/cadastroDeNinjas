package dev.java.cadastroDeNinjas.missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private  MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // listar todas minha missoes
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }



}
