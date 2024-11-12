package it.unibo.generics.graph;

import it.unibo.generics.graph.api.Graph;
import java.util.*;

public class GraphImpl<N> implements Graph<N> {

    private final Map<N, Set<N>> graph = new HashMap<>();

    public void addNode(N node) {
        if (node != null || !graph.containsKey(node)) {
            graph.put(node, new HashSet<>());
        }
    }

    public void addEdge(N source, N target) {
        if (source != null || target != null) {
            graph.putIfAbsent(source, new HashSet<>());
            graph.putIfAbsent(target, new HashSet<>());
            graph.get(source).add(target);
        }
    }

    public Set<N> nodeSet() {
        return new HashSet<>(graph.keySet());
    }

    public Set<N> linkedNodes(N node) {
        return graph.getOrDefault(node, Collections.emptySet());
    }

public List<N> getPath(N source, N target) {
    List<N> path = new ArrayList<>();
    Set<N> checked = new HashSet<>();
    
    if (found(source, target, checked, path)) {
        return path;
    }
    return null;
}

private boolean found(N current, N target, Set<N> checked, List<N> path) {
    if (current.equals(target)) {
        path.add(current);
        return true;
    }

    checked.add(current);
    
    for (N linked : linkedNodes(current)) {
        if (!checked.contains(linked)) {
            if (found(linked, target, checked, path)) {
                path.add(0, current);
                return true;
            }
        }
    }
    
    return false;
}
}