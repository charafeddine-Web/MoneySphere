package model;

import util.Destination;
import util.Source;

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
        if (montant <= 0) {
            System.out.println("Le montant doit être positif !");
            return;
        }
        solde +=montant;
        listeOperations.add(new Versement(UUID.randomUUID(),new Date(),montant, Source.VIREMENTEXTERNE));
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
        return solde * tauxInteret;
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