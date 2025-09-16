package model;

class Versement extends Operation{
    private source Source;

    public void   Versement(source Source){
        this.Source=Source;
    }

    public source getSource() {
        return Source;
    }

    public void setSource(source source) {
        Source = source;
    }
}