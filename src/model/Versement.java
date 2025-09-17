package model;
import util.Source;

import java.util.Date;
import java.util.UUID;

class Versement extends Operation{
    private Source source;

    public Versement(UUID numeroOperation, Date dateOper, double montant, Source source){
        super(numeroOperation,dateOper, montant);
        this.source=source;
    }

    //Getters & Setters
    public Source getSource() {
        return source;
    }
    public void setSource(Source source) {
        source = source;
    }

    @Override
    public String toString(){
        return "Operation {"+
                "numero='" + numeroOperation + '\'' +
                ", date=" + dateOper +
                ", montant=" + montant +
                '}';

    }
}