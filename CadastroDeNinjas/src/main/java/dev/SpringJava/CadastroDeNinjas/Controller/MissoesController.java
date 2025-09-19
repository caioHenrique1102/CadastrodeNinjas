package dev.SpringJava.CadastroDeNinjas.Controller;

import dev.SpringJava.CadastroDeNinjas.DTO.MissoesDTO;
import dev.SpringJava.CadastroDeNinjas.Model.Entity.MissoesModel;
import dev.SpringJava.CadastroDeNinjas.Service.MissoesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/missoes")
public class MissoesController {
    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService){
        this.missoesService = missoesService;
    }

    @GetMapping("/cadastro")
    public ResponseEntity<MissoesModel> cadastroMissoes(@RequestBody MissoesDTO missoesDTO){
        if(missoesDTO.nome() == null || missoesDTO.nome().isEmpty()){
            return ResponseEntity.badRequest().build();
        }else {
           return ResponseEntity.ok(missoesService.CadastrarMissoes(missoesDTO));
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<MissoesModel> buscarMissoes(@PathVariable Long id){
        Optional<MissoesModel> optional = missoesService.BuscarMissao(id);

        return optional
                .map(missaoEncontrada -> ResponseEntity.ok(missaoEncontrada))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
