package com.epam.graphoundry;

public class VertexBuilder<V> {
    private final Graph graph;
    private V value;

    public VertexBuilder(Graph graph) {
        this.graph = graph;
    }

    public static  <V> VertexBuilder<V> create(Graph graph) {
        return new VertexBuilder<>(graph);
    }

    public VertexBuilder<V> withValue(V value) {
        this.value = value;
        return this;
    }

    public Vertex<V> build() {
        Vertex<V> vertex;
        if(value instanceof Integer) {
            vertex = (Vertex<V>) new IntVertex((Integer) value);
        } else if (value instanceof String) {
            vertex = (Vertex<V>) new StringVertex((String) value);
        } else {
            vertex = new AbstractVertex<>(value) {};

        }
        graph.addVertex(vertex);
        return vertex;
    }
}
