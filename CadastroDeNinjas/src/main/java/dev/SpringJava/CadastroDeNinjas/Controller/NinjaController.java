package dev.SpringJava.CadastroDeNinjas.Controller;

import dev.SpringJava.CadastroDeNinjas.DTO.NinjaDTO;
import dev.SpringJava.CadastroDeNinjas.Model.Entity.NinjaModel;
import dev.SpringJava.CadastroDeNinjas.Service.NinjaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        if (ninjaDTO.nome() == null || ninjaDTO.nome().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }else {
            return ResponseEntity.ok(ninjaService.Cadastrar(ninjaDTO));
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<NinjaModel> buscarNinja(@PathVariable Long id){
        Optional<NinjaModel> buscarNinja= ninjaService.BuscarporNinja(id);

        return buscarNinja
                // Se o Optional tiver um valor, TRANSFORME-O em um ResponseEntity.ok(...)
                .map( ninjaEcontrado-> ResponseEntity.ok(ninjaEcontrado))
                // Senão, retorne um ResponseEntity.notFound()
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletar/{id}")
    public void Deletar(@PathVariable Long id){
        ninjaService.Deletar(id);
    }

    @PatchMapping("/altera/{id}")
    public ResponseEntity<NinjaModel> alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja){
        Optional <NinjaModel> optional = ninjaService.Alterar( ninja, id);

        return optional
                // ele pega o optinal e transforma em ResponseEntity
                .map(ninjaAlterado -> ResponseEntity.ok(ninjaAlterado))
                //caso esteja vazio, ele retornar um badRequest
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.ListarNinja();
    }



}
