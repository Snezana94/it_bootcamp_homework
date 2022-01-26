import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class DomaciJava5 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {

//        String recenica = s.nextLine();
//        prebrojReci(recenica);

//        String recenica1 = "Prebroj slovo u recenici";
//        prebrojSlovo(recenica1.toLowerCase());

//        int[][] niz2d = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}
//        };
//        printArray(niz2d);
//        int[][] novi2d = rotiranjeMatrice(niz2d);

//        System.out.println("Slovo sa najvise pojava je: " + slovoSaNajvisePojava("proveri koje se slovo najvise puta ponovilo"));
        
    }

//    Korisnik unosi recenicu. Potrebno je izbrojati Koliko reci je bilo u recenici koju je korisnik uneo I ispisati
//    taj broj u konzolu. Koristiti metode.
    public static void prebrojReci(String recenica) {
        String[] reci = recenica.split(" ");
        System.out.println(reci.length);
    }

//    Inicijalizujte neki string. Korisnik unosi jedno slovo. Prebrojati Koliko puta se slovo koje je korisnik uneo
//    ponavlja u stringu. Koristiti metode.
    public static void prebrojSlovo(String recenica) {
        System.out.print("Unesite slovo: ");
        String slovo = s.next().toLowerCase();
        String[] nizReci = recenica.split(" ");
        int brojac = 0;

        for (int i = 0; i < nizReci.length; i++) {
            String[] nizSlova = nizReci[i].split("");
            for (int j = 0; j < nizSlova.length; j++) {
                if (slovo.equals(nizSlova[j])) brojac++;
            }
        }
        System.out.println(brojac);
    }

//    Deklarisati I inicijalizovati matricu n x m
//    Napisati metodu koja ce za primljenu matricu da napravi novu rotiranu za 90⁰. Odnosno vrsi se zamena
//    redova I kolona kao sa slike. Metoda vraca tu novodobijenu matricu.
    public static int[][] rotiranjeMatrice (int[][] niz2d) {
        int i = 0;
        int[][] nizRotiran = new int[niz2d[i].length][niz2d.length];
        for (i = 0; i < niz2d.length; i++) {
            for (int j = 0; j < niz2d[i].length; j++) {
                nizRotiran[j][i] = niz2d[i][j];
            }
        }

        printArray(nizRotiran);
        return nizRotiran;
    }
    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

//    Koje slovo ima najvise pojava u stringu koji korisnik unosi?
    public static char slovoSaNajvisePojava(String sentence) {
        final int ASCII_SIZE = 127;
        int[] asciiTable = new int[ASCII_SIZE];
        Arrays.fill(asciiTable, 0);
        String[] words = sentence.split("\\W+");

        for (int wordsIterator = 0; wordsIterator < words.length; wordsIterator++) {
            for (int charIterator = 0; charIterator < words[wordsIterator].length(); charIterator++) {
                char cChar = words[wordsIterator].charAt(charIterator);
                asciiTable[(int)cChar]++;
            }
        }

        int maxVal = asciiTable[0];
        int maxIter = 0;

        for (int i = 1; i < asciiTable.length; i++) {
            if (asciiTable[i] > maxVal) {
                maxVal = asciiTable[i];
                maxIter = i;
            }
        }

        return (char)maxIter;
    }



}
