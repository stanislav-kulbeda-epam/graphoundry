package com.epam.graphoundry.iterator;

import com.epam.graphoundry.Edge;
import com.epam.graphoundry.Graph;
import com.epam.graphoundry.Vertex;

import java.util.*;

public class GraphBfsIterator extends AbstractGraphIterator {

    private final Queue<Edge> unvisitedEdges = new LinkedList<>();

    public GraphBfsIterator(Graph graph) {
        this(graph, null);
    }

    public GraphBfsIterator(Graph graph, Vertex<?> startVertex) {
        super(graph, startVertex, false);
    }

    @Override
    protected Collection<Edge> getUnvisitedEdges() {
        return unvisitedEdges;
    }

    @Override
    protected void addUnvisitedEdges(Collection<Edge> edges) {
        unvisitedEdges.addAll(edges);
    }

    @Override
    protected Edge getUnvisitedEdge() {
        return unvisitedEdges.poll();
    }
}
