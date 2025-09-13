package dev.SpringJava.CadastroDeNinjas.Repository;

import dev.SpringJava.CadastroDeNinjas.Entity.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {


}
