package DomaciJava7;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static Scanner s = new Scanner(System.in);
    public static String ime;
    public static String prezime;
    public static void main(String[] args) {
        Proizvod p1 = new Prehrambeni("475sdi7","mleko",100, LocalDate.of(2021, 12, 30));
        Proizvod p2 = new Tehnika("345kh3","sporet",35000,5,40);
        Proizvod p3 = new AlkoholnoPice("654k33","pivo",120,"staklena",10);
        Proizvod p4 = new Pice("774gg","sok breskva",200,"kartonska");

        Proizvod[] nizProizvoda = {p1, p2, p3, p4};
        Proizvod.popustZaSkupljeOd200(nizProizvoda);

        for (Proizvod proizvod : nizProizvoda) {
            if (proizvod instanceof AlkoholnoPice) {
                proizvod.setPopust(50);
            }
        }

//        p1.poruci(5);
//        p2.poruci(32);
//        p3.poruci(1);
//        p4.poruci(1);

//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(p3);
//        System.out.println(p4);

        unosKorisnika();
        Kupac kupac1 = new Kupac(ime, prezime);
        Korpa korpa1 = new Korpa(kupac1);
        kupuj(kupac1, korpa1, nizProizvoda);


    }

    public static void unosKorisnika() {
        System.out.print("Unesite ime: ");
        ime = s.next();
        System.out.print("Unesite prezime: ");
        prezime = s.next();
    }
    public static void kupuj(Kupac kupac, Korpa korpa, Proizvod[] proizvodi) {
        while (true) {
            boolean b = false;
            System.out.print("Unesite bar kod proizvoda, ili 'zavrsi' za kraj kupovine: ");
            String barK = s.next();
            if (barK.equals("zavrsi")){
                korpa.ispisiRacun();
                break;
            }
            for (Proizvod proizvod : proizvodi) {
                if (proizvod.getBarKod().equals(barK)) {
                    korpa.addProizvod(proizvod);
                    b = true;
                }
            }
            if (b == false) {
                System.out.println("Izabrani proizvod nije u ponudi!");
            }
        }
    }
}
