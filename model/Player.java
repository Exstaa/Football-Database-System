package az.hafizrzazade.footballdatabase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Player {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String playerFullname;
  private int playerAge;
  private String playerNationality;
  private int playerNumber;
  @ManyToOne
  @JoinColumn(name="team_id")
  private Team team;
}
