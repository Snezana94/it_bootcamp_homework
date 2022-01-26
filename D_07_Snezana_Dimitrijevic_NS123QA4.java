import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class XO {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

//        deklarisanje i inicijalizacija potrebnih promenljivih

        int[] slobodnePozicije = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        char[] nizXO = new char[9];
        int pozicija = 10;
        int i = 0;

//        izbor simbola
        char[] simboli = izborSimbola();
        char simbol = simboli[0];
        char komp = simboli[1];
        stampanjePocetak(slobodnePozicije);

//        igra
        while (i < 5) {
            i++;
            odabirPozicijeIgraca(slobodnePozicije, simbol, nizXO, pozicija);
            pobednik("Pobedio je korisnik", nizXO);
            odabirKompa(slobodnePozicije, nizXO, komp, i);
            stampanje(nizXO);
            if (i == 5) System.out.println("Nereseno!");
        }

    }

    public static char[] izborSimbola() {
        char komp = '-';
        char simbol = '-';
        boolean bool = false;
        while (bool == false) {
            System.out.print("Izaberite X ili O: ");
            simbol = s.next().toUpperCase(Locale.ROOT).charAt(0);
            if (simbol == 'X') {
                komp = 'O';
                bool = true;
            } else if (simbol == 'O'){
                komp = 'X';
                bool = true;
            } else {
                System.out.println("Ponovite unos, greska!");
            }

        }
        char[] simboli = {simbol, komp};
        return simboli;
    }

    public static void stampanjePocetak(int[] slobodnePozicije) {
        System.out.println();
        System.out.println(slobodnePozicije[0] + " " + slobodnePozicije[1] + " " + slobodnePozicije[2]);
        System.out.println(slobodnePozicije[3] + " " + slobodnePozicije[4] + " " + slobodnePozicije[5]);
        System.out.println(slobodnePozicije[6] + " " + slobodnePozicije[7] + " " + slobodnePozicije[8]);
        System.out.println();
    }

    public static void odabirPozicijeIgraca(int[] slobodnePozicije, char simbol, char[] nizXO, int pozicija) {
        boolean pogresanUnos = false;
        System.out.println("Slobodne pozicije: " + Arrays.toString(slobodnePozicije));
        System.out.print("Unesite poziciju: ");
        pozicija = s.nextInt();
        while (pogresanUnos == false) {
            if(pozicija > 0 && pozicija < 10 && slobodnePozicije[pozicija-1] != 0) {
                pogresanUnos = true;
            } else {
                System.out.print("Zauzeta pozicija, ponovite unos! ");
                pozicija = s.nextInt();
                pogresanUnos = false;
            }
        }
        pogresanUnos = false;
        System.out.println();
        switch (pozicija) {
            case 1:
                nizXO[0] = simbol;
                slobodnePozicije[0] = 0;
                break;
            case 2:
                nizXO[1] = simbol;
                slobodnePozicije[1] = 0;
                break;
            case 3:
                nizXO[2] = simbol;
                slobodnePozicije[2] = 0;
                break;
            case 4:
                nizXO[3] = simbol;
                slobodnePozicije[3] = 0;
                break;
            case 5:
                nizXO[4] = simbol;
                slobodnePozicije[4] = 0;
                break;
            case 6:
                nizXO[5] = simbol;
                slobodnePozicije[5] = 0;
                break;
            case 7:
                nizXO[6] = simbol;
                slobodnePozicije[6] = 0;
                break;
            case 8:
                nizXO[7] = simbol;
                slobodnePozicije[7] = 0;
                break;
            case 9:
                nizXO[8] = simbol;
                slobodnePozicije[8] = 0;
                break;
            default:
                System.out.println("Pogresan unos");
        }
    }

    public static void odabirKompa(int[] slobodnePozicije, char[] nizXO, char komp, int i) {
        boolean bool = true;
        int randomPozicija = 0;
        if(i < 5) {
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
        nizXO[randomPozicija] = komp;
    }

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

    public static void stampanje (char[] nizXO) {
        System.out.println(nizXO[0] + " " + nizXO[1] + " " + nizXO[2]);
        System.out.println(nizXO[3] + " " + nizXO[4] + " " + nizXO[5]);
        System.out.println(nizXO[6] + " " + nizXO[7] + " " + nizXO[8]);
        System.out.println();
    }

}
