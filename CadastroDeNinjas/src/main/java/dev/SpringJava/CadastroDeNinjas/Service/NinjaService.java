package dev.SpringJava.CadastroDeNinjas.Service;
import dev.SpringJava.CadastroDeNinjas.DTO.NinjaDTO;
import dev.SpringJava.CadastroDeNinjas.Model.Entity.NinjaModel;
import dev.SpringJava.CadastroDeNinjas.Model.Repository.NinjaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
    }

     public Optional <NinjaModel> BuscarporNinja(Long id){
        if(ninjaRepository.existsById(id)){
            return ninjaRepository.findById(id);
        }else {
            return Optional.empty();
        }
    }

     public NinjaModel Cadastrar(NinjaDTO ninjaDTO){
         NinjaModel ninja = new NinjaModel();
         ninja.setNome(ninjaDTO.nome());
         ninja.setEmail(ninjaDTO.email());
         ninja.setIdade(ninjaDTO.idade());
        return ninjaRepository.save(ninja);
     }

     public void Deletar (Long id){
        ninjaRepository.deleteById(id);
     }

     //Optional é como uma caixa. Em vez do método te entregar o item diretamente
     //ele te entrega uma caixa. Essa caixa pode:
     //-Conter o item que você pediu.
     //-Estar vazia.
     public NinjaModel Alterar(NinjaDTO ninjaAlterado, Long id){

           NinjaModel ninjaExiste = ninjaRepository.findById(id)
                   .orElseThrow(() -> new RuntimeException("Error o ninja de id " + id + " não foi encontrado"));
            ninjaExiste.setNome(ninjaAlterado.nome());
            ninjaExiste.setEmail(ninjaAlterado.email());
            ninjaExiste.setIdade(ninjaAlterado.idade());

            //salva as alterações do ninja no banco de dados
            return ninjaRepository.save(ninjaExiste);
        }
     public List<NinjaModel> ListarNinja(){
        return ninjaRepository.findAll();
     }

}
