package DomaciJava7;

import java.time.LocalDate;

public class Tehnika extends Proizvod{

    private int garancija;
    private double tezina;

    public Tehnika(String barKod, String naziv, int cena, int garancija, double tezina) {
        super(barKod, naziv, cena);
        this.garancija = garancija;
        this.tezina = tezina;
    }

    public int getGarancija() {
        return garancija;
    }

    public double getTezina() {
        return tezina;
    }

    public void setGarancija(int garancija) {
        this.garancija = garancija;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    @Override
    public void poruci(int kolicina) {
        double racun = super.getCena() * kolicina;

        if (kolicina > 30) {
            System.out.println("Dostava do vrata");
        }

        System.out.println("Vas racun je: " + racun);
    }
}
