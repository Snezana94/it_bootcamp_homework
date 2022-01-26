package DomaciJava7;

public class Pice extends Proizvod {
    private String ambalaza;

    public Pice(String barKod, String naziv, int cena, String ambalaza) {
        super(barKod, naziv, cena);
        this.ambalaza = ambalaza;
    }

    public String getAmbalaza() {
        return ambalaza;
    }

    public void setAmbalaza(String ambalaza) {
        this.ambalaza = ambalaza;
    }

    @Override
    public void poruci(int kolicina) {
        double cenaAmbalaze = 0;
        switch (this.ambalaza) {
            case "kartonska":
                cenaAmbalaze = super.getCena() * 0.1;
                break;
            case "plasticna":
                cenaAmbalaze = super.getCena() * 0.2;
                break;
            case "staklena":
                cenaAmbalaze = super.getCena() * 0.3;
                break;
            case "limenka":
                cenaAmbalaze = super.getCena() * 0.3;
                break;
            default:
            System.out.println("Greska!");
            break;
        }
        double racun = (super.getCena() + cenaAmbalaze) * kolicina;
        System.out.println("Vas racun je: " + racun);
    }
}
