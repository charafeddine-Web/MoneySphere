package model;
import util.Source;

import java.util.Date;

class Versement extends Operation{
    private Source source;

    public   Versement(String numeroOperation, Date dateOper, double montant, Source source){
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


}