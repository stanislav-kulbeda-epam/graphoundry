package com.epam.graphoundry;

public interface Edge {
    static <V> EdgeBuilder create(Vertex<V> from, Vertex<V> to) { return new EdgeBuilder(from, to); }

    Vertex<?> getFrom();

    Vertex<?> getTo();

    boolean isDirected();

    Number getWeight();
}
