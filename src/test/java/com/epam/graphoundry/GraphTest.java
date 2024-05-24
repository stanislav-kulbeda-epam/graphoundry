package com.epam.graphoundry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTest {

    @Test
    public void testGraphOneVertex() {
        Graph graph = Graph.create()
                .withName("test")
                .build();
        Vertex<Integer> vertex = Vertex.<Integer>create(graph)
                .withValue(1)
                .build();

        assertEquals("test", graph.getName());
        assertEquals(1, graph.getVertices().size());
        assertEquals(vertex, graph.getVertices().getFirst());
    }

    @Test
    public void testGraphMultipleVertices() {
        Graph graph = Graph.create()
                .withName("test")
                .build();
        Vertex<Integer> vertex1 = Vertex.<Integer>create(graph)
                .withValue(1)
                .build();
        Vertex<Integer> vertex2 = Vertex.<Integer>create(graph)
                .withValue(2)
                .build();

        Edge edge = Edge.create(vertex1, vertex2)
                .withWeight(() -> 10)
                .build();

        assertEquals("test", graph.getName());
        assertEquals(2, graph.getVertices().size());
        assertEquals(vertex1, graph.getVertices().getFirst());
        assertEquals(edge, graph.getVertices().getFirst().getEdges().getFirst());
        assertEquals(vertex2, graph.getVertices().getFirst().getEdges().getFirst().getTo());
    }
}
