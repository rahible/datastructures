package com.aaronhible.interview.linkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SinglyLinkedListTest {

    @Test
    public void contains() {

        final SinglyLinkedList linkedList = new SinglyLinkedList();
        final Integer one = new Integer(1);
        linkedList.add(one);

        assertTrue(linkedList.contains(one));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void add_IndexOutOfBoundsException() {
        final SinglyLinkedList linkedList = new SinglyLinkedList();

        for (int i = 0; i < 100; i++) {
            linkedList.add(new Integer(i));
        }
    }

    @Test
    public void add() {
        final SinglyLinkedList linkedList = new SinglyLinkedList();

        linkedList.add(new Integer(1));

        assertEquals("size should be 1", 1, linkedList.size());

        linkedList.add(new Integer(2));

        assertEquals("size should be 2", 2, linkedList.size());

        // we should be able to add duplicates this is not a set
        linkedList.add(new Integer(2));

        assertEquals("size should be 3", 3, linkedList.size());

    }

    @Test
    public void next() {
        final SinglyLinkedList linkedList = new SinglyLinkedList();
        final Integer one = new Integer(1);
        final Integer two = new Integer(1);
        linkedList.add(one);
        linkedList.add(two);
        final Integer next = linkedList.next(one);

        assertEquals(two, next);

        final Integer nextTwo = linkedList.next(two);

        assertNull(nextTwo);

    }

    @Test
    public void remove() {
        final SinglyLinkedList linkedList = new SinglyLinkedList();
        final Integer one = new Integer(1);
        linkedList.add(one);

        final Integer removed = linkedList.remove(one);

        assertTrue(linkedList.size() == 0);

        assertEquals(one, removed);

    }

    @Test
    public void size() {
        final SinglyLinkedList linkedList = new SinglyLinkedList();

        assertTrue(linkedList.size() == 0);

        final Integer one = new Integer(1);
        linkedList.add(one);

        assertTrue(linkedList.size() == 1);

        linkedList.remove(one);

        assertTrue(linkedList.size() == 0);
    }

}
