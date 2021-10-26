package lab1.patuvanje;

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

        // барање 1

        for (Patuvanje p : nizaPatuvanje) {
            if (p instanceof PraznicnoPatuvanje && ((PraznicnoPatuvanje) p).getPocM() == 6) {
                System.out.print(p.getIme() + " ");
            }
        }
        System.out.println();

        // барање 2

        double avg = 0;
        for (Patuvanje p : nizaPatuvanje) {
            avg += p.vratiVremeVoDenovi();
        }
        System.out.println(avg / nizaPatuvanje.length);

        // барање 3

        String ime = in.next();
        int cena = in.nextInt();
        int vreme = in.nextInt();

        GodishenOdmor odmor = new GodishenOdmor(ime, cena, vreme);

        // барање 4

        System.out.println(vratiMinCena(nizaPatuvanje, nizaPatuvanje.length, odmor));
    }

    public static int vratiMinCena(Patuvanje[] niza, int n, Patuvanje zaSporedba) {
        int min = -1;

        for (Patuvanje p : niza) {
            if (p.vratiVremeVoDenovi() > zaSporedba.vratiVremeVoDenovi() && (min == -1 || min > p.getCena())) {
                min = p.getCena();
            }
        }

        return min;
    }
}