package com.epam.graphoundry.search;

import com.epam.graphoundry.Edge;
import com.epam.graphoundry.Graph;
import com.epam.graphoundry.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultSearchVertexTest {

    @Test
    void search() {
        Graph graph = Graph.create().withName("test").build();
        Vertex<Integer> start = Vertex.<Integer>create(graph).withValue(1).build();
        Vertex<Integer> vertex2 = Vertex.<Integer>create(graph).withValue(2).build();
        Vertex<Integer> vertex3 = Vertex.<Integer>create(graph).withValue(3).build();
        Edge.create(start, vertex2).build();
        Edge.create(start, vertex3).build();

        DefaultSearchVertex searchVertex = new DefaultSearchVertex();
        Vertex<?> result = searchVertex.search(graph, vertex -> vertex.getValue().equals(2));
        assertEquals(vertex2, result);

        Vertex<?> emptyResult = searchVertex.search(graph, vertex -> vertex.getValue().equals(4));
        assertNull(emptyResult);
    }
}