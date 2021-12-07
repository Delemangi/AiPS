package lab6.statickoRutiranje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoutingHashJava {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        CBHT<String, String[]> cbht = new CBHT(N * 2);

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] ips = br.readLine().split(",");
            cbht.insert(input, ips);
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            String ip = br.readLine();
            SLLNode<MapEntry<String, String[]>> a = cbht.search(input);

            if (a != null) {
                String ip1 = ip.substring(0, ip.lastIndexOf("."));
                boolean valid = false;

                for (int j = 0; j < a.element.value.length; j++) {
                    String ip2 = a.element.value[j].substring(0, a.element.value[j].lastIndexOf("."));

                    if (ip1.equals(ip2)) {
                        valid = true;
                    }
                }

                if (valid) {
                    System.out.println("postoi");
                } else {
                    System.out.println("ne postoi");
                }
            } else {
                System.out.println("ne postoi");
            }
        }
    }
}