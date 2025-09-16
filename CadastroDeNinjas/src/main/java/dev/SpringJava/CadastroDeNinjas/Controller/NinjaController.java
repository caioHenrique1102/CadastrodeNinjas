package dev.SpringJava.CadastroDeNinjas.Controller;

import dev.SpringJava.CadastroDeNinjas.DTO.NinjaDTO;
import dev.SpringJava.CadastroDeNinjas.Entity.NinjaModel;
import dev.SpringJava.CadastroDeNinjas.Service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
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
        if (ninjaDTO.nome() == null || ninjaDTO.nome().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        NinjaModel ninja = new NinjaModel();
        ninja.setNome(ninjaDTO.nome());
        ninja.setEmail(ninjaDTO.email());
        ninja.setIdade(ninjaDTO.idade());

        NinjaModel cadastrado = ninjaService.Cadastrar(ninja);

        //Retornar uma mensagem para o front que o cliente foi criado com sucesso
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastrado);

    }

    @GetMapping("/buscar/{id}")
    public Optional<NinjaModel> BuscarNinja(@PathVariable Long id){return ninjaService.BuscarporNinja(id);}

    @DeleteMapping("/deletar/{id}")
    public void Deletar(Long id){ninjaService.Deletar(id);}

    //@PatchMapping("/altera/{id}")
    //public ResponseEntity<NinjaModel> AlterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja){
      //  Optional <NinjaModel> ninjaAlterado = ninjaService.Alterar(ninja, id);
      //  return
    //}



}
