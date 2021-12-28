package lab9.izminuvanjeNaLavirint;

import java.io.*;

public class Lavirint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] tokens = line.split(",");
        int M = Integer.parseInt(tokens[0]);
        int N = Integer.parseInt(tokens[1]);
        char[][] maze = new char[M][N];
        boolean[][] visited = new boolean[M][N];
        Queue<Point> queue = new LinkedQueue<>();
        Stack<Point> stack = new LinkedStack<>();
        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Point point = null;

        for (int i = 0; i < M; i++) {
            line = br.readLine();

            for (int j = 0; j < N; j++) {
                maze[i][j] = line.charAt(j);

                if (maze[i][j] == 'S') {
                    visited[i][j] = true;
                    queue.enqueue(new Point(i, j, null));
                }
            }
        }

        while (!queue.isEmpty()) {
            point = queue.dequeue();

            if (maze[point.i][point.j] == 'E') {
                break;
            }

            for (int[] a : moves) {
                int x = point.i + a[0];
                int y = point.j + a[1];

                if (x < M && y < N && !visited[x][y] && maze[x][y] != '#') {
                    visited[x][y] = true;
                    queue.enqueue(new Point(x, y, point));
                }
            }
        }

        while (point != null) {
            stack.push(point);
            point = point.previous;
        }

        while (!stack.isEmpty()) {
            point = stack.pop();
            System.out.printf("%d,%d%n", point.i, point.j);
        }

        br.close();
    }
}