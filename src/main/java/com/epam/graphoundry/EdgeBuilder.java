package com.epam.graphoundry;

import java.util.function.Supplier;

public class EdgeBuilder {
    private final Vertex<?> from;
    private final Vertex<?> to;
    private boolean directional;
    private Supplier<Number> weightSupplier;

    <V> EdgeBuilder(Vertex<V> from, Vertex<V> to) {
        this.from = from;
        this.to = to;
    }

    public static <V> EdgeBuilder create(Vertex<V> from, Vertex<V> to) {
        return new EdgeBuilder(from, to);
    }

    public EdgeBuilder withDirection() {
        this.directional = true;
        return this;
    }

    public EdgeBuilder withWeight(Supplier<Number> weightSupplier) {
        this.weightSupplier = weightSupplier;
        return this;
    }

    public Edge build() {
        DefaultEdge edge = new DefaultEdge(from, to, directional, weightSupplier);
        from.addEdge(edge);
        if(!directional) {
            to.addEdge(new DefaultEdge(to, from, false, weightSupplier));
        }
        return edge;
    }
}
