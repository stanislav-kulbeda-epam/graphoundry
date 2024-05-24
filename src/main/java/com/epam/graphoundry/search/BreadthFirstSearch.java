package com.epam.graphoundry.search;

import com.epam.graphoundry.Edge;
import com.epam.graphoundry.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch implements SearchPath {

    @Override
    public List<Vertex<?>> search(Vertex<?> start, Vertex<?> end) {
        return search(start, end, new ArrayList<>());
    }

    private List<Vertex<?>> search(Vertex<?> start, Vertex<?> end, List<Vertex<?>> visited) {
        visited.add(start);
        Queue<Vertex<?>> queue = new LinkedList<>();
        for (Edge edge : start.getEdges()) {
            if (edge.getTo().equals(end)) {
                return List.of(start, end);
            }
            if (!visited.contains(edge.getTo())){
                queue.add(edge.getTo());
            }
        }
        while (!queue.isEmpty()) {
            Vertex<?> vertex = queue.poll();
            if (!visited.contains(vertex)) {
                List<Vertex<?>> path = search(vertex, end, visited);
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
