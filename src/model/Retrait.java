package model;

import java.util.Date;
import java.util.UUID;

import util.Destination;

public class Retrait extends Operation{

    private Destination destination;

    public  Retrait(Destination destination, UUID numeroOperation, Date dateOper, double montant ) {
        super(numeroOperation, dateOper,  montant);
        this.destination=destination;
    }
    //  Getters & Setters

    public Destination getDestination() {
        return destination;
    }
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "numero='" + numeroOperation + '\'' +
                ", date=" + dateOper +
                ", montant=" + montant +
                '}';
    }
}