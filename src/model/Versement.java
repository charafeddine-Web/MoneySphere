package model;
import util.Source;

import java.util.Date;

class Versement extends Operation{
    private Source source;

    public   Versement(int numeroOperation, Date dateOper, double montant, Source source){
        super(numeroOperation,dateOper, montant);
        this.source=source;
    }

    //Getters & Setters

    public Source getSource() {
        return source;
    }
    public void setSource(Source source) {
        source = source;
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