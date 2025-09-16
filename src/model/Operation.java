package model;

import java.util.Date;

abstract  class Operation{

    protected int numeroOperation;
    protected Date dateOper;
    protected double montant ;


    public  Operation(int numeroOperation,Date dateOper, double montant){
        this.numeroOperation=numeroOperation;
        this.dateOper=dateOper;
        this.montant=montant;
    }


    //Getters

    public int getNumeroOperation() {
        return numeroOperation;
    }
    public Date getDateOper() {
        return dateOper;
    }
    public double getMontant() {
        return montant;
    }

    // Setters

    public void setNumeroOperation(int numeroOperation) {
        this.numeroOperation = numeroOperation;
    }

    public void setDateOper(Date dateOper) {
        this.dateOper = dateOper;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }



    // Implementation des methode

    public void retirer(double montant){
        System.out.print("retirer!");

    };
    public void verser(double montant){
        System.out.print("verser!");

    };
    public void consulterSolde(){
        System.out.print("consulterSolde!");

    };
    public double calculerInteret(){
        return 0;
    };
    public void afficherDetails(){
        System.out.print("afficherDetails!");
    };






}