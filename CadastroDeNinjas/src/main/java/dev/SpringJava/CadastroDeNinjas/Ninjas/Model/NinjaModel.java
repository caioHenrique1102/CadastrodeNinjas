package dev.SpringJava.CadastroDeNinjas.Ninjas.Model;
import dev.SpringJava.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

//Entity tranforma uma classe em uma entidade no banco de dados
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    //usado para gerar os valores do id automaticamente e como serão gerados
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private String email;
    private int idade;

    //@ManyToOne -> Muitos ninjas podem ter apenas uma missão
    @ManyToOne
    private MissoesModel missoesModel;

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;

    }

    public NinjaModel(){

    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
