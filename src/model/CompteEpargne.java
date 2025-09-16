package model;

import java.util.Date;
import java.util.List;

class CompteEpargne extends Compte{



    private double tauxInteret;

    public CompteEpargne(String numeroCompte, double solde, Date dateCreation, List<Operation> listeOperations,double tauxInteret){
        super( numeroCompte,  solde,  dateCreation,  listeOperations);
        this.tauxInteret=tauxInteret;
    }

    // Getters & Setters

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
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