package lab.football.controllers;

import lab.football.dao.ClubDAO;
import lab.football.dao.LeagueDAO;
import lab.football.dao.PlayerDAO;
import lab.football.models.Club;
import lab.football.models.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clubs")
public class ClubController {
    private final ClubDAO clubDAO;
    private final PlayerDAO playerDAO;
    private final LeagueDAO leagueDAO;
@Autowired
    public ClubController(ClubDAO clubDAO, PlayerDAO playerDAO, LeagueDAO leagueDAO) {
        this.clubDAO = clubDAO;
        this.playerDAO = playerDAO;
        this.leagueDAO = leagueDAO;
    }

    @GetMapping()
    private String index(Model model){
        model.addAttribute("clubs",clubDAO.index());
        return "clubs/index.html";
    }
    @GetMapping("/{id}")
    private String show(@PathVariable("id") int id,Model model){
        model.addAttribute("club",clubDAO.show(id));
        model.addAttribute("players",playerDAO.showClub(clubDAO.show(id).getId()));
        model.addAttribute("league",leagueDAO.show(clubDAO.show(id).getLeague_id()));
        return "clubs/show.html";
    }
    @GetMapping("/{id}/new")
    private String createClub(@ModelAttribute("club") Club club){
        return "clubs/new.html";
    }

    @PostMapping("/{id}/new")
    private String create(@ModelAttribute("club") Club club, @PathVariable("id") int league_id){
        club.setLeague_id(league_id);
        clubDAO.save(club);
        return "redirect:/clubs";
    }
    @GetMapping("/{id}/edit")
    private String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("club",clubDAO.show(id));
        return "clubs/edit.html";
    }
    @PatchMapping("/{id}/edit")
    private String update(@ModelAttribute("club") Club club,@PathVariable("id") int id){
        clubDAO.update(id,club);
        return "redirect:/clubs";
    }
    @DeleteMapping("/{id}")
    private String delete(@PathVariable("id") int id){
        clubDAO.delete(id);
        return "redirect:/clubs";
    }

}
