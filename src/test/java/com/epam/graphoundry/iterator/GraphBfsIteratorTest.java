package com.epam.graphoundry.iterator;

import com.epam.graphoundry.Edge;
import com.epam.graphoundry.Graph;
import com.epam.graphoundry.Vertex;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphBfsIteratorTest {

    @Test
    public void testIteratorHasNext() {
        Graph graph = Graph.create().withName("test").build();
        Vertex.create(graph).withValue(1).build();

        GraphBfsIterator iterator = new GraphBfsIterator(graph);

        assertTrue(iterator.hasNext());
    }

    @Test
    public void testIterationOrder() {
        // 1 - 2,3,4
        // 2 - 5
        // 3 - 6,7
        Graph graph = Graph.create().withName("test").build();
        Vertex<Integer> vertex1 = Vertex.<Integer>create(graph).withValue(1).build();
        Vertex<Integer> vertex2 = Vertex.<Integer>create(graph).withValue(2).build();
        Vertex<Integer> vertex3 = Vertex.<Integer>create(graph).withValue(3).build();
        Edge.create(vertex1, vertex2).build();
        Edge.create(vertex1, vertex3).build();
        Edge.create(vertex1, Vertex.<Integer>create(graph).withValue(4).build()).build();
        Edge.create(vertex2, Vertex.<Integer>create(graph).withValue(5).build()).build();
        Edge.create(vertex3, Vertex.<Integer>create(graph).withValue(6).build()).build();
        Edge.create(vertex3, Vertex.<Integer>create(graph).withValue(7).build()).build();

        GraphBfsIterator iterator = new GraphBfsIterator(graph);

        int[] expectedValues = {1, 2, 3, 4, 5, 6, 7};

        int i = 0;
        List<Integer> actual = new ArrayList<>();
        while(iterator.hasNext()) {
            Vertex<?> vertex = iterator.next();
            actual.add((Integer) vertex.getValue());
            assertEquals(expectedValues[i], vertex.getValue());
            i++;
        }

        int[] array = actual.stream().mapToInt(Integer::intValue).toArray();
        assertArrayEquals(expectedValues, array);
    }
}