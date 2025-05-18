public class Edge<T>{
    private Vertex<T> sourse;
    private Vertex<T> dest;
    private double weight;

    public Edge(Vertex<T> sourse, Vertex<T> dest, double weight) {
        this.sourse = sourse;
        this.dest = dest;
        this.weight = weight;
    }

    public Vertex<T> getSourse() {
        return sourse;
    }

    public Vertex<T> getDest() {
        return dest;
    }

    public double getWeight() {
        return weight;
    }
}
