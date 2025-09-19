package dev.SpringJava.CadastroDeNinjas.Model.Repository;

import dev.SpringJava.CadastroDeNinjas.Model.Entity.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {


}
