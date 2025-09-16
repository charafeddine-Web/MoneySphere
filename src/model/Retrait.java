package model;

import java.util.Date;
import util.Destination;

class Retrait extends Operation{

    private Destination destination;

    public  Retrait(Destination destination, String numeroOperation, Date dateOper, double montant ) {
        super(numeroOperation, dateOper,  montant);
        this.destination=destination;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }



}