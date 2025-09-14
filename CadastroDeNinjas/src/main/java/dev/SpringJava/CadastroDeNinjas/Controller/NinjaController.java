package dev.SpringJava.CadastroDeNinjas.Controller;

import dev.SpringJava.CadastroDeNinjas.DTO.NinjaDTO;
import dev.SpringJava.CadastroDeNinjas.Entity.NinjaModel;
import dev.SpringJava.CadastroDeNinjas.Service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }



    @PostMapping("/cadastro")
    public ResponseEntity<NinjaModel> cadastro(@RequestBody NinjaDTO ninjaDTO) {
        //vai verificar se as informações do formulario é boa
        if (ninjaDTO.getNome() == null || ninjaDTO.getNome().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        NinjaModel ninja = new NinjaModel();
        ninja.setNome(ninjaDTO.getNome());
        ninja.setEmail(ninjaDTO.getEmail());
        ninja.setIdade(ninjaDTO.getIdade());

        NinjaModel cadastrado = ninjaService.Cadastrar(ninja);

        //Retornar uma mensagem para o front que o cliente foi criado com sucesso
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastrado);

    }

    @GetMapping("/buscar/{id}")
    public Optional<NinjaModel> BuscarNinja(@PathVariable Long id){
        return ninjaService.BuscarporId(id);
    }
}
