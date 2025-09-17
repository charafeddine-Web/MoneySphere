package model;

import java.util.Date;
import java.util.List;

public abstract class Compte {

    protected String numeroCompte;
    protected double solde;
    protected Date dateCreation;
    protected List<Operation> listeOperations;

    // Constructor
    public Compte(String numeroCompte, double solde, Date dateCreation, List<Operation> listeOperations) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.listeOperations = listeOperations;
    }

    // Getters
    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public List<Operation> getListeOperations() {
        return listeOperations;
    }

    // Setters
    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setListeOperations(List<Operation> listeOperations) {
        this.listeOperations = listeOperations;
    }

    // Méthodes abstraites
    public abstract void retirer(double montant);
    public abstract void verser(double montant);
//    public abstract void consulterSolde();
    public abstract double calculerInteret();
    public abstract void afficherDetails();
}
