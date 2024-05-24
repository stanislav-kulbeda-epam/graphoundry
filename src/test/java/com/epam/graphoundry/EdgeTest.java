package com.epam.graphoundry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EdgeTest {
    @Test
    public void testEdge() {
        Graph graph = Graph.create().withName("test").build();
        Vertex<String> vertex1 = VertexBuilder.<String>create(graph)
                .withValue("1")
                .build();
        Vertex<String> vertex2 = VertexBuilder.<String>create(graph)
                .withValue("2")
                .build();
        vertex1.addEdge(vertex2, () -> 10);
        Edge edge = vertex1.getEdges().getFirst();
        assertEquals(vertex1, edge.getFrom());
        assertEquals(vertex2, edge.getTo());
        assertFalse(edge.isDirected());
        assertEquals(10, edge.getWeight());
    }

    @Test
    public void testDirectedEdge() {
        Graph graph = Graph.create().withName("test").build();
        Vertex<String> vertex1 = VertexBuilder.<String>create(graph)
                .withValue("1")
                .build();
        Vertex<String> vertex2 = VertexBuilder.<String>create(graph)
                .withValue("2")
                .build();
        Edge edge = EdgeBuilder.create(vertex1, vertex2)
                .directed()
                .withWeight(() -> 10)
                .build();
        assertTrue(edge.isDirected());
    }
}