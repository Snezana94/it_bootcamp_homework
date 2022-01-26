package DomaciJava7;

public class AlkoholnoPice extends Pice {
    private double procenatAlkohola;

    public AlkoholnoPice(String barKod, String naziv, int cena, String ambalaza, double procenatAlkohola) {
        super(barKod, naziv, cena, ambalaza);
        this.procenatAlkohola = procenatAlkohola;
    }

    public double getProcenatAlkohola() {
        return procenatAlkohola;
    }

    public void setProcenatAlkohola(double procenatAlkohola) {
        this.procenatAlkohola = procenatAlkohola;
    }
}
