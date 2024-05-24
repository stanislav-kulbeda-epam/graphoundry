package com.epam.graphoundry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VertexTest {

    @Test
    public void testGetValue() {
        String testValue = "value";
        Graph graph = Graph.create().withName("test").build();
        Vertex<String> vertex = Vertex.<String>create(graph)
                .withValue(testValue)
                .build();
        assertEquals(testValue, vertex.getValue());
    }

    @Test
    public void testGetEdgesUndirected() {
        Graph graph = Graph.create().withName("test").build();
        Vertex<String> from = Vertex.<String>create(graph)
                .withValue("start")
                .build();
        Vertex<String> to = Vertex.<String>create(graph)
                .withValue("finish")
                .build();
        assertEquals(0, from.getEdges().size());

        Edge edge = Edge.create(from, to).build();

        assertEquals(1, from.getEdges().size());
        assertEquals(1, to.getEdges().size());
        assertEquals(edge, from.getEdges().getFirst());
        assertEquals(from, to.getEdges().getFirst().getTo());
    }

    @Test
    public void testGetEdgesDirected() {
        Graph graph = Graph.create().withName("test").build();
        Vertex<String> from = Vertex.<String>create(graph)
                .withValue("start")
                .build();
        Vertex<String> to = Vertex.<String>create(graph)
                .withValue("finish")
                .build();
        assertEquals(0, from.getEdges().size());

        Edge edge = Edge.create(from, to).withDirection().build();

        assertEquals(1, from.getEdges().size());
        assertEquals(edge, from.getEdges().getFirst());
        assertEquals(0, to.getEdges().size());
    }
    @Test
    public void testGetEdgesBiDirected() {
        Graph graph = Graph.create().withName("test").build();
        Vertex<String> start = Vertex.<String>create(graph)
                .withValue("start")
                .build();
        Vertex<String> finish = Vertex.<String>create(graph)
                .withValue("finish")
                .build();
        assertEquals(0, start.getEdges().size());

        Edge edgeFw = Edge.create(start, finish)
                .withDirection()
                .withWeight(() -> 1)
                .build();
        Edge edgeBw = Edge.create(finish, start)
                .withDirection()
                .withWeight(() -> 2)
                .build();

        assertEquals(1, start.getEdges().size());
        assertEquals(edgeFw, start.getEdges().getFirst());
        assertEquals(1, finish.getEdges().size());
        assertEquals(edgeBw, finish.getEdges().getFirst());
    }
}
