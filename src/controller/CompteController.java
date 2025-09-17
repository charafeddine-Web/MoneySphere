package controller;
import model.Compte;
import model.CompteCourant;
import model.CompteEpargne;

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



}
