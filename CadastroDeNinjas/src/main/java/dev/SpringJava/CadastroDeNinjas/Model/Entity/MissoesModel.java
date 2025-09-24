package dev.SpringJava.CadastroDeNinjas.Model.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.SpringJava.CadastroDeNinjas.DTO.MissoesDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private String dificuldade;

    //@OneToMany -> Uma missão pode um ou muitos ninjas associadas a ela
    //mappedBy = "missao" é para evitar que o sistema crie tabelas extras
    //a responsabilidade de guardar a conexão (o missao_id)
    // já é do Ninja. Eu só quero ver a lista aqui".
    @OneToMany(mappedBy = "missoesModel")
    @JsonManagedReference
    private List<NinjaModel> ninjaModel;
    public MissoesModel(MissoesDTO missoesDTO) {
        Id = missoesDTO.id();
        this.nome = missoesDTO.nome();
        this.dificuldade = missoesDTO.dificuldade();
    }


}
