package everis.desafio.desafio.repository;

import org.springframework.stereotype.Repository;
import everis.desafio.desafio.model.Campanha;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Integer> {

}