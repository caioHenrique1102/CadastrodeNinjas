package dev.SpringJava.CadastroDeNinjas.Service;
import dev.SpringJava.CadastroDeNinjas.Entity.NinjaModel;
import dev.SpringJava.CadastroDeNinjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
    }

     public List<NinjaModel> ListarNinja(){
        return ninjaRepository.findAll();
     }

     public Optional <NinjaModel> BuscarporId(Long id){
            return ninjaRepository.findById(id);
    }

     public NinjaModel Cadastrar(NinjaModel ninjaModel){
         return ninjaRepository.save(ninjaModel);
     }

     public void Deletar (Long id){
       ninjaRepository.deleteById(id);
     }
}
