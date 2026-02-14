package be.thomasmore.party.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Integer id;
    private String clientname;
    private int nrOfOrders;
    private double totalAmount, discountTaken;

    public String getName() {
        return clientname;
    }

    public void setName(String name) {
        this.clientname = name;
    }

    public int getNrOfOrders() {
        return nrOfOrders;
    }

    public void setNrOfOrders(int nrOfOrders) {
        this.nrOfOrders = nrOfOrders;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscountTaken() {
        return discountTaken;
    }

    public void setDiscountTaken(double discountTaken) {
        this.discountTaken = discountTaken;
    }
}
