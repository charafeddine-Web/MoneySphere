package model;

import java.util.Date;
import java.util.List;

public class CompteCourant extends Compte {

    public double decouvert;

    public  CompteCourant (String numeroCompte, double solde, Date dateCreation, List<Operation> listeOperations, double decouvert){
        super( numeroCompte,  solde,  dateCreation, listeOperations);
        this.decouvert=decouvert;
    }

    // Getters & Setters

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    // Implementation des methode

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