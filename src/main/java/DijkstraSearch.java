import java.util.*;

public class DijkstraSearch<T> extends Search<T> {
    private final Map<T, Double> distance = new HashMap<>();

    public DijkstraSearch(WeightedGraph<T> graph, T start) {
        super(graph, start);
        execute();
    }

    @Override
    protected void execute() {
        for (Vertex<T> vertex : graph.getVertices()) {
            distance.put(vertex.getValue(), Double.MAX_VALUE);
        }

        distance.put(start, 0.0);

        PriorityQueue<T> pq = new PriorityQueue<>(Comparator.comparingDouble(distance::get));
        pq.add(start);

        while (!pq.isEmpty()) {
            T current = pq.poll();
            if (visited.contains(current)) continue;
            visited.add(current);

            Vertex<T> currentVertex = graph.getVertex(current);
            for (Map.Entry<Vertex<T>, Double> entry : currentVertex.getAdjacentVertices().entrySet()) {
                Vertex<T> neighbor = entry.getKey();
                double weight = entry.getValue();
                T neighborValue = neighbor.getValue();

                double newDistance = distance.get(current) + weight;
                if (newDistance < distance.getOrDefault(neighborValue, Double.MAX_VALUE)) {
                    distance.put(neighborValue, newDistance);
                    path.put(neighborValue, current);
                    pq.add(neighborValue);
                }
            }
        }
    }

    public double getDistance(T target) {
        return distance.getOrDefault(target, Double.MAX_VALUE);
    }
}