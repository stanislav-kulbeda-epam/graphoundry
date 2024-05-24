package com.epam.graphoundry;

import java.util.List;

public interface Vertex<V> {
    static <V> VertexBuilder<V> create(Graph graph) { return new VertexBuilder<>(graph); };

    V getValue();

    boolean addEdge(Edge edge);

    boolean removeEdge(Edge edge);

    List<Edge> getEdges();

//    List<Vertex<V>> getNeighbours();

    void setGraph(Graph graph);

    Graph getGraph();
}
