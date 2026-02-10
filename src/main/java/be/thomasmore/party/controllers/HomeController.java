package be.thomasmore.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/","/home"})
    public String home(Model model){
        int mycalculatedvalue = 34 * 62;
        model.addAttribute("mycalculatedvalue", mycalculatedvalue);
    return "home";
    }

    @GetMapping("/about")
    public String about(Model model){
        String myname = "Evelyne";
        String mystreet = "105 eepyville";
        String mytown= "eepytown";
        model.addAttribute("myname", myname);
        model.addAttribute("mystreet", mystreet);
        model.addAttribute("mytown", mytown);
        return "about";
    }
}
