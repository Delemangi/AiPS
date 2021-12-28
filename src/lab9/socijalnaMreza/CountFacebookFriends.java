package lab9.socijalnaMreza;

import java.io.*;

public class CountFacebookFriends {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Profile[] profiles = new Profile[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            profiles[i] = new Profile(i, 0);
        }

        Graph<Profile> graph = new Graph<>(N, profiles);

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());

            for (int j = 0; j < M; j++) {
                int id = Integer.parseInt(br.readLine().split("\\s+")[0]);

                graph.addEdge(i, id);
                graph.addEdge(id, i);
            }
        }

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        Queue<Profile> queue = new LinkedQueue<>();
        queue.enqueue(profiles[a]);
        visited[a] = true;

        while (!queue.isEmpty()) {
            Profile profile = queue.dequeue();

            if (profile.id == b) {
                System.out.println(profile.length);
                break;
            }

            for (int i = 0; i < N; i++) {
                if (graph.adjacent(profile.id, i) == 1 && !visited[i]) {
                    queue.enqueue(profiles[i]);
                    visited[i] = true;
                    profiles[i].length = profile.length + 1;
                }
            }
        }
    }
}