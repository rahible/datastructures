package com.aaronhible.datastructures.heap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class BinaryHeapTest {

    @Test
    public void insert() {
        final BinaryHeap heap = new BinaryHeap();
        final int length = 99;
        final String[] array = buildArray(length);

        for (int size = 1; size <= array.length; size++) {
            heap.insert(array[size - 1]);
        }
        assertEquals(length, heap.size());

    }

    private static String[] buildArray(final int size) {
        final String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = RandomStringUtils.randomNumeric(3);
        }
        final List<String> current = Arrays.asList(array);
        Collections.reverse(current);
        return current.toArray(array);
    }

    @Test
    public void deleteMin() {
        assertFalse(true);
    }
}
