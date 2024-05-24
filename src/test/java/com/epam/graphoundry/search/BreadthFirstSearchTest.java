package com.epam.graphoundry.search;

import com.epam.graphoundry.Edge;
import com.epam.graphoundry.Graph;
import com.epam.graphoundry.Vertex;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

class BreadthFirstSearchTest {

    @Test
    void search() {
        // start - 2, 3
        // 2 - 4, end
        // 3 - 5
        Graph graph = Graph.create().withName("test").build();
        Vertex<Integer> start = Vertex.<Integer>create(graph).withValue(1).build();
        Vertex<Integer> vertex2 = Vertex.<Integer>create(graph).withValue(2).build();
        Vertex<Integer> vertex3 = Vertex.<Integer>create(graph).withValue(3).build();
        Edge.create(start, vertex2).build();
        Edge.create(start, vertex3).build();
        Vertex<Integer> vertex4 = Mockito.mock();
        Vertex<Integer> vertex5 = Mockito.mock();
        Edge.create(vertex2, vertex4).build();
        Edge.create(vertex3, vertex5).build();
        Vertex<Integer> end = Vertex.<Integer>create(graph).withValue(8).build();
        Edge.create(vertex2, end).build();

        BreadthFirstSearch bfs = new BreadthFirstSearch();

        assertArrayEquals(new Vertex[]{start, vertex2, end}, bfs.search(start, end).toArray());

        verify(vertex4, never()).getEdges();
        verify(vertex5, never()).getEdges();
    }
}