package be.thomasmore.party.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Venue {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)

    private Integer id;
    private String venuename;
    private String linkmoreinfo;

    public String getVenuename() {
        return venuename;
    }

    public void setVenuename(String venuename) {
        this.venuename = venuename;
    }

    public String getLinkmoreinfo() {
        return linkmoreinfo;
    }

    public void setLinkmoreinfo(String linkmoreinfo) {
        this.linkmoreinfo = linkmoreinfo;
    }
}
