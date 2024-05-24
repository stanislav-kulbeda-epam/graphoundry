package com.epam.graphoundry;


import java.util.function.Supplier;

public abstract class AbstractEdge implements Edge {
    private final Vertex<?> from;
    private final Vertex<?> to;
    private final boolean directed;
    private final Supplier<Number> weightSupplier;

    protected AbstractEdge(Vertex<?> from, Vertex<?> to, Supplier<Number> weightSupplier) {
        this(from, to, false, weightSupplier);
    }

    protected AbstractEdge(Vertex<?> from, Vertex<?> to, boolean directed, Supplier<Number> weightSupplier) {
        this.from = from;
        this.to = to;
        this.directed = directed;
        this.weightSupplier = weightSupplier;
    }

    @Override
    public Vertex<?> getFrom() {
        return this.from;
    }

    @Override
    public Vertex<?> getTo() {
        return this.to;
    }

    @Override
    public boolean isDirected() {
        return directed;
    }

    @Override
    public Number getWeight() {
        return weightSupplier == null ? 0 : weightSupplier.get();
    }

    @Override
    public String toString() {
        String connection = "-" + (weightSupplier == null ? "" : weightSupplier.get()) + (directed ? ">" : "-");
        return "(" + from.toString() + ") " + connection + " (" + to.toString() + ")";
    }
}
