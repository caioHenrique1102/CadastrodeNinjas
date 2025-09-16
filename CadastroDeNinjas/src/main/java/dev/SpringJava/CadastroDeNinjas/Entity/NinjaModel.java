package dev.SpringJava.CadastroDeNinjas.Entity;
import dev.SpringJava.CadastroDeNinjas.DTO.NinjaDTO;
import jakarta.persistence.*;
import lombok.*;

//Entity tranforma uma classe em uma entidade no banco de dados
@Entity
@Table(name = "tb_cadastro")
@Getter // cria getter automaticamente
@Setter // cria setter automaticamente
@NoArgsConstructor //cria construtores sem argumentos
@AllArgsConstructor // cria construtores com todos os argumentos
public class NinjaModel {


    public NinjaModel(NinjaDTO ninjaDTO) {
        Id = ninjaDTO.Id();
        this.nome = ninjaDTO.nome();
        this.email = ninjaDTO.email();
        this.idade = ninjaDTO.idade();
        this.missoesModel = ninjaDTO.missoesModel();
    }

    @Id
    //usado para gerar os valores do id automaticamente e como serão gerados
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private String email;
    private int idade;

    //@ManyToOne -> Muitos ninjas podem ter apenas uma missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Chave estrangeira
    private MissoesModel missoesModel;

}
