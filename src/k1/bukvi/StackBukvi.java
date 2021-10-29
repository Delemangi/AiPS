package k1.bukvi;

import java.io.IOException;
import java.util.Scanner;

public class StackBukvi {
    public static void main(String[] args) throws IOException {
        char[] niza = new char[100];

        Scanner f = new Scanner(System.in);
        String st = f.next();
        niza = st.toCharArray();

        int rez = proveri_t_posle_s(niza);
        System.out.println(rez);
    }

    static int proveri_t_posle_s(char[] St) {

    }
}