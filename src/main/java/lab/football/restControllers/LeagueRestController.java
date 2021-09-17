package lab.football.restControllers;



import lab.football.dao.LeagueDAO;
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

    @Autowired
    public LeagueRestController(LeagueDAO leagueDAO) {
        this.leagueDAO = leagueDAO;
    }
    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private String getLeagues(HttpServletResponse response){

        return leagueDAO.index().toString();
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, headers = "content-type=text/html;charset=utf-8")
    private void setLeague(@RequestBody League league){
        leagueDAO.save(league);
    }
}
