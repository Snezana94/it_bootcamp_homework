package DomaciJava7;

import java.time.LocalDate;

public class Prehrambeni extends Proizvod{
    private LocalDate datumIsteka;

    public Prehrambeni(String barKod, String naziv, int cena, LocalDate datumIsteka) {
        super(barKod, naziv, cena);
        this.datumIsteka = datumIsteka;
    }

    public LocalDate getDatumIsteka() {
        return datumIsteka;
    }

    public void setDatumIsteka(LocalDate datumIsteka) {
        this.datumIsteka = datumIsteka;
    }

    @Override
    public void poruci(int kolicina) {
        if (datumIsteka.compareTo(LocalDate.now()) < 0) {
            System.out.println("Datim istekao!!!");
        } else {
            double racun = super.getCena() * kolicina;
            System.out.println("Vas racun je: " + racun);
        }
    }

}
