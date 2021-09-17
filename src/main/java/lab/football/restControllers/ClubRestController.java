package lab.football.restControllers;

import lab.football.dao.ClubDAO;
import lab.football.dao.PlayerDAO;
import lab.football.mappers.ClubMapper;
import lab.football.mappers.LeagueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clubs")
public class ClubRestController {
    private final ClubDAO clubDAO;
    private final PlayerDAO playerDAO;
    @Autowired
    public ClubRestController(ClubDAO clubDAO, PlayerDAO playerDAO) {
        this.clubDAO = clubDAO;
        this.playerDAO = playerDAO;
    }
    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    private String getClubs(){
        return clubDAO.index().toString();
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    private String getClub(@PathVariable int id){
        return clubDAO.show(id).toString() + "\n" + playerDAO.showClub(id);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    private void setClub(@RequestBody String str){
        clubDAO.save(new ClubMapper().fromString(str));
    }
    @PatchMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    private void updateClub(@RequestBody String str,@PathVariable int id){
        clubDAO.update(id,new ClubMapper().fromString(str));
    }
    @DeleteMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    private void deleteClub(@PathVariable int id){
        clubDAO.delete(id);
    }
}
