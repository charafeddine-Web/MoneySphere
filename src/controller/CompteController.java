package controller;
import model.*;
import util.*;

import java.util.*;

public class CompteController {

    private final HashMap<String, Compte> comptes=new HashMap<>();

    public void creerCompteCourant(String numeroCompte,double solde,double decouvert){
        CompteCourant cc = new CompteCourant(numeroCompte,solde,new Date(),new ArrayList<>(),decouvert);
        comptes.put(cc.getNumeroCompte(),cc);
        System.out.println(" Compte courant créé avec succès !");
    }

    public void creerCompteEpargne(String numeroCompte,double solde , double tauxInteret){
        CompteEpargne ce=new CompteEpargne(numeroCompte,solde,new Date(),new ArrayList<>(), tauxInteret);
        comptes.put(ce.getNumeroCompte(),ce);
        System.out.println(" Compte Epargne créé avec succès !");
    }

    public  void verse(String numeroCompte,double montant){
        Compte compte=comptes.get(numeroCompte);

        if (numeroCompte == null){
            System.out.println("Compte introuvable : " + numeroCompte);
            return;
        }
        if (montant <= 0) {
            System.out.println("Le montant doit être positif.");
            return;
        }

        compte.verser(montant);
//        System.out.println("Versement de " + montant + " DH effectué sur le compte " + numeroCompte);

    }

    public void retriet(String numeroCompte,double montant){
        Compte compte=comptes.get(numeroCompte);
        if (numeroCompte == null){
            System.out.println("Compte introuvable : " + numeroCompte);
            return;
        }
        if (montant <= 0) {
            System.out.println("Le montant doit être positif.");
            return;
        }
        compte.retirer(montant);
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

        source.retirer(montant);
        destination.verser(montant);

        source.getListeOperations().add(
                new Retrait(Destination.VIREMENTSORTANT, UUID.randomUUID(), new Date(), montant)
        );
        destination.getListeOperations().add(
                new Versement(UUID.randomUUID(), new Date(), montant, Source.VIREMENTEXTERNE)
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
        System.out.println("------------------------------------------------");
        System.out.println("Compte : " + compte.getNumeroCompte());
        System.out.println("Type : " + compte.getClass().getSimpleName());
        System.out.println("Date Creation : " + compte.getDateCreation() );
        System.out.println("Solde actuel : " + compte.getSolde() + " DH");
        System.out.println("Historique des opérations :");
        if (compte.getListeOperations().isEmpty()) {
            System.out.println("Aucune opération effectuée.");
        } else {
            compte.getListeOperations().forEach(System.out::println);
        }
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

}
