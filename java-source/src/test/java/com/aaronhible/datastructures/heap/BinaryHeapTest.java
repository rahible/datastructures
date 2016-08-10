package com.aaronhible.datastructures.heap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class BinaryHeapTest {

    @Test
    public void insertReverse() {
        final BinaryHeap heap = new BinaryHeap();
        final int length = buildAndInsertReverse(heap);
        assertEquals(length, heap.size());

    }

    @Test
    public void insert() {
        final BinaryHeap heap = new BinaryHeap();
        final int length = buildAndInsert(heap);
        assertEquals(length, heap.size());

    }

    protected int buildAndInsert(final BinaryHeap heap) {
        final int length = 99;
        final String[] array = buildArray(length);
        insert(heap, array);
        return length;
    }

    /**
     * @param heap
     * @return
     */
    protected int buildAndInsertReverse(final BinaryHeap heap) {
        final int length = 99;
        final String[] array = buildReverseArray(length);
        insert(heap, array);
        return length;
    }

    /**
     * @param heap
     * @param array
     */
    protected void insert(final BinaryHeap heap, final String[] array) {
        for (int size = 1; size <= array.length; size++) {
            heap.insert(array[size - 1]);
        }
    }

    private static String[] buildReverseArray(final int size) {
        final String[] array = buildArray(size);
        final List<String> current = Arrays.asList(array);
        Collections.reverse(current);
        return current.toArray(array);
    }

    private static String[] buildArray(final int size) {
        final String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = String.valueOf(i);
        }
        return array;
    }

    @Test
    public void deleteMin() {
        final BinaryHeap heap = new BinaryHeap();
        final int length = buildAndInsertReverse(heap);
        String min = heap.deleteMin();
        assertEquals("98", min);
        min = heap.deleteMin();
        assertNotEquals("98", min);
        assertEquals(length - 2, heap.size());
    }
}
