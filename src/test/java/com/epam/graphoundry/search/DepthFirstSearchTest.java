package com.epam.graphoundry.search;

import com.epam.graphoundry.Edge;
import com.epam.graphoundry.Graph;
import com.epam.graphoundry.Vertex;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DepthFirstSearchTest {

    @Test
    void search() {
        // start - 2, 3
        // 2 - 4, end
        Graph graph = Graph.create().withName("test").build();
        Vertex<Integer> start = Vertex.<Integer>create(graph).withValue(1).build();
        Vertex<Integer> vertex2 = Vertex.<Integer>create(graph).withValue(2).build();
        Vertex<Integer> vertex3 = Mockito.mock();
        Edge.create(start, vertex2).build();
        Edge.create(start, vertex3).build();
        Vertex<Integer> vertex4 = Mockito.mock();
        Edge.create(vertex2, vertex4).build();
        Vertex<Integer> end = Vertex.<Integer>create(graph).withValue(8).build();
        Edge.create(vertex2, end).build();

        DepthFirstSearch dfs = new DepthFirstSearch();

        assertArrayEquals(new Vertex[]{start, vertex2, end}, dfs.search(start, end).toArray());
        verify(vertex4, times(1)).getEdges();
        verify(vertex3, never()).getEdges();
    }
}