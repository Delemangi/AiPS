package lab4.SalterotNaMVR;

import java.util.Scanner;

public class MVR {
    public static void main(String[] args) {
        Scanner br = new Scanner(System.in);
        int N = Integer.parseInt(br.nextLine());

        ArrayQueue<Gragjanin> queueKarti = new ArrayQueue<>(10);
        ArrayQueue<Gragjanin> queuePasosi = new ArrayQueue<>(10);
        ArrayQueue<Gragjanin> queueVozacki = new ArrayQueue<>(10);

        for (int i = 1; i <= N; i++) {
            String imePrezime = br.nextLine();
            int lKarta = Integer.parseInt(br.nextLine());
            int pasos = Integer.parseInt(br.nextLine());
            int vozacka = Integer.parseInt(br.nextLine());
            Gragjanin covek = new Gragjanin(imePrezime, lKarta, pasos, vozacka);

            if (lKarta == 1) {
                queueKarti.enqueue(covek);
            } else if (pasos == 1) {
                queuePasosi.enqueue(covek);
            } else if (vozacka == 1) {
                queueVozacki.enqueue(covek);
            }
        }

        while (!queueKarti.isEmpty()) {
            if (queueKarti.peek().pasos == 1) {
                queuePasosi.enqueue(queueKarti.dequeue());
            } else if (queueKarti.peek().vozacka == 1) {
                queueVozacki.enqueue(queueKarti.dequeue());
            } else {
                System.out.println(queueKarti.dequeue().imePrezime);
            }
        }

        while (!queuePasosi.isEmpty()) {
            if (queuePasosi.peek().vozacka == 1) {
                queueVozacki.enqueue(queuePasosi.dequeue());
            } else {
                System.out.println(queuePasosi.dequeue().imePrezime);
            }
        }

        while (!queueVozacki.isEmpty()) {
            System.out.println(queueVozacki.dequeue().imePrezime);
        }
    }
}