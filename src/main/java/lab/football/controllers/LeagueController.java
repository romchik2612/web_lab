package lab.football.controllers;

import lab.football.dao.ClubDAO;
import lab.football.dao.LeagueDAO;
import lab.football.models.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/leagues")
public class LeagueController {
    private final LeagueDAO leagueDAO;
    private final ClubDAO clubDAO;
@Autowired
    public LeagueController(LeagueDAO leagueDAO, ClubDAO clubDAO) {
        this.leagueDAO = leagueDAO;
        this.clubDAO = clubDAO;
    }

    @GetMapping()
    private String index(Model model){
        model.addAttribute("leagues",leagueDAO.index());
        return "leagues/index.html";
    }

    @GetMapping("/{id}")
    private String show(@PathVariable("id") int id,Model model){
        model.addAttribute("league",leagueDAO.show(id));
        model.addAttribute("clubs",clubDAO.showLeague(leagueDAO.show(id).getId()));
        return "leagues/show.html";
    }

    @GetMapping("/new")
    private String createLeague(@ModelAttribute("league") League league){
        return "leagues/new.html";
    }

    @PostMapping("/new")
    private String create(@ModelAttribute("league") @Valid League league, BindingResult bindingResult){
        if(bindingResult.hasErrors())return "leagues/new.html";
        leagueDAO.save(league);
        return "redirect:/leagues";
    }
    @GetMapping("/{id}/edit")
    private String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("league",leagueDAO.show(id));
        return "leagues/edit.html";
    }
    @PatchMapping("/{id}/edit")
    private String update(@ModelAttribute("league") @Valid League league, BindingResult bindingResult, @PathVariable("id") int id){
        if(bindingResult.hasErrors())return "leagues/edit.html";
        leagueDAO.update(id,league);
        return "redirect:/leagues";
    }
    @DeleteMapping("/{id}")
    private String delete(@PathVariable("id") int id){
        leagueDAO.delete(id);
        return "redirect:/leagues";
    }
}
