package model;

import util.Destination;
import util.Source;
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
    public void retirer(double montant,Destination destination){
        if(montant <= 0 ){
            System.out.println(" Le montant doit être positif !");
            return;
        }
        if (solde - montant >= -decouvert){
            solde -= montant;
            listeOperations .add(new Retrait( destination, UUID.randomUUID(), new Date(), montant));
            System.out.println("Retrait de " + montant + " DH effectué avec succès ");
            System.out.println("Solde actuel: " + solde + " DH");
        } else {
            System.out.println("Retrait impossible ! Dépassement du découvert autorisé.");
        }
    };
    @Override
    public void verser(double montant, Source source){
        if (montant <= 0) {
            System.out.println("Le montant doit être positif !");
            return;
        }
        solde +=montant;
        listeOperations.add(new Versement(UUID.randomUUID(),new Date(),montant,source));
        System.out.println("Versement de " + montant + " DH effectué avec succès !");
        System.out.println("Solde actuel: " + solde + " DH");
    };
    @Override
    public double calculerInteret(){
        return 0;
    };
    @Override
    public void afficherDetails(){
        System.out.println("------------------------------------------------");
        System.out.println("Compte :" + numeroCompte);
        System.out.println("Type :" + getClass().getName());
        System.out.println("Solde actuel :" + solde + " DH");
        System.out.println("Date Creation :" + numeroCompte);
        System.out.println("Historique des opérations :");
        if (listeOperations.isEmpty()) {
            System.out.println("Aucune opération effectuée.");
        } else {
            listeOperations.forEach(System.out::println);
        }
        System.out.println("------------------------------------------------");
    };



    @Override
    public String toString() {
        return "CompteCourant {" + "num=" + numeroCompte + ", solde=" + solde + "}";
    }

}