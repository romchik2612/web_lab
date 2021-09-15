package lab.football.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/resources","/leagues/resources","/clubs/resources","/players/resources","/leagues/{id}/resources","/clubs/{id}/resources","/players/{id}/resources"})
public class ResourcesController {
    @GetMapping("/mainstyle.css")
    private String getMain(){
        return "/resources/mainstyle.css";
    }
    @GetMapping("/liststyle.css")
    private String getList(){return "/resources/liststyle.css";}
}
