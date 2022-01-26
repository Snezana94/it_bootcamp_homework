package DomaciJava7;

import java.util.HashMap;

public class Korpa {
    private Kupac kupac;
    HashMap<Proizvod, Integer> proizvodiIKolicine;

    public Korpa(Kupac kupac) {
        this.kupac = kupac;
        this.proizvodiIKolicine = new HashMap<>();
    }

    public Kupac getKupac() {
        return kupac;
    }

    public HashMap<Proizvod, Integer> getProizvodiIKolicine() {
        return proizvodiIKolicine;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public void addProizvod(Proizvod proizvod) {
        proizvodiIKolicine.put(proizvod, proizvodiIKolicine.getOrDefault(proizvod, 0) + 1);
    }

    public void ispisiRacun() {
        System.out.println("naziv  |  kolicina  |  cena*kolicina");
        double iznos = 0;
        for (Proizvod p : proizvodiIKolicine.keySet()) {
            System.out.println(p.getNaziv() + "    x" + proizvodiIKolicine.get(p) + "    " + proizvodiIKolicine.get(p) * p.getCena());
            iznos += proizvodiIKolicine.get(p) * p.getCena();
        }
        System.out.println("Za uplatu: " + iznos);
    }
}
