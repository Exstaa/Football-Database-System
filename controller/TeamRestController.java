package az.hafizrzazade.footballdatabase.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.hafizrzazade.footballdatabase.model.Team;
import az.hafizrzazade.footballdatabase.repository.TeamRepository;

@RestController
@RequestMapping("/api/teams")
public class TeamRestController {

	@Autowired
	private TeamRepository teamRepo;
	
	@PostMapping("/addTeam")
	public ResponseEntity<Team> addteam(@RequestBody Team team) {
		team.setId(0);
		Team resultTeam = teamRepo.save(team);
		return new ResponseEntity<Team>(resultTeam, HttpStatus.CREATED);
	}

	@GetMapping("/getTeam/{id}")
	public ResponseEntity<Team> getteam(@PathVariable Integer id) {
		Optional<Team> resultTeam = teamRepo.findById(id);

		return new ResponseEntity<Team>(resultTeam.get(), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteTeam/{id}")
	public ResponseEntity<Team> deleteteam(@PathVariable Integer id) {
		Optional<Team> resultTeam = teamRepo.findById(id);
		if (!resultTeam.isEmpty()) {
			teamRepo.delete(resultTeam.get());
		}

		return new ResponseEntity<Team>(resultTeam.get(), HttpStatus.ACCEPTED);

	}
}
