package com.aaronhible.datastructures.array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DynamicArrayTest {

    @Test
    public void add() {
        final DynamicArray array = buildArray(2);

        assertEquals(2, array.size());

        // add more than the 2 items
        array.add(3);
        array.add(4);

        assertEquals(4, array.size());

    }

    @Test
    public void remove() {
        final DynamicArray array = buildArray(2);

        final Integer removed = (Integer) array.remove(2);

        assertEquals(new Integer(2), removed);
        assertEquals(2, array.size());

    }

    /**
     * @return
     */
    protected DynamicArray buildArray(final int size) {
        final DynamicArray array = new DynamicArray(size);
        for (int index = 1; index <= size; index++) {
            array.add(index);
        }
        return array;
    }

    @Test
    public void get() {
        final DynamicArray array = buildArray(3);

        // grab the first element
        final Integer first = array.get(0);
        // should be 1
        assertEquals(new Integer(1), first);

        // grab the last element (zero based)
        final Integer last = array.get(array.size() - 1);
        // should be 3
        assertEquals(new Integer(3), last);

    }
}
