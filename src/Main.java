import java.util.*;
import controller.*;
import model.*;
import util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scnr= new Scanner(System.in);
        CompteController compteController = new CompteController();
        int choix;

        do {
            System.out.println("------------------------------------------------");
            System.out.println("1 - Créer un compte");
            System.out.println("2 - Manager Votre compte");
            System.out.println("0 - Quitter");
            System.out.println("------------------------------------------------");
            System.out.print("Choisissez une option : ");

            choix = scnr.nextInt();
            scnr.nextLine();

            switch (choix){
                case 1:
                    System.out.println("1 - Compte Courant");
                    System.out.println("2 - Compte Épargne");
                    System.out.print("Votre choix : ");
                    int typeCompte= scnr.nextInt();
                    scnr.nextLine();

                    System.out.print("Numéro de compte (XXXXX) : ");
                    String numero = scnr.nextLine();
                    System.out.print("Solde initial : ");
                    double solde = scnr.nextDouble();

                    if(typeCompte==1){
                        System.out.print("Découvert autorisé : ");
                        double decouvert = scnr.nextDouble();
                        compteController.creerCompteCourant(numero, solde, decouvert);
                    }else if (typeCompte == 2) {
                        System.out.print("Taux d'intérêt : ");
                        double taux = scnr.nextDouble();
                        compteController.creerCompteEpargne(numero, solde, taux);
                    } else {
                        System.out.println("Option invalide !");
                    }
                    break;
                case 2:
                    System.out.print("Numéro du compte (CPT-XXXXX): ");
                    String numCompte = scnr.nextLine();

                    if (!compteController.existeCompte(numCompte)) {
                        System.out.println("Ce compte n'existe pas. Veuillez créer un compte d'abord !");
                        break;
                    }
                    System.out.println("1 - Verser");
                    System.out.println("2 - Retirer");
                    System.out.println("3 - Virement");
                    System.out.println("4 - Consulter solde");
                    System.out.println("5 - Afficher Operations");
                    System.out.println("6 - Afficher détails du compte");


                    System.out.print("Votre choix : ");
                    int  TypeOperation = scnr.nextInt();
                    scnr.nextLine();
                    switch (TypeOperation){
                        case 1:
                            System.out.print("Montant à verser : ");
                            double montantVerse = scnr.nextDouble();
                            scnr.nextLine();
                            for (Source s: Source.values()){
                                System.out.println("- "+s);
                            }
                            System.out.print("Votre choix : ");
                            String choixSource=scnr.nextLine().toUpperCase();
                            try {
                                Source source = Source.valueOf(choixSource);
                                compteController.verse(numCompte, montantVerse,source);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Type de versement invalide !");
                            }
                            break;
                        case 2:
                            System.out.print("Montant a retirer : ");
                            double montantRetriet = scnr.nextDouble();
                            scnr.nextLine();
                            for (Destination ds: Destination.values()){
                                System.out.println("- "+ds);
                            }
                            System.out.print("Votre choix : ");
                            String choixDes=scnr.nextLine().toUpperCase();
                            try{
                                Destination destination=Destination.valueOf(choixDes);
                                compteController.retirer(numCompte,montantRetriet,destination);
                            }catch (IllegalArgumentException e){
                                System.out.println("Type de Retirer invalide !");
                            }
                            break;
                        case 3:
                            System.out.print("Numero Compte Destinataire :");
                            String  numCompteDes=scnr.nextLine();
                            System.out.print("montant : ");
                            double montantVerseOuDes = scnr.nextDouble();
                            compteController.virement(numCompte,numCompteDes,montantVerseOuDes);
                            break;
                        case 4:
                            compteController.consulterSolde(numCompte);
                            break;
                        case 5:
                            compteController.afficherOperations(numCompte);
                            break;
                        case 6:
                            compteController.afficherDetails(numCompte);
                            break;
                        default:
                            System.out.println("Option invalide !");
                            break;
                    }
                    break;
                default:
                    System.out.println(" Option invalide !");
                    break;
            }
        }while(choix != 0);
    }
}