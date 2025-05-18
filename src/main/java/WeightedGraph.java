import java.util.*;

public class WeightedGraph<T>{
    private final Map<T, Vertex<T>> vertexMap = new HashMap<>();
    private final boolean directed;

    public WeightedGraph(boolean directed) {
        this.directed = directed;
    }

    public void addEdge(T from, T to, double weight) {
        Vertex<T> fromVertex = vertexMap.computeIfAbsent(from, Vertex::new);
        Vertex<T> toVertex = vertexMap.computeIfAbsent(to, Vertex::new);
        fromVertex.addAdjacentVertex(toVertex, weight);
        if (!directed) {
            toVertex.addAdjacentVertex(fromVertex, weight);
        }
    }

    public Vertex<T> getVertex(T value) {
        Vertex<T> v = vertexMap.get(value);
        if (v == null) {
            throw new NoSuchElementException("Vertex " + value + " not found in graph");
        }
        return v;
    }
    public Collection<Vertex<T>> getVertices() {
        return vertexMap.values();
    }
}
