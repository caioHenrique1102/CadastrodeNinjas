package dev.SpringJava.CadastroDeNinjas.Entity;

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
    @OneToMany(mappedBy = "missoesModel")
    private List<NinjaModel> NinjaModel;
}
