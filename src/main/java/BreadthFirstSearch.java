import java.util.*;
public class BreadthFirstSearch<T> extends Search<T> {
    public BreadthFirstSearch(WeightedGraph<T> graph, T start) {
        super(graph, start);
        execute();
    }

    @Override
    protected void execute() {
        Queue<T> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            T current = queue.poll();
            Vertex<T> currentVertex = graph.getVertex(current);

            for (Vertex<T> neighbor : currentVertex.getAdjacentVertices().keySet()) {
                T neighborValue = neighbor.getValue();
                if (!visited.contains(neighborValue)) {
                    visited.add(neighborValue);
                    path.put(neighborValue, current);
                    queue.add(neighborValue);
                }
            }
        }
    }
}
