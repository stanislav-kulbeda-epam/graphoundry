package com.epam.graphoundry.iterator;

import com.epam.graphoundry.CycleException;
import com.epam.graphoundry.Edge;
import com.epam.graphoundry.Graph;
import com.epam.graphoundry.Vertex;

import java.util.*;
import java.util.function.Predicate;

public abstract class AbstractGraphIterator implements GraphIterator {
    private final List<Vertex<?>> vertices;
    private final List<Vertex<?>> visited;
    private Vertex<?> currentVertex;
    private final boolean detectCycles;

    public AbstractGraphIterator(Graph graph, Vertex<?> startVertex, boolean detectCycles) {
        Objects.requireNonNull(graph, "Graph cannot be null");
        this.vertices = graph.getVertices();
        this.visited = new ArrayList<>(graph.getVertices().size());
        move(startVertex);
        this.detectCycles = detectCycles;
    }

    @Override
    public boolean hasNext() {
        return (currentVertex == null && !vertices.isEmpty()) || getUnvisitedEdges().stream().anyMatch(edge -> !visited.contains(edge.getTo()));
    }

    protected abstract Collection<Edge> getUnvisitedEdges();

    protected abstract void addUnvisitedEdges(Collection<Edge> edges);

    protected abstract Edge getUnvisitedEdge();

    @Override
    public Vertex<?> next() {
        if(currentVertex == null) {
            return move(vertices.getFirst());
        }
        if(getUnvisitedEdges().isEmpty()) {
            return null;
        }
        Edge edge = getUnvisitedEdge();
        return move(edge.getTo());
    }

    private Vertex<?> move(Vertex<?> vertex) {
        if (vertex == null) {
            return null;
        }
        if (visited.contains(vertex)) {
            if(detectCycles) {
                throw new CycleException("Cycle detected on vertex '" + vertex.getValue() + "' in graph '" + vertex.getGraph().getName() + "' with visited vertices " + visited);
            }
            return next();
        }
        visited.add(vertex);
        Predicate<Edge> excludeCurrent = edge -> currentVertex == null || !currentVertex.equals(edge.getTo());
        addUnvisitedEdges(vertex.getEdges().stream().filter(excludeCurrent).toList());
        currentVertex = vertex;
        return vertex;
    }

}
