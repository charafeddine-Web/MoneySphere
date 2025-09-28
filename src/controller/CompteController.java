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
        try {
            if (solde < 0) throw new IllegalArgumentException("Le solde initial ne peut pas être négatif !");
            if (decouvert < 0) throw new IllegalArgumentException("Le découvert ne peut pas être négatif !");
            String numeroCompte = genereteCompteur();
            CompteCourant cc = new CompteCourant(numeroCompte, solde, new Date(), new ArrayList<>(), decouvert);
            comptes.put(cc.getNumeroCompte(), cc);
            System.out.println(" Compte courant créé avec succès !");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
    public void creerCompteEpargne(double solde ){
        try{
            if (solde < 0) throw new IllegalArgumentException("Le solde initial ne peut pas être négatif !");
            String numeroCompte = genereteCompteur();
            CompteEpargne ce=new CompteEpargne(numeroCompte,solde,new Date(),new ArrayList<>());
            comptes.put(ce.getNumeroCompte(),ce);
            System.out.println(" Compte Epargne créé avec succès !");
        }catch (IllegalArgumentException e){
            System.out.println("Erreur : " + e.getMessage());
        }
    }


    public  void verse(String numeroCompte,double montant,Source source){
        try{
            Compte compte=comptes.get(numeroCompte);
            if (compte == null) throw new IllegalArgumentException("Compte introuvable : " + numeroCompte);

            if (montant <= 0)throw new IllegalArgumentException("Le montant doit être positif.");
            compte.verser(montant,source);
        }catch (IllegalArgumentException e){
            System.out.println("Erreur versement : " + e.getMessage());
        }
//        System.out.println("Versement de " + montant + " DH effectué sur le compte " + numeroCompte);
    }
    public void retirer(String numeroCompte,double montant,Destination destination){
        try {
            Compte compte=comptes.get(numeroCompte);
            if (numeroCompte == null) throw new IllegalArgumentException("Compte introuvable : " + numeroCompte);
            if (montant <= 0) throw new IllegalArgumentException("Le montant doit être positif. " );
            compte.retirer(montant,destination);
        }catch (IllegalArgumentException e){
            System.out.println("Erreur Retirer : " + e.getMessage());
        }

    }
    public void virement(String numeroSource, String numeroDestination, double montant){
        try {
            Compte source = comptes.get(numeroSource);
            Compte destination = comptes.get(numeroDestination);

            if (source == null) throw new IllegalArgumentException("Compte source introuvable : " + numeroSource);
            if (destination == null) throw new IllegalArgumentException("Compte destination introuvable : " + numeroDestination);
            if (montant <= 0) throw new IllegalArgumentException("Le montant doit être positif.");
            if (source.getSolde() < montant) throw new IllegalArgumentException("Solde insuffisant dans le compte source.");

            source.retirer(montant, VIREMENTSORTANT);
            destination.verser(montant, VIREMENTEXTERNE);

            source.getListeOperations().add(new Retrait(VIREMENTSORTANT, UUID.randomUUID(), new Date(), montant));
            destination.getListeOperations().add(new Versement(UUID.randomUUID(), new Date(), montant, VIREMENTEXTERNE));

            System.out.println("Virement de " + montant + " DH effectué avec succès !");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur virement : " + e.getMessage());
        }
    }
    public void consulterSolde(String numeroCompte){
        try {
            Compte compte = comptes.get(numeroCompte);
            if (compte == null) throw new IllegalArgumentException("Compte introuvable : " + numeroCompte);
            System.out.println("Compte : " + compte.getNumeroCompte());
            System.out.println("Type : " + compte.getClass().getSimpleName());
            System.out.println("Solde : " + compte.getSolde() + " DH");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
    public void afficherDetails(String numeroCompte){
        try {
            Compte compte = comptes.get(numeroCompte);
            if (compte == null) throw new IllegalArgumentException("Compte source introuvable : " + numeroCompte);
            compte.afficherDetails();
        }catch ( IllegalArgumentException e){
            System.out.println("Erreur : " + e.getMessage());
        }
    };
    public void afficherOperations(String numeroCompte) {
        try {
            Compte compte = comptes.get(numeroCompte);
            if (compte == null) {
                throw new IllegalArgumentException("Compte introuvable : " + numeroCompte);
            }

            System.out.println("------------------------------------------------");
            System.out.println("Historique des opérations :");
            if (compte.getListeOperations().isEmpty()) {
                System.out.println("Aucune opération effectuée.");
            } else {
                for (Operation op : compte.getListeOperations()) {
                    System.out.println(op);
                }
            }
            System.out.println("------------------------------------------------");

        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Une erreur inattendue est survenue lors de l'affichage des opérations.");
        }
    }

    public boolean existeCompte(String numeroCompte) {
        return comptes.containsKey(numeroCompte);
    }
    public void afficherAllComptes() {
        try {
            if (comptes == null || comptes.isEmpty()) {
                System.out.println("Aucun compte disponible.");
                return;
            }
            System.out.println("Liste de tous les comptes :");
            int i = 1;
            for (Compte cm : comptes.values()) {
                System.out.println(i + " - " + cm);
                i++;
            }

        } catch (Exception e) {
            System.out.println("Une erreur est survenue lors de l'affichage des comptes : " + e.getMessage());
        }
    }

}
