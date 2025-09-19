package dev.SpringJava.CadastroDeNinjas.Model.Repository;

import dev.SpringJava.CadastroDeNinjas.Model.Entity.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissoesRepository extends JpaRepository <MissoesModel, Long> {

}
