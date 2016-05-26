package com.aaronhible.datastructures.linkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.aaronhible.datastructures.linkedlist.SinglyLinkedList;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class SinglyLinkedListTest {

    @Test
    public void contains_Integer() {

        final SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
        final Integer one = new Integer(RandomStringUtils.randomNumeric(5));
        linkedList.add(one);

        assertTrue(linkedList.contains(one));

    }

    @Test
    public void add_Integer() {
        final SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();

        linkedList.add(new Integer(RandomStringUtils.randomNumeric(5)));

        assertEquals("size should be 1", 1, linkedList.size());

        linkedList.add(new Integer(RandomStringUtils.randomNumeric(5)));

        assertEquals("size should be 2", 2, linkedList.size());

        // we should be able to add duplicates this is not a set
        linkedList.add(new Integer(RandomStringUtils.randomNumeric(5)));

        assertEquals("size should be 3", 3, linkedList.size());

    }

    @Test
    public void next_Integer() {
        final SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
        final Integer one = new Integer(RandomStringUtils.randomNumeric(5));
        final Integer two = new Integer(RandomStringUtils.randomNumeric(5));
        linkedList.add(one);
        linkedList.add(two);
        final Integer next = linkedList.next(one);

        assertEquals(two, next);

        final Integer nextTwo = linkedList.next(two);

        assertNull(nextTwo);

    }

    @Test
    public void remove_Integer() {
        final SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
        final Integer one = new Integer(RandomStringUtils.randomNumeric(5));
        linkedList.add(one);

        final Integer removed = linkedList.remove(one);

        assertTrue(linkedList.size() == 0);

        assertEquals(one, removed);

    }

    @Test
    public void size_Integer() {
        final SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();

        assertTrue(linkedList.size() == 0);

        final Integer one = new Integer(RandomStringUtils.randomNumeric(5));
        linkedList.add(one);

        assertTrue(linkedList.size() == 1);

        linkedList.remove(one);

        assertTrue(linkedList.size() == 0);
    }

    @Test
    public void contains_String() {

        final SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();
        final String one = RandomStringUtils.randomAlphanumeric(10);
        linkedList.add(one);

        assertTrue(linkedList.contains(one));

    }

    @Test
    public void add_String() {
        final SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();

        linkedList.add(RandomStringUtils.randomAlphanumeric(10));

        assertEquals("size should be 1", 1, linkedList.size());

        linkedList.add(RandomStringUtils.randomAlphanumeric(10));

        assertEquals("size should be 2", 2, linkedList.size());

        // we should be able to add duplicates this is not a set
        linkedList.add(RandomStringUtils.randomAlphanumeric(10));

        assertEquals("size should be 3", 3, linkedList.size());

    }

    @Test
    public void next_String() {
        final SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();
        final String one = RandomStringUtils.randomAlphanumeric(10);
        final String two = RandomStringUtils.randomAlphanumeric(10);
        linkedList.add(one);
        linkedList.add(two);
        final String next = linkedList.next(one);

        assertEquals(two, next);

        final String nextTwo = linkedList.next(two);

        assertNull(nextTwo);

    }

    @Test
    public void remove_String() {
        final SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();
        final String one = RandomStringUtils.randomAlphanumeric(10);
        linkedList.add(one);

        final String removed = linkedList.remove(one);

        assertTrue(linkedList.size() == 0);

        assertEquals(one, removed);

    }

    @Test
    public void size_String() {
        final SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();

        assertTrue(linkedList.size() == 0);

        final String one = RandomStringUtils.randomAlphanumeric(10);
        linkedList.add(one);

        assertTrue(linkedList.size() == 1);

        linkedList.remove(one);

        assertTrue(linkedList.size() == 0);
    }

}
