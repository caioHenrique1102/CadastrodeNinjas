package dev.SpringJava.CadastroDeNinjas.Controller;

import dev.SpringJava.CadastroDeNinjas.DTO.MissoesDTO;
import dev.SpringJava.CadastroDeNinjas.Model.Entity.MissoesModel;
import dev.SpringJava.CadastroDeNinjas.Model.Entity.NinjaModel;
import dev.SpringJava.CadastroDeNinjas.Service.MissoesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/missoes")
public class MissoesController {
    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService){
        this.missoesService = missoesService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<MissoesModel> cadastroMissoes(@RequestBody MissoesDTO missoesDTO){
        if(missoesDTO.nome() == null || missoesDTO.nome().isEmpty()){
            return ResponseEntity.badRequest().build();
        }else {
           return ResponseEntity.ok(missoesService.CadastrarMissoes(missoesDTO));
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<MissoesModel> buscarMissoes(@PathVariable Long id){
        return ResponseEntity.ok(missoesService.BuscarMissao(id));
    }

    @GetMapping("/listar/{id}")
    public List<NinjaModel> listarNinjas(@PathVariable Long id){
        return missoesService.ListadeNinjas(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id){
        missoesService.Deletar(id);
    }

    @PutMapping("/{idNinja}/{idMissao}")
    public ResponseEntity<NinjaModel> ninjaParaMissao(@PathVariable Long idNinja, @PathVariable Long idMissao){

        NinjaModel ninja = missoesService.colocarNinjaEmMissao(idNinja, idMissao);

        if(ninja != null){
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
