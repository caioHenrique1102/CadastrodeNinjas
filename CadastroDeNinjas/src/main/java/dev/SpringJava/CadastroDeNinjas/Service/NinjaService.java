package dev.SpringJava.CadastroDeNinjas.Service;
import dev.SpringJava.CadastroDeNinjas.DTO.NinjaDTO;
import dev.SpringJava.CadastroDeNinjas.Entity.NinjaModel;
import dev.SpringJava.CadastroDeNinjas.Repository.NinjaRepository;
import org.springframework.http.ResponseEntity;
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

     public Optional <NinjaModel> BuscarporNinja(Long id){
            return ninjaRepository.findById(id);
    }

     public NinjaModel Cadastrar(NinjaModel ninjaModel){

        return ninjaRepository.save(ninjaModel);
     }

     public void Deletar (Long id){
        ninjaRepository.deleteById(id);
     }


     //Optional é como uma caixa. Em vez do método te entregar o item diretamente
     //ele te entrega uma caixa. Essa caixa pode:
     //-Conter o item que você pediu.
     //-Estar vazia.
     public Optional<NinjaModel> Alterar(NinjaDTO ninjaAlterado, Long id){
        // linha para verficar se o ninja existe na caixa pelo ID
        Optional<NinjaModel> NinjaExiste = ninjaRepository.findById(id);
        //se o ninja existe na caixa optional ele vai atualizar as informações
        if(NinjaExiste.isPresent()){

            NinjaModel ninja = NinjaExiste.get();

            ninja.setNome(ninjaAlterado.nome());
            ninja.setEmail(ninjaAlterado.email());
            ninja.setIdade(ninjaAlterado.idade());

            //salva as alterações do ninja no banco de dados
            return Optional.of(ninjaRepository.save(ninja));

        }else {
            return Optional.empty();
        }
     }
}
