package dev.SpringJava.CadastroDeNinjas;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class NinjaModel {

    @Id
    private Long Id;
    private String nome;
    private String email;
    private int idade;

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public NinjaModel(){

    }
}
