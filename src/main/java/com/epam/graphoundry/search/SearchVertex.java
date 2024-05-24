package com.epam.graphoundry.search;

import com.epam.graphoundry.Graph;
import com.epam.graphoundry.Vertex;

import java.util.function.Predicate;

public interface SearchVertex {
    Vertex<?> search(Graph graph, Predicate<Vertex<?>> predicate);
}
