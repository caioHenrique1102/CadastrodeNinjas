package dev.SpringJava.CadastroDeNinjas.Service;

import dev.SpringJava.CadastroDeNinjas.Entity.MissoesModel;
import dev.SpringJava.CadastroDeNinjas.Repository.MissoesRepository;

import java.util.List;
import java.util.Optional;

public class MissoesService {
   private final MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public MissoesModel CadastrarMissoes(MissoesModel missoesModel){
       return missoesRepository.save(missoesModel);
    }

    public Optional<MissoesModel> BuscarMissao(Long id){
        return missoesRepository.findById(id);
    }

    public List<MissoesModel> ListaMissoes(){
        return missoesRepository.findAll();
    }

    public void Deletar(Long id){
        missoesRepository.deleteById(id);
    }


}
