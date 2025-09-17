package model;

import util.Destination;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CompteCourant extends Compte {

    public double decouvert ;

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
        if(montant <= 0 ){
            System.out.println(" Le montant doit être positif !");
            return;
        }
        if (solde - montant >= -decouvert){
            solde -= montant;
            listeOperations .add(new Retrait( Destination.DISTRIBUTEUR_ATM, UUID.randomUUID(), new Date(), montant));
            System.out.println("Retrait de " + montant + " DH effectué avec succès ");
            System.out.println("Solde actuel: " + solde + " DH");
        } else {
            System.out.println("Retrait impossible ! Dépassement du découvert autorisé.");
        }
    };
    public void verser(double montant){
        if(solde < montant){

        }
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