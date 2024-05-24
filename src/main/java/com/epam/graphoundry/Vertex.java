package com.epam.graphoundry;

import java.util.List;
import java.util.function.Supplier;

public interface Vertex<V> {
    static <V> VertexBuilder<V> create(Graph graph) { return new VertexBuilder<>(graph); };

    V getValue();

    boolean addEdge(Vertex<V> to, Supplier<Number> weightSupplier);

    boolean addEdge(Vertex<V> to, Supplier<Number> weightSupplier, boolean directed);

    boolean removeEdge(Edge edge);

    List<Edge> getEdges();

//    List<Vertex<V>> getNeighbours();

    void setGraph(Graph graph);

    Graph getGraph();
}
