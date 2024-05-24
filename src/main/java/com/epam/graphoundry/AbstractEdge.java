package com.epam.graphoundry;


import java.util.function.Supplier;

public abstract class AbstractEdge implements Edge {
    private final Vertex<?> from;
    private final Vertex<?> to;
    private final boolean directional;
    private final Supplier<Number> weightSupplier;

    protected AbstractEdge(Vertex<?> from, Vertex<?> to, Supplier<Number> weightSupplier) {
        this(from, to, false, weightSupplier);
    }

    protected AbstractEdge(Vertex<?> from, Vertex<?> to, boolean directional, Supplier<Number> weightSupplier) {
        this.from = from;
        this.to = to;
        this.directional = directional;
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
    public boolean isDirectional() {
        return directional;
    }

    @Override
    public Number getWeight() {
        return weightSupplier == null ? 0 : weightSupplier.get();
    }

    @Override
    public String toString() {
        String connection = "-" + (weightSupplier == null ? "" : weightSupplier.get()) + (directional ? ">" : "-");
        return "(" + from.toString() + ") " + connection + " (" + to.toString() + ")";
    }
}
