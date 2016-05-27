package com.aaronhible.datastructures.array;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

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

    @Test(expected = IndexOutOfBoundsException.class)
    public void remove() {

        final DynamicArray array = buildArray(5);

        // remove the end (param is index NOT value)
        array.remove(8);

    }

    @Test
    public void remove_middle() {

        final DynamicArray array = buildArray(5);

        // remove the end (param is index NOT value)
        final Integer removed = (Integer) array.remove(2);

        assertEquals(new Integer(3), removed);
        assertEquals(4, array.size());

    }

    @Test
    public void remove_beginning() {

        final DynamicArray array = buildArray(5);

        // remove the end (param is index NOT value)
        final Integer removed = (Integer) array.remove(0);

        assertEquals(new Integer(1), removed);
        assertEquals(4, array.size());

    }

    @Test
    public void arrayListRemove() {

        final ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 1; i <= 5; i++) {
            array.add(i);
        }

        // remove the end (param is index NOT value)
        final Integer removedFirst = array.remove(0);

        assertEquals(new Integer(1), removedFirst);
        assertEquals(4, array.size());

        // remove the end (param is index NOT value)
        final Integer removedSecond = array.remove(0);

        assertEquals(new Integer(2), removedSecond);
        assertEquals(3, array.size());
    }

    @Test
    public void remove_again() {

        final DynamicArray array = buildArray(5);

        // remove the end (param is index NOT value)
        final Integer removedFirst = (Integer) array.remove(0);

        assertEquals(new Integer(1), removedFirst);
        assertEquals(4, array.size());

        // remove the end (param is index NOT value)
        final Integer removedSecond = (Integer) array.remove(0);

        assertEquals(new Integer(2), removedSecond);
        assertEquals(3, array.size());

    }

    @Test
    public void remove_end() {

        final DynamicArray array = buildArray(2);

        // remove the end (param is index NOT value)
        final Integer removed = (Integer) array.remove(1);

        assertEquals(new Integer(2), removed);
        assertEquals(1, array.size());

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
        final Integer first = (Integer) array.get(0);
        // should be 1
        assertEquals(new Integer(1), first);

        // grab the last element (zero based)
        final Integer last = (Integer) array.get(array.size() - 1);
        // should be 3
        assertEquals(new Integer(3), last);

    }
}
