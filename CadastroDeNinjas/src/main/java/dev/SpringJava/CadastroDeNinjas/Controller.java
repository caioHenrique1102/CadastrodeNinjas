package dev.SpringJava.CadastroDeNinjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class Controller {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return  "Essa é a minha primeira mensagem";
    }

}
