package com.epam.graphoundry.search;

import com.epam.graphoundry.Graph;
import com.epam.graphoundry.Vertex;

import java.util.function.Predicate;

public class DefaultSearchVertex implements SearchVertex {
    @Override
    public Vertex<?> search(Graph graph, Predicate<Vertex<?>> predicate) {
        return graph.getVertices().stream()
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }
}
