package controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import controller.CompteController;
import util.Source;
import util.Destination;

public class ConsoleUI {
    private final Scanner scnr = new Scanner(System.in);
    private final CompteController compteController = new CompteController();

    public void start() {
        int choix = -1;
        do {
            try {
                afficherMenuPrincipal();
                choix = scnr.nextInt();
                scnr.nextLine();

                switch (choix) {
                    case 1: creerCompte(); break;
                    case 2: managerCompte(); break;
                    case 3: compteController.afficherAllComptes();break;
                    case 0: System.out.println("Au revoir !"); break;
                    default: System.out.println("Option invalide !"); break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer un nombre valide !");
                scnr.nextLine(); // vider le buffer
            } catch (Exception e) {
                System.out.println("Une erreur est survenue : " + e.getMessage());
            }
        } while (choix != 0);
    }

    private void afficherMenuPrincipal() {
        System.out.println("------------------------------------------------");
        System.out.println("1 - Créer un compte");
        System.out.println("2 - Manager Votre compte");
        System.out.println("3 - Afficher List comptes");
        System.out.println("0 - Quitter");
        System.out.println("------------------------------------------------");
        System.out.print("Choisissez une option : ");
    }

    private void creerCompte() {
        try {
            System.out.println("1 - Compte Courant");
            System.out.println("2 - Compte Épargne");
            System.out.print("Votre choix : ");
            int typeCompte = scnr.nextInt();
            scnr.nextLine();

            if (typeCompte != 1 && typeCompte != 2) {
                throw new IllegalArgumentException("Choix incorrect, vous devez entrer 1 ou 2.");
            }

            System.out.print("Solde initial : ");
            double solde = scnr.nextDouble();

            switch (typeCompte) {
                case 1:
                    System.out.print("Découvert autorisé : ");
                    double decouvert = scnr.nextDouble();
                    compteController.creerCompteCourant(solde, decouvert);
                    break;
                case 2:
                    compteController.creerCompteEpargne(solde);
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Vous devez entrer un nombre !");
            scnr.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    private void managerCompte() {
        try {
            System.out.print("Numéro du compte (CPT-XXXXX): ");
            String numCompte = scnr.nextLine();

            if (!compteController.existeCompte(numCompte)) {
                throw new IllegalArgumentException("Ce compte n'existe pas. Veuillez créer un compte d'abord !");
            }

            System.out.println("1 - Verser");
            System.out.println("2 - Retirer");
            System.out.println("3 - Virement");
            System.out.println("4 - Consulter solde");
            System.out.println("5 - Afficher Operations");
            System.out.println("6 - Afficher détails du compte");
            System.out.print("Votre choix : ");

            int typeOperation = scnr.nextInt();
            scnr.nextLine();

            switch (typeOperation) {
                case 1:
                    try {
                        System.out.print("Montant à verser : ");
                        double montantVerse = scnr.nextDouble();
                        scnr.nextLine();

                        for (Source s : Source.values()) {
                            System.out.println("- " + s);
                        }
                        System.out.print("Votre choix : ");
                        String choixSource = scnr.nextLine().toUpperCase();
                        Source source = Source.valueOf(choixSource);

                        compteController.verse(numCompte, montantVerse, source);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Type de versement invalide !");
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Montant a retirer : ");
                        double montantRetrait = scnr.nextDouble();
                        scnr.nextLine();

                        for (Destination ds : Destination.values()) {
                            System.out.println("- " + ds);
                        }
                        System.out.print("Votre choix : ");
                        String choixDes = scnr.nextLine().toUpperCase();
                        Destination destination = Destination.valueOf(choixDes);

                        compteController.retirer(numCompte, montantRetrait, destination);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Type de retrait invalide !");
                    }
                    break;

                case 3:
                    System.out.print("Numero Compte Destinataire : ");
                    String numCompteDes = scnr.nextLine();
                    System.out.print("Montant : ");
                    double montantVirement = scnr.nextDouble();
                    compteController.virement(numCompte, numCompteDes, montantVirement);
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
        } catch (InputMismatchException e) {
            System.out.println("Vous devez entrer un nombre !");
            scnr.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println( e.getMessage());
        }
    }
}

