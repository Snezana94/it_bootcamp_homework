import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class DomaciJava3 {
    public static void main(String[] args) {

//        deklarisanje i inicijalizacija potrebnih promenljivih
        Scanner s = new Scanner(System.in);

        int[] slobodnePozicije = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int randomPozicija = 0;
        boolean bool = false;
        char komp = '-';
        char[] nizXO = new char[9];
        int i = 100;
        boolean pogresanUnos = false;
        char simbol = '-';

//        izbor simbola
        System.out.print("Izaberite X ili O: ");
        while (bool == false) {
            simbol = s.next().toUpperCase(Locale.ROOT).charAt(0);
            if (simbol == 'X') {
                i = 0;
                komp = 'O';
                bool = true;
            } else if (simbol == 'O'){
                komp = 'X';
                i = 0;
                bool = true;
            } else {
                System.out.println("Ponovite unos, greska!");
            }

        }

//      stampanje rasporeda pozicija
        System.out.println();
        System.out.println(slobodnePozicije[0] + " " + slobodnePozicije[1] + " " + slobodnePozicije[2]);
        System.out.println(slobodnePozicije[3] + " " + slobodnePozicije[4] + " " + slobodnePozicije[5]);
        System.out.println(slobodnePozicije[6] + " " + slobodnePozicije[7] + " " + slobodnePozicije[8]);
        System.out.println();

//        igra
        while (i < 5) {
            i++;

//            odabir pozicije igraca
            System.out.println("Slobodne pozicije: " + Arrays.toString(slobodnePozicije));
            System.out.print("Unesite poziciju: ");
            int pozicija = s.nextInt();

//            provera pozicije i dodavanje
            System.out.println();
            switch (pozicija) {
                case 1:
                    nizXO[0] = simbol;
                    slobodnePozicije[0] = 0;
                    pogresanUnos = false;
                    break;
                case 2:
                    nizXO[1] = simbol;
                    slobodnePozicije[1] = 0;
                    pogresanUnos = false;
                    break;
                case 3:
                    nizXO[2] = simbol;
                    slobodnePozicije[2] = 0;
                    pogresanUnos = false;
                    break;
                case 4:
                    nizXO[3] = simbol;
                    slobodnePozicije[3] = 0;
                    pogresanUnos = false;
                    break;
                case 5:
                    nizXO[4] = simbol;
                    slobodnePozicije[4] = 0;
                    pogresanUnos = false;
                    break;
                case 6:
                    nizXO[5] = simbol;
                    slobodnePozicije[5] = 0;
                    pogresanUnos = false;
                    break;
                case 7:
                    nizXO[6] = simbol;
                    slobodnePozicije[6] = 0;
                    pogresanUnos = false;
                    break;
                case 8:
                    nizXO[7] = simbol;
                    slobodnePozicije[7] = 0;
                    pogresanUnos = false;
                    break;
                case 9:
                    nizXO[8] = simbol;
                    slobodnePozicije[8] = 0;
                    pogresanUnos = false;
                    break;
                default:
                    System.out.println("Pogresan unos");
                    i--;
                    pogresanUnos = true;

            }
            pobednik("Pobedio je korisnik", nizXO);

//            odabir kompa i dodavanje
            if(i < 5 && pogresanUnos == false) {
                while (bool) {
                    randomPozicija = (int) (Math.random()* 9);
                    if (randomPozicija != 0 && slobodnePozicije[randomPozicija] != 0) {
                        bool = false;
                        nizXO[randomPozicija] = komp;
                        slobodnePozicije[randomPozicija] = 0;
                    }
                }
                bool = true;
                pobednik("Pobedio je komp", nizXO);
            }

//            poslednji potez kada imamo samo jednu mogucnost ako ne zelimo da unosimo rucno
//            if (i == 4) {
//                for (int p = 0; p < slobodnePozicije.length; p++) {
//                    if (slobodnePozicije[p] != 0) {
//                        nizXO[p] = simbol;
//                    }
//                }
//                i++;
//            pobednik("Pobedio je korisnik", nizXO);
//            }

//            stampanje
            System.out.println(nizXO[0] + " " + nizXO[1] + " " + nizXO[2]);
            System.out.println(nizXO[3] + " " + nizXO[4] + " " + nizXO[5]);
            System.out.println(nizXO[6] + " " + nizXO[7] + " " + nizXO[8]);
            System.out.println();
        }

    }

//    metoda za proveru da li imamo pobednika
    public static void pobednik (String poruka, char[] nizXO) {
        if(nizXO[0] == nizXO[1] && nizXO[0] == nizXO[2] && nizXO[0] !=0 ||
                nizXO[3] == nizXO[4] && nizXO[3] == nizXO[5] && nizXO[3] != 0 ||
                nizXO[6] == nizXO[7] && nizXO[6] == nizXO[8] && nizXO[6] != 0 ||
                nizXO[0] == nizXO[3] && nizXO[0] == nizXO[6] && nizXO[0] != 0  ||
                nizXO[1] == nizXO[4] && nizXO[1] == nizXO[7] && nizXO[1] != 0  ||
                nizXO[2] == nizXO[5] && nizXO[2] == nizXO[8] && nizXO[2] != 0  ||
                nizXO[0] == nizXO[4] && nizXO[0] == nizXO[8] && nizXO[0] != 0  ||
                nizXO[2] == nizXO[4] && nizXO[2] == nizXO[6] && nizXO[2] != 0 ) {
            System.out.println(poruka);
            System.out.println(nizXO[0] + " " + nizXO[1] + " " + nizXO[2]);
            System.out.println(nizXO[3] + " " + nizXO[4] + " " + nizXO[5]);
            System.out.println(nizXO[6] + " " + nizXO[7] + " " + nizXO[8]);
            System.out.println();
            System.exit(1);
        }
    }
}
