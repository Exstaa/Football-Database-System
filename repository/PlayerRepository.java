package az.hafizrzazade.footballdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.hafizrzazade.footballdatabase.model.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
