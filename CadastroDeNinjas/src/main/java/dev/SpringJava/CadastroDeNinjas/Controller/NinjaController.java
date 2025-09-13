package dev.SpringJava.CadastroDeNinjas.Controller;

import dev.SpringJava.CadastroDeNinjas.Entity.NinjaModel;
import dev.SpringJava.CadastroDeNinjas.Repository.NinjaRepository;
import dev.SpringJava.CadastroDeNinjas.Service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class NinjaController {
    @Autowired
    private NinjaRepository ninja;

    @GetMapping("/cadastro")
    public void cadastro(){

    }

}
