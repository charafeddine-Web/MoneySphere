package model;
import java.util.*;
import util.Destination;
import util.Source;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CompteEpargne extends Compte{

    private double tauxInteret=0.08;

    public CompteEpargne(String numeroCompte, double solde, Date dateCreation, List<Operation> listeOperations){
        super( numeroCompte,  solde,  dateCreation,  listeOperations);
        demarrerCalculInterets();
    }
    // Getters & Setters
    public double getTauxInteret() {
        return tauxInteret;
    }
    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    // Implementation des methode
    @Override
    public void retirer(double montant,Destination destination){
        if(solde >= montant){
            solde -=montant;
            listeOperations.add(new Retrait(destination, UUID.randomUUID(), new Date(), montant));
            System.out.println("Retrait de " + montant + " DH effectué avec succès ");
            System.out.println("Solde actuel: " + solde + " DH");
        }else{
            System.out.println("Retrait impossible ! montane > votre solde .");
        }
    };
    @Override
    public void verser(double montant ,Source source){
        if (montant <= 0) {
            System.out.println("Le montant doit être positif !");
            return;
        }
        solde +=montant;
        listeOperations.add(new Versement(UUID.randomUUID(),new Date(),montant, source));
        System.out.println("Versement de " + montant + " DH effectué avec succès !");
        System.out.println("Solde actuel: " + solde + " DH");
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
    public double calculerInteret(){
        return solde * tauxInteret;
    };
    private void demarrerCalculInterets() {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                appliquerInteret();
            }
        }, 5000, 5000);
    }
    public void appliquerInteret() {
        double interet = calculerInteret();
        solde += interet;
        System.out.println("Intérêts ajoutés: " + interet + " DH");
        System.out.println("Nouveau solde: " + solde + " DH");
    }

    //    public void consulterSolde(){
//        System.out.println("------------------------------------------------");
//        System.out.println("Compte :" + numeroCompte);
//        System.out.println("Votre Solde actuel :" + solde + " DH");
//        System.out.println("------------------------------------------------");
//    };

}