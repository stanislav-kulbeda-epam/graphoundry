package com.epam.graphoundry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public abstract class AbstractVertex<V> implements Vertex<V> {
    private final V value;
    private final List<Edge> edges = new ArrayList<>();
    private Graph graph;

    protected AbstractVertex(V value) {
        this.value = value;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public boolean addEdge(Vertex<V> to, Supplier<Number> weightSupplier) {
        return addEdge(to, weightSupplier, false);
    }
    @Override
    public boolean addEdge(Vertex<V> to, Supplier<Number> weightSupplier, boolean directed) {
        Edge edge = Edge.create(this, to).withWeight(weightSupplier).directed(directed).build();
        if(!this.graph.getVertices().contains(edge.getTo())) {
            this.graph.addVertex(edge.getTo());
        }
        return edges.add(edge);
    }

    @Override
    public boolean removeEdge(Edge edge) {
        //todo split Graphs if Vertices disconnected
        return edges.remove(edge);
    }

    @Override
    public List<Edge> getEdges() {
        return edges;
    }

    @Override
    public void setGraph(Graph graph) {
        if(this.graph == graph) {
            return;
        }
        if(this.graph != null) {
            this.graph.join(graph);
        }
        this.graph = graph;
        edges.forEach(edge -> edge.getTo().setGraph(graph));
    }

    @Override
    public Graph getGraph() {
        return graph;
    }

    @Override
    public String toString() {
        return getValue().toString();
    }
}
