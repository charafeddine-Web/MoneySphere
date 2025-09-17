import java.util.*;
import controller.*;

public class Main {
    public static void main(String[] args) {
        Scanner scnr= new Scanner(System.in);
        CompteController compteController = new CompteController();
        int choix;

        do {
            System.out.println("------------------------------------------------");
            System.out.println("1 - Créer un compte courant");
            System.out.println("2 - Créer un compte épargne");
            System.out.println("3 - Verser de l'argent");
            System.out.println("4 - Retirer de l'argent");
            System.out.println("5 - Consulter solde");
            System.out.println("0 - Quitter");
            System.out.println("------------------------------------------------");
            System.out.print("Choisissez une option : ");

            choix = scnr.nextInt();
            scnr.nextLine();

            switch (choix){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println(" Option invalide !");
                    break;
            }
        }while(choix != 0);
    }
}