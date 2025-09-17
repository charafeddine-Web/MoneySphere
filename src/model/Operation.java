package model;

import java.util.Date;
import java.util.UUID;

public abstract  class Operation{

    protected String numeroOperation;
    protected Date dateOper;
    protected double montant ;


    public  Operation(UUID numeroOperation, Date dateOper, double montant){
        this.numeroOperation=numeroOperation.toString();
        this.dateOper=dateOper;
        this.montant=montant;
    }


    //Getters

    public String getNumeroOperation() {
        return numeroOperation;
    }
    public Date getDateOper() {
        return dateOper;
    }
    public double getMontant() {
        return montant;
    }

    // Setters

    public void setNumeroOperation(String numeroOperation) {
        this.numeroOperation = numeroOperation;
    }

    public void setDateOper(Date dateOper) {
        this.dateOper = dateOper;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }


    @Override
    public String toString() {
        return "Operation{" +
                "numero='" + numeroOperation + '\'' +
                ", date=" + dateOper +
                ", montant=" + montant +
                '}';
    }






}