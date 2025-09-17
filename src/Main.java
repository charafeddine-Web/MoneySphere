import java.util.*;
import controller.*;

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

                    System.out.print("Numéro de compte : ");
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
                    System.out.print("Numéro du compte : ");
                    String numCompte = scnr.nextLine();

                    System.out.println("1 - Verser");
                    System.out.println("2 - Retirer");
                    System.out.println("3 - Consulter solde");
                    System.out.println("4 - Virement");
                    System.out.print("Votre choix : ");

                    int  TypeOperation = scnr.nextInt();
                    scnr.nextLine();
                    switch (TypeOperation){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
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