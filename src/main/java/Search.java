import java.util.*;

public abstract class Search<T> {
    protected final Set<T> visited = new HashSet<>();
    protected final Map<T, T> path = new HashMap<>();
    protected final WeightedGraph<T> graph;
    protected final T start;
    public Search(WeightedGraph<T> graph, T start) {
        this.graph = graph;
        this.start = start;
    }

    protected abstract void execute();

    public boolean hasPathTo(T target) {
        return visited.contains(target);
    }

    public List<T> pathTo(T target) {
        if (!hasPathTo(target)) return null;
        LinkedList<T> result = new LinkedList<>();
        for (T at = target; !at.equals(start); at = path.get(at)) {
            result.addFirst(at);
        }
        result.addFirst(start);
        return result;
    }
}
