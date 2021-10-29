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
        int previousCount = -1;
        int count;

        for (int i = 0; i < St.length; i++) {
            if (St[i] == 'S') {
                count = 0;

                for (int j = i + 1; j < St.length; j++) {
                    if (St[j] == 'T') {
                        count++;
                    }

                    if (St[j] == 'S') {
                        break;
                    }
                }

                if (previousCount != -1 && previousCount != count) {
                    return 0;
                }

                previousCount = count;
            }
        }

        return 1;
    }
}