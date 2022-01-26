import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Locale;
import java.util.Scanner;

//Program jedan proverava prosecnu ocenu za kvalitet i uslugu restorana
//Program dva daje informacije o broju dana odabranog meseca

public class Domaci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        1.Zadatak
        System.out.print("Unesite ocenu za kvalitet: ");
        int kvalitet = scan.nextInt();

        System.out.print("Unesite ocenu za ");
        int usluga = scan.nextInt();

        if (kvalitet < 1 || kvalitet > 10 || usluga < 1 || usluga > 10) {
            System.out.println("Podaci nisu validni");
        } else {
            if(((kvalitet + usluga) / 2) >= 5) {
                System.out.println("Prosek veci od 5");
            } else if (((kvalitet + usluga) / 2) < 5 && kvalitet == 1) {
                System.out.println("Treba popraviti kvalitet");
            } else if (((kvalitet + usluga) / 2) < 5 && usluga == 1) {
                System.out.println("Treba popraviti uslugu");
            }
        }

//        2.Zadatak
        System.out.print("Unesite mesec: ");
        String mesec = scan.next().toLowerCase();

        switch (mesec) {
            case "januar":
            case "mart":
            case "maj":
            case "jul":
            case "avgust":
            case "oktobar":
            case "decembar":
                System.out.println("Mesec " + mesec + " ima 31 dan.");
                break;
            case "april":
            case "jun":
            case "septembar":
            case  "novembar":
                System.out.println("Mesec " + mesec + " ima 30 dana.");
                break;
            default:
                System.out.println("Mesec " + mesec + " ima 28 dana.");
        }
    }}
