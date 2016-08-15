package com.aaronhible.datastructures.heap;

import static org.junit.Assert.assertEquals;

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
        final Integer[] array = buildArray(length);
        insert(heap, array);
        return length;
    }

    /**
     * @param heap
     * @return
     */
    protected int buildAndInsertReverse(final BinaryHeap heap) {
        final int length = 99;
        final Integer[] array = buildReverseArray(length);
        insert(heap, array);
        return length;
    }

    /**
     * @param heap
     * @param array
     */
    protected void insert(final BinaryHeap heap, final Integer[] array) {
        for (int size = 1; size <= array.length; size++) {
            heap.insert(array[size - 1]);
        }
    }

    private static Integer[] buildReverseArray(final int size) {
        final Integer[] array = buildArray(size);
        final List<Integer> current = Arrays.asList(array);
        Collections.reverse(current);
        return current.toArray(array);
    }

    private static Integer[] buildArray(final int size) {
        final Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.valueOf(i);
        }
        return array;
    }

    @Test
    public void deleteMin() {
        final BinaryHeap heap = new BinaryHeap();
        final int length = buildAndInsertReverse(heap);
        int expectedSize = length;

        for (int i = 0; i < length; i++) {
            final Integer min = heap.deleteMin();
            assertEquals(Integer.valueOf(i), min);
            assertEquals(--expectedSize, heap.size());
        }
    }

}
