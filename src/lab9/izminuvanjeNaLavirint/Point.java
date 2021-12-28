package lab9.izminuvanjeNaLavirint;

public class Point {
    public int i;
    public int j;
    public Point previous;

    public Point(int i, int j, Point previous) {
        this.i = i;
        this.j = j;
        this.previous = previous;
    }
}