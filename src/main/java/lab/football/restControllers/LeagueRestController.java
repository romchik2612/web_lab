package lab.football.restControllers;



import lab.football.dao.ClubDAO;
import lab.football.dao.LeagueDAO;
import lab.football.mappers.LeagueMapper;
import lab.football.models.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/leagues")
public class LeagueRestController {
    private final LeagueDAO leagueDAO;
    private final ClubDAO clubDAO;
    @Autowired
    public LeagueRestController(LeagueDAO leagueDAO, ClubDAO clubDAO) {
        this.leagueDAO = leagueDAO;
        this.clubDAO = clubDAO;
    }
    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    private String getLeagues(){
        return leagueDAO.index().toString();
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    private String getLeague(@PathVariable int id){
        return leagueDAO.show(id).toString() + "\n" + clubDAO.showLeague(id);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    private void setLeague(@RequestBody String str){
        leagueDAO.save(new LeagueMapper().fromString(str));
    }
    @PatchMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    private void updateLeague(@RequestBody String str,@PathVariable int id){
        leagueDAO.update(id,new LeagueMapper().fromString(str));
    }
    @DeleteMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    private void deleteLeague(@PathVariable int id){
        leagueDAO.delete(id);
    }

}
