package dev.java.cadastroDeNinjas.ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO) {
              NinjaModel ninjaModel = new NinjaModel();
              ninjaModel.setId(ninjaDTO.getId());
              ninjaModel.setNome(ninjaDTO.getNome());
              ninjaModel.setEmail(ninjaDTO.getEmail());
              ninjaModel.setImgUrl(ninjaDTO.getImgUrl());
              ninjaModel.setIdade(ninjaDTO.getIdade());
              ninjaModel.setRank(ninjaDTO.getRank());



              return ninjaModel;
          }

          public NinjaDTO map(NinjaModel ninjaModel) {
              NinjaDTO ninjaDTO = new NinjaDTO();
              ninjaDTO.setId(ninjaModel.getId());
              ninjaDTO.setNome(ninjaModel.getNome());
              ninjaDTO.setEmail(ninjaModel.getEmail());
              ninjaDTO.setImgUrl(ninjaModel.getImgUrl());
              ninjaDTO.setIdade(ninjaModel.getIdade());
              ninjaDTO.setRank(ninjaModel.getRank());
              if (ninjaModel.getMissoes() != null) {
                  ninjaDTO.setMissaoId(ninjaModel.getMissoes().getId());
              }

              return ninjaDTO;

          }

}
