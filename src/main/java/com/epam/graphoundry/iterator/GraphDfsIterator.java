package com.epam.graphoundry.iterator;

import com.epam.graphoundry.Edge;
import com.epam.graphoundry.Graph;
import com.epam.graphoundry.Vertex;

import java.util.*;

public class GraphDfsIterator extends AbstractGraphIterator {
    private final Stack<Edge> unvisitedEdges = new Stack<>();

    public GraphDfsIterator(Graph graph) {
        this(graph, true);
    }

    public GraphDfsIterator(Graph graph, boolean detectCycles) {
        this(graph, null, detectCycles);
    }

    public GraphDfsIterator(Graph graph, Vertex<?> startVertex) {
        this(graph, startVertex, true);
    }

    public GraphDfsIterator(Graph graph, Vertex<?> startVertex, boolean detectCycles) {
        super(graph, startVertex, detectCycles);
    }

    @Override
    protected Collection<Edge> getUnvisitedEdges() {
        return unvisitedEdges;
    }

    @Override
    protected void addUnvisitedEdges(Collection<Edge> edges) {
        edges.forEach(unvisitedEdges::push);
    }

    @Override
    protected Edge getUnvisitedEdge() {
        return unvisitedEdges.pop();
    }
}
