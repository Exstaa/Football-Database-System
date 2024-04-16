package az.hafizrzazade.footballdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.hafizrzazade.footballdatabase.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{

}
