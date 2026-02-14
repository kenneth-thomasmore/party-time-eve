package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Client;
import be.thomasmore.party.repositories.ClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalTime;
import java.util.Optional;

@Controller
public class ClientController {
    private ClientRepository clientRepository;




    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    private String greeting (){
        Optional<Client> clientFromDb = clientRepository.findById(1);
        String greetinghour;
        String greetings = "";
        LocalTime time = LocalTime.now();
        //-------changes the greeting depending on the hour
        if (time.isBefore(LocalTime.NOON) && time.isAfter(LocalTime.of(6,0))){
            greetinghour = "Goedemorgen";
        } else if (time.isAfter(LocalTime.NOON)&& time.isBefore(LocalTime.of(17,0))) {
            greetinghour = "Goedemiddag";
        } else if (time.isAfter(LocalTime.of(17,0)) && time.isBefore(LocalTime.of(22,0))) {
            greetinghour = "Goedenavond";
        } else greetinghour= "Goedennacht";

        //----full greeting depending on number of orders
        if (clientFromDb.get().getNrOfOrders() ==0){
            greetings = greetinghour + " " + clientFromDb.get().getName() + " , en welkom!";
        } else if (clientFromDb.get().getNrOfOrders() <10) {
            greetings = greetinghour + " " + clientFromDb.get().getName();
        } else if (clientFromDb.get().getNrOfOrders() >=10 && clientFromDb.get().getNrOfOrders() < 50) {
            greetings = greetinghour + " beste " + clientFromDb.get().getName();
        } else if (clientFromDb.get().getNrOfOrders() >=50 && clientFromDb.get().getNrOfOrders() <80) {
            greetings = greetinghour + " allerliefste " + clientFromDb.get().getName();
        } else if (clientFromDb.get().getNrOfOrders() >=80) {
            greetings = greetinghour + " allerliefste " + clientFromDb.get().getName() + " , jij bent een topper!";
        }
        //this can also be done in reverse, checking first for if it's 0, then if it's smaller than 80, then 50 and then
        //if it is smaller than 10. This means you don't need two checks for inbetween 50 and 80 nor inbetween 10 and 50
        //this can also be written via a switch case system but rn i find myself feeling lazy as fuck.
        return greetings;
    }

    private double calculatediscount(){
        double discount =  0;
        Optional<Client> clientFromDb = clientRepository.findById(1);

        if (clientFromDb.get().getTotalAmount() <50) {
            discount = 0;
        } else {
            discount = clientFromDb.get().getTotalAmount() * 0.005;
        }
        return discount;
    }

    @GetMapping("/clientgreeting")
    public String clientgreeting(Model model){
        Optional<Client> clientFromDb = clientRepository.findById(1);
        if (clientFromDb.isPresent()){
            model.addAttribute("client",clientFromDb.get());
        }
        model.addAttribute("greeting",greeting());
        return "clientgreeting";
    }

    @GetMapping("/clientdetails")
    public String clientdetails(Model model){
        Optional<Client> clientFromDb = clientRepository.findById(1);
        if (clientFromDb.isPresent()){
            model.addAttribute("client",clientFromDb.get());
        }
        model.addAttribute("discount",calculatediscount());
        return "clientdetails";
    }

    @GetMapping("/clienthome")
    public String clienthome(Model model){
        return "clienthome";
    }
}
