package com.epam.graphoundry;

public class GraphBuilder {
    public static final String DEFAULT_NAME = "Graph";
    private String name = DEFAULT_NAME;

    GraphBuilder() {
    }

    public static GraphBuilder create() {
        return new GraphBuilder();
    }

    public GraphBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public Graph build() {
        return new DefaultGraph(name);
    }
}
