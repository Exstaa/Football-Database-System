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
import az.hafizrzazade.footballdatabase.model.Player;
import az.hafizrzazade.footballdatabase.repository.PlayerRepository;

@RestController
@RequestMapping("/api/players")
public class PlayerRestController {
	@Autowired
	private PlayerRepository playerRepo;

	@PostMapping("/addPlayer")
	public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
		player.setId(0);
		Player resultPlayer = playerRepo.save(player);
		return new ResponseEntity<Player>(resultPlayer, HttpStatus.CREATED);
	}

	@GetMapping("/getPlayer/{id}")
	public ResponseEntity<Player> getPlayer(@PathVariable Integer id) {
		Optional<Player> resultPlayer = playerRepo.findById(id);

		return new ResponseEntity<Player>(resultPlayer.get(), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deletePlayer/{id}")
	public ResponseEntity<Player> deletePlayer(@PathVariable Integer id) {
		Optional<Player> resultPlayer = playerRepo.findById(id);
		if (!resultPlayer.isEmpty()) {
			playerRepo.delete(resultPlayer.get());
		}

		return new ResponseEntity<Player>(resultPlayer.get(), HttpStatus.ACCEPTED);

	}
}
