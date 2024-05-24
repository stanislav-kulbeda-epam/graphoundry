package com.epam.graphoundry.search;

import com.epam.graphoundry.Edge;
import com.epam.graphoundry.Vertex;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch implements SearchPath {
    @Override
    public List<Vertex<?>> search(Vertex<?> start, Vertex<?> end) {
        List<Vertex<?>> visited = new ArrayList<>();
        return search(start, end, visited);
    }

    private List<Vertex<?>> search(Vertex<?> start, Vertex<?> end, List<Vertex<?>> visited) {
        visited.add(start);
        for (Edge edge : start.getEdges()) {
            if (edge.getTo().equals(end)) {
                return List.of(start, end);
            }
            if (!visited.contains(edge.getTo())) {
                List<Vertex<?>> path = search(edge.getTo(), end, visited);
                if (!path.isEmpty()) {
                    List<Vertex<?>> extendedPath = new ArrayList<>(path);
                    extendedPath.addFirst(start);
                    return extendedPath;
                }
            }
        }
        return List.of();
    }
}
