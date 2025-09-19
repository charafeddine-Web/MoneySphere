package controller;
import model.*;
import util.*;

import java.util.*;

import static util.Destination.VIREMENTSORTANT;
import static util.Source.VIREMENTEXTERNE;


public class CompteController {

    private final HashMap<String, Compte> comptes=new HashMap<>();

    public static int compteur=1;

    public String genereteCompteur(){
        return String.format("CPT-%05d",compteur++);
    }

    public void creerCompteCourant(double solde,double decouvert){
        String numeroCompte = genereteCompteur();
        CompteCourant cc = new CompteCourant(numeroCompte,solde,new Date(),new ArrayList<>(),decouvert);
        comptes.put(cc.getNumeroCompte(),cc);
        System.out.println(" Compte courant créé avec succès !");
    }
    public void creerCompteEpargne(double solde ){
        String numeroCompte = genereteCompteur();
        CompteEpargne ce=new CompteEpargne(numeroCompte,solde,new Date(),new ArrayList<>());
        comptes.put(ce.getNumeroCompte(),ce);
        System.out.println(" Compte Epargne créé avec succès !");
    }


    public  void verse(String numeroCompte,double montant,Source source){
        Compte compte=comptes.get(numeroCompte);
        if (compte == null){
            System.out.println("Compte introuvable : " + numeroCompte);
            return;
        }
        if (montant <= 0) {
            System.out.println("Le montant doit être positif.");
            return;
        }
        compte.verser(montant,source);
//        System.out.println("Versement de " + montant + " DH effectué sur le compte " + numeroCompte);
    }
    public void retirer(String numeroCompte,double montant,Destination destination){
        Compte compte=comptes.get(numeroCompte);
        if (numeroCompte == null){
            System.out.println("Compte introuvable : " + numeroCompte);
            return;
        }
        if (montant <= 0) {
            System.out.println("Le montant doit être positif.");
            return;
        }
        compte.retirer(montant,destination);
    }
    public void virement(String numeroSource, String numeroDestination, double montant){
        Compte source=comptes.get(numeroSource);
        Compte destination = comptes.get(numeroDestination);
        if (source == null) {
            System.out.println("Compte source introuvable : " + numeroSource);
            return;
        }
        if (destination == null) {
            System.out.println("Compte destination introuvable : " + numeroDestination);
            return;
        }
        if (montant <= 0) {
            System.out.println("Le montant doit être positif.");
            return;
        }
        if(source.getSolde() < montant){
            System.out.println("Solde insuffisant dans le compte source.");
            return;
        }
        source.retirer(montant,VIREMENTSORTANT);
        destination.verser(montant, VIREMENTEXTERNE);

        source.getListeOperations().add(
                new Retrait(VIREMENTSORTANT, UUID.randomUUID(), new Date(), montant)
        );
        destination.getListeOperations().add(
                new Versement(UUID.randomUUID(), new Date(), montant, VIREMENTEXTERNE)
        );
        System.out.println("Virement de " + montant + " DH effectué avec succès !");

    };
    public void consulterSolde(String numeroCompte){
        Compte compte=comptes.get(numeroCompte);
        if (compte== null){
            System.out.println("Compte source introuvable : " + numeroCompte);
            return;
        }
        System.out.println("------------------------------------------------");
        System.out.println("Compte : " + compte.getNumeroCompte());
        System.out.println("Type : " + compte.getClass().getSimpleName());
        System.out.println("Solde actuel : " + compte.getSolde() + " DH");
        System.out.println("------------------------------------------------");
    };
    public void afficherDetails(String numeroCompte){
        Compte compte=comptes.get(numeroCompte);
        if (compte== null){
            System.out.println("Compte source introuvable : " + numeroCompte);
            return;
        }
        compte.afficherDetails();
    };
    public void afficherOperations(String numeroCompte){
        Compte compte=comptes.get(numeroCompte);
        if (compte== null){
            System.out.println("Compte source introuvable : " + numeroCompte);
            return;
        }
        System.out.println("------------------------------------------------");
        System.out.println("Historique des opérations :");
        if (compte.getListeOperations().isEmpty()) {
            System.out.println("Aucune opération effectuée.");
        } else {
            compte.getListeOperations().forEach(System.out::println);
        }
        System.out.println("------------------------------------------------");
    };
    public boolean existeCompte(String numeroCompte) {
        return comptes.containsKey(numeroCompte);
    }

}
