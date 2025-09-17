package model;

import util.Destination;
import util.Source;
import util.Source;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import model.Versement;

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
        if (montant <= 0) {
            System.out.println("Le montant doit être positif !");
            return;
        }
        solde +=montant;
        listeOperations.add(new Versement(UUID.randomUUID(),new Date(),montant,Source.VIREMENTEXTERNE));
        System.out.println("Versement de " + montant + " DH effectué avec succès !");
        System.out.println("Solde actuel: " + solde + " DH");
    };

    public void consulterSolde(){
        System.out.println("------------------------------------------------");
        System.out.println("Compte :" + numeroCompte);
        System.out.println("Votre Solde actuel :" + solde + " DH");
        System.out.println("------------------------------------------------");
    };

    public double calculerInteret(){
        return 0;
    };

    public void afficherDetails(){
        System.out.println("------------------------------------------------");
        System.out.println("Compte :" + numeroCompte);
        System.out.println("Type :" + getClass().getName());
        System.out.println("Solde actuel :" + solde + " DH");
        System.out.println("Date Creation :" + numeroCompte);
        System.out.println("Liste Operations :" );
        if(listeOperations != null && !listeOperations.isEmpty()){
            for (Operation op:listeOperations){
                System.out.println("  - " + op);
            }
        }
        System.out.println("------------------------------------------------");
    };

}