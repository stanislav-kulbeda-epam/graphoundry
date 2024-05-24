package com.epam.graphoundry.search;

import com.epam.graphoundry.Vertex;

import java.util.List;

public interface SearchPath {

    List<Vertex<?>> search(Vertex<?> start, Vertex<?> end);
}
