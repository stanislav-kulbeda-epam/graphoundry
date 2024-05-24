package com.epam.graphoundry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGraph implements Graph {
    private final String name;
    private final List<Vertex<?>> vertices = new ArrayList<>();

    protected AbstractGraph(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addVertex(Vertex<?> vertex) {
        vertices.add(vertex);
        vertex.setGraph(this);
    }

    @Override
    public List<Vertex<?>> getVertices() {
        return vertices;
    }

    @Override
    public void join(Graph graph) {
        //todo: implement
    }

}
