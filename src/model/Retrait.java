package model;

import java.util.Date;
import util.Destination;

class Retrait extends Operation{

    private Destination destination;

    public  Retrait(Destination destination, int numeroOperation, Date dateOper, double montant ) {
        super(numeroOperation, dateOper,  montant);
        this.destination=destination;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    //Implementation des methode

    public void retirer(double montant){
        System.out.print("retirer!");

    };
    public void verser(double montant){
        System.out.print("verser!");

    };
    public void consulterSolde(){
        System.out.print("consulterSolde!");

    };
    public double calculerInteret(){
        return 0;
    };
    public void afficherDetails(){
        System.out.print("afficherDetails!");
    };


}