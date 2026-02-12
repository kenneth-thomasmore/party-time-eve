package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Venue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class VenueController {


    @GetMapping({"/venuedetails"})
    public String venuedetails (Model model){
        Venue ven1 = new Venue();
        ven1.setVenuename("defqon.1");
        ven1.setLinkmoreinfo("https://www.animenewsnetwork.com/");
        model.addAttribute("ven1", ven1);
        return "venuedetails";
    }

}
