package k2.komponentiNaSvrzanost;

import java.util.LinkedList;

public class GraphNode<E> {
    private int index;//index (reden broj) na temeto vo grafot
    private E ime;
    private E prezime;
    private LinkedList<GraphNode<E>> neighbors;

    public GraphNode(int index, E ime, E prezime) {
        this.index = index;
        this.ime = ime;
        this.prezime = prezime;
        neighbors = new LinkedList<GraphNode<E>>();
    }

    public GraphNode(int index) {
        this.index = index;

        neighbors = new LinkedList<GraphNode<E>>();
    }

    boolean containsNeighbor(GraphNode<E> o) {
        return neighbors.contains(o);
    }

    void addNeighbor(GraphNode<E> o) {
        neighbors.add(o);
    }

    void removeNeighbor(GraphNode<E> o) {
        if (neighbors.contains(o))
            neighbors.remove(o);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public LinkedList<GraphNode<E>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(LinkedList<GraphNode<E>> neighbors) {
        this.neighbors = neighbors;
    }
}