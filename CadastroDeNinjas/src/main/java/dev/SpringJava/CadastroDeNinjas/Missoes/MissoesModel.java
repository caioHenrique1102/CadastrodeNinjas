package dev.SpringJava.CadastroDeNinjas.Missoes;

import dev.SpringJava.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_empresas")
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nome;
    private String dificuldade;

    //@OneToMany -> Uma missão pode um ou muitos ninjas associadas a ela
    @OneToMany(mappedBy = "missoesModel")
    private List<NinjaModel> NinjaModel;

    public MissoesModel(){

    }

    public MissoesModel(String nome, String dificuldade){
        this.dificuldade = dificuldade;
        this.nome = nome;
        this.NinjaModel = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
}
