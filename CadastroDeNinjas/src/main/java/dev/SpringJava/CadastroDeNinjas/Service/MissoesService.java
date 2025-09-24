package dev.SpringJava.CadastroDeNinjas.Service;
import dev.SpringJava.CadastroDeNinjas.DTO.MissoesDTO;
import dev.SpringJava.CadastroDeNinjas.Model.Entity.MissoesModel;
import dev.SpringJava.CadastroDeNinjas.Model.Entity.NinjaModel;
import dev.SpringJava.CadastroDeNinjas.Model.Repository.MissoesRepository;
import dev.SpringJava.CadastroDeNinjas.Model.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class MissoesService {
   private final MissoesRepository missoesRepository;
   private final NinjaRepository ninjaRepository;

    public MissoesService(MissoesRepository missoesRepository, NinjaRepository ninjaRepository) {
        this.missoesRepository = missoesRepository;
        this.ninjaRepository = ninjaRepository;
    }



    public NinjaModel colocarNinjaEmMissao(Long idNinja, Long idMissao){
        //vai procurar o ninja se achar vai retornar ele, se não vai retornar null
        //o mesmo com missoes
       NinjaModel ninja = ninjaRepository.findById(idNinja).orElse(null);
       MissoesModel missoes = missoesRepository.findById(idMissao).orElse(null);

       if(ninja != null && missoes != null ){
           ninja.setMissoesModel(missoes);

           return ninjaRepository.save(ninja);
       }

       return null;
    }

    public MissoesModel CadastrarMissoes(MissoesDTO missoesDTO){
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setNome(missoesDTO.nome());
        missoesModel.setDificuldade(missoesDTO.dificuldade());

       return missoesRepository.save(missoesModel);
    }

    public MissoesModel BuscarMissao(Long id){

        return missoesRepository.findById(id).orElseThrow(() -> new RuntimeException("Missão não encontrada"));
    }

    public List<NinjaModel> ListadeNinjas(Long id){
        MissoesModel buscarMissao =  BuscarMissao(id);
        if(buscarMissao != null){
            return buscarMissao.getNinjaModel();
        }
          //retorna uma lista vazia
        return Collections.emptyList();

    }

    public void Deletar(Long id){
        missoesRepository.deleteById(id);
    }


}
