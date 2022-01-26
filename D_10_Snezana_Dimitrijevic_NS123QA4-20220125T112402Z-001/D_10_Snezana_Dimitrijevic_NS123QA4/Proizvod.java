package DomaciJava7;

public abstract class Proizvod {
    private String barKod;
    private String naziv;
    private int cena;

    public Proizvod(String barKod, String naziv, int cena) {
        this.barKod = barKod;
        this.naziv = naziv;
        this.cena = cena;
    }

    public String getBarKod() {
        return barKod;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getCena() {
        return cena;
    }

    public void setBarKod(String barKod) {
        this.barKod = barKod;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public void setPopust(double popust) {
        this.cena -= this.cena * (popust / 100);
    }

    public void poruci(int kolicina){}

    public static void popustZaSkupljeOd200(Proizvod[] proizvodi) {
        for (Proizvod proizvod : proizvodi) {
            if (proizvod.getCena() > 200) proizvod.setPopust(15);
        }
    }

    @Override
    public String toString() {
        return "rola: " + getClass().getSimpleName().toLowerCase()
                + "\n" + "ime: " + this.naziv
                + "\n" + "cena: " + this.cena;
    }
}
