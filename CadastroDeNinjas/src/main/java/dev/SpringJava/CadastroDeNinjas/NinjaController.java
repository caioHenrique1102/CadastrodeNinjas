package dev.SpringJava.CadastroDeNinjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return  "Essa é a minha primeira mensagem";
    }

}
