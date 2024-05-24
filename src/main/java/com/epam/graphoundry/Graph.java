package com.epam.graphoundry;

import java.util.List;

public interface Graph {

    static GraphBuilder create() { return new GraphBuilder(); }

    String getName();

    void addVertex(Vertex<?> vertex);

    List<Vertex<?>> getVertices();

    void join(Graph graph);
}
