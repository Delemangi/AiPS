package lab1.patuvanje;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        Patuvanje nizaPatuvanje[] = new Patuvanje[n];

        for (int i = 0; i < n; i++) {
            int tip = in.nextInt();
            if (tip == 0) {
                String ime = in.next();
                int cena = in.nextInt();
                int vreme = in.nextInt();
                nizaPatuvanje[i] = new GodishenOdmor(ime, cena, vreme);
            } else {
                String ime = in.next();
                int cena = in.nextInt();
                int pocD = in.nextInt();
                int pocM = in.nextInt();
                int krajD = in.nextInt();
                int krajM = in.nextInt();
                nizaPatuvanje[i] = new PraznicnoPatuvanje(ime, cena, pocD, pocM, krajD, krajM);

            }
        }

        //

        for (Patuvanje p : nizaPatuvanje) {
            if (p instanceof PraznicnoPatuvanje) {
                PraznicnoPatuvanje pp = (PraznicnoPatuvanje) p;

                if (pp.getPocM() == 6) {
                    System.out.print(pp.getIme() + " ");
                }
            }
        }
        System.out.println();

        //

        double avg = 0;
        for (Patuvanje p : nizaPatuvanje) {
            avg += p.vratiVremeVoDenovi();
        }
        avg /= nizaPatuvanje.length;
        System.out.println(avg);

        //

        String ime = in.next();
        int cena = in.nextInt();
        int vreme = in.nextInt();

        GodishenOdmor odmor = new GodishenOdmor(ime, cena, vreme);

        //

        System.out.println(vratiMinCena(nizaPatuvanje, nizaPatuvanje.length, odmor));
    }

    public static int vratiMinCena(Patuvanje[] niza, int n, Patuvanje zaSporedba) {
        int min = -1;
        Patuvanje pat;

        for (Patuvanje p : niza) {
            // TODO
        }

        return min;
    }
}
