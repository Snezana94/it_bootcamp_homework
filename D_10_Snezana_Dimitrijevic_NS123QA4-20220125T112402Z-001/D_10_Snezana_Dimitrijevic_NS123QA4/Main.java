package DomaciJava7;

import java.time.LocalDate;

public class Main {
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

        p1.poruci(5);
        p2.poruci(32);
        p3.poruci(1);
        p4.poruci(1);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
    }
}
