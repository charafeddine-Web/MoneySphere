package model;

import java.util.Date;


class Retrait extends Operation{

    private Destination destination;

    public void Retrait(Destination destination, int numeroOperation, Date dateOper, double montant ) {
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