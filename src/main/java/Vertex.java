import java.util.*;
public class Vertex<T>{
    private T value;
    private Map<Vertex<T>, Double> adjacentVertices = new HashMap<>();
    public Vertex(T value){
        this.value = value;
    }
    public void addAdjacentVertex(Vertex<T> vertex, double weight){
        adjacentVertices.put(vertex, weight);
    }
    public Map<Vertex<T>, Double> getAdjacentVertices(){
        return adjacentVertices;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex<?> vertex)) return false;
        return Objects.equals(value, vertex.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public T getValue() {
        return value;
    }
}
