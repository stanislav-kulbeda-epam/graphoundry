package com.epam.graphoundry;

import java.util.function.Supplier;

public class EdgeBuilder {
    private final Vertex<?> from;
    private final Vertex<?> to;
    private boolean directed;
    private Supplier<Number> weightSupplier;

    <V> EdgeBuilder(Vertex<V> from, Vertex<V> to) {
        this.from = from;
        this.to = to;
    }

    public static <V> EdgeBuilder create(Vertex<V> from, Vertex<V> to) {
        return new EdgeBuilder(from, to);
    }

    public EdgeBuilder directed(boolean directed) {
        this.directed = directed;
        return this;
    }

    public EdgeBuilder directed() {
        return directed(true);
    }

    public EdgeBuilder withWeight(Supplier<Number> weightSupplier) {
        this.weightSupplier = weightSupplier;
        return this;
    }

    public Edge build() {
        return new DefaultEdge(from, to, directed, weightSupplier);
    }
}
