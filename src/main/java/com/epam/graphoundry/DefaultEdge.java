package com.epam.graphoundry;

import java.util.function.Supplier;

public class DefaultEdge extends AbstractEdge {
    DefaultEdge(Vertex<?> from, Vertex<?> to, boolean directional, Supplier<Number> weightSupplier) {
        super(from, to, directional, weightSupplier);
    }

}
