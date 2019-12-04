package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Chamada;

public interface ChamadaRepository extends JpaRepository<Chamada, Integer> {

}
