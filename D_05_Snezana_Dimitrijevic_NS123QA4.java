import java.util.Arrays;
import java.util.Scanner;

public class DomaciJava2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

//      1. Ispisati u konzoli sumu svih parnih brojeva od 1 do n. Korisnik unosi n. (za ovaj zadatak nisu potrebni nizovi samo petlje)

        System.out.print("Unesite broj n: ");
        int n = s.nextInt();
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                suma += i;
            }

        }
        System.out.println(suma);



//        2. Nacrtati pomocu petlji sledeci oblik :
//        Primer za N = 5
//                *
//              * *
//            * * *
//          * * * *
//        * * * * *

        for (int i = 1; i <= 5; i++) {
            for (int r = 5 - i; r >= 0; r--) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }



//        3. Deklarisati I inicijalizovati proizvoljan niz celih brojeva. Od tog niza napraviti novi koji ce imati obrnuti
//        redosled elemenata. Primer : pocetni niz -> {1,4,6,5,3} , krajnji niz -> {3, 5, 6, 4,1}

        int[] niz1 = {1, 2, 3, 4, 5};
        int[] niz2 = new int[5];
        for (int i = 0; i < niz1.length; i++) {
            niz2[4-i] = niz1[i];
        }
        System.out.println(Arrays.toString(niz2));



//        4. Deklarisati I inicijalizovati niz celih brojeva. Korisnik unosi jedan ceo broj koji se cuva u promenljivoj x.
//        Proveriti da li se broj x nalazi u nizu , ako se nalazi ispisati poruku “Nadjen” ako ne “Ovaj broj ne postoji u
//        nizu”
//        Primer: niz -> {2,5,4,3,3,6,5} , Korisnik uneo x -> 5 , rezultat -> “Nadjen”
//        ** Dodatak : Koliko puta se broj x nalazi u nizu. U primeru bi rezultat bio 2 puta.

        int [] nizCelihBrojeva = {2, 4, 6, 8, 10, 12, 14, 12, 10};
        int kolikoPuta = 0;
        System.out.print("Unesite jedan ceo broj: ");
        int x = s.nextInt();
        for (int i = 0; i < nizCelihBrojeva.length; i++) {
            if (x == nizCelihBrojeva[i]) {
                kolikoPuta ++;
            }
        }
        if (kolikoPuta > 0) {
            System.out.println("Nadjen i ponavlja se: " + kolikoPuta + " puta" );
        } else {
            System.out.println("Ovaj broj ne postoji u nizu");
            System.exit(1);
        }


//        5. ** Dodatni zadatak (opciono) : Korisnik unosi datum u sledecem formatu: MM-DD-YYYY, uneti string
//        prebaciti u niz tako da taj niz izgleda ovako : {M,M,D,D,Y,Y,Y,Y}. Zatim proveriti da li je uneti datum
//        palindrom .
//        Palindrom je string koji se cita isto sa obe strane.
//        anavolimilovana -> ovo je palindrom
//        Primer: Korisnik unosi datum -> 12-02-2021 ,kada se sklone crtice I pretvori se u niz dobije se
//        {1,2,0,2,2,0,2,1} ovo jeste palindrom jer je isto kad se cita sa koje god strane.
//         Hint: koristiti split metodu za razdvajanje stringa po odredjenom karakteru u niz.

        System.out.print("Unesite datum u formatu MM-DD-YYYY: ");
        String datum = s.nextLine();
        char[] datumNiz = datum.toCharArray();
        char[] datumDigit= new char[8];
        int i_datumDigit = 0;

        for(int i_datumNiz = 0;i_datumNiz<datumNiz.length;i_datumNiz++) {
            if(datumNiz[i_datumNiz] >= '0' && datumNiz[i_datumNiz] <= '9') {
                datumDigit[i_datumDigit] = datumNiz[i_datumNiz];
                i_datumDigit++;
            }
        }
        System.out.println(Arrays.toString(datumDigit));
        for (int i = 0; i < datumDigit.length; i++) {
            if (datumDigit[i] == datumDigit[7-i]) {
                if (i == 7) {
                    System.out.println("Jeste palindrom");
                }
            } else {
                if (i == 7) {
                    System.out.println("Nije palindrom");
                }
            }
        }



    }
}
