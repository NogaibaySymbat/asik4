public class UnweightedGraph<T> extends WeightedGraph<T> {
    public UnweightedGraph(boolean directed) {
        super(directed);
    }

    public void addEdge(T from, T to){
        super.addEdge(from, to, 1.0);
    }
}
