package model;

import util.Destination;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CompteEpargne extends Compte{

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
        if(solde >= montant){
            solde -=montant;
            listeOperations.add(new Retrait(Destination.DISTRIBUTEUR_ATM, UUID.randomUUID(), new Date(), montant));
            System.out.println("Retrait de " + montant + " DH effectué avec succès ");
            System.out.println("Solde actuel: " + solde + " DH");
        }else{
            System.out.println("Retrait impossible ! montane > votre solde .");
        }
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