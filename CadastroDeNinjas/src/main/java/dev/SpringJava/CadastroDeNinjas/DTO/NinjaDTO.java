package dev.SpringJava.CadastroDeNinjas.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NinjaDTO {
    private Long Id;
    private String nome;
    private String email;
    private int idade;
}
