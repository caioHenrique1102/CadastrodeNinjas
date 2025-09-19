package dev.SpringJava.CadastroDeNinjas.DTO;


import dev.SpringJava.CadastroDeNinjas.Model.Entity.MissoesModel;

public record NinjaDTO (Long Id, String nome, String email , int idade, MissoesModel missoesModel){

}
