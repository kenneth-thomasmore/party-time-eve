package be.thomasmore.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class HomeController {
    LocalDate today = LocalDate.now();

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

    @GetMapping("/pay")
    public String pay(Model model){
        DateTimeFormatter dateform = DateTimeFormatter.ofPattern("dd-MM-yyy");
        String date = today.format(dateform);
        String mollow = today.plusDays(1).format(dateform);
        model.addAttribute("date",date);
        model.addAttribute("mollow",mollow);
        return "pay";

    }

}
