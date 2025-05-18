public class DepthFirstSearch<T> extends Search<T> {
    public DepthFirstSearch(WeightedGraph<T> graph, T start) {
        super(graph, start);
        execute();
    }

    @Override
    protected void execute() {
        dfs(start);
    }
    private void dfs(T current) {
        visited.add(current);
        Vertex<T> currentVertex = graph.getVertex(current);

        for (Vertex<T> neighbor : currentVertex.getAdjacentVertices().keySet()) {
            T neighborValue = neighbor.getValue();
            if (!visited.contains(neighborValue)) {
                path.put(neighborValue, current);
                dfs(neighborValue);
            }
        }
    }
}
