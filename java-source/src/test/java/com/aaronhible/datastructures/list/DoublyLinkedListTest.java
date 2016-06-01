package com.aaronhible.datastructures.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import com.aaronhible.datastructures.list.AbstractLinkedList;
import com.aaronhible.datastructures.list.DoublyLinkedList;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class DoublyLinkedListTest {

    @Test
    public void previous_String() {
        final DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
        final String first = RandomStringUtils.randomAlphanumeric(10);
        final String third = RandomStringUtils.randomAlphanumeric(10);
        final String second = RandomStringUtils.randomAlphanumeric(10);
        final String last = RandomStringUtils.randomAlphanumeric(10);

        linkedList.add(first);
        linkedList.add(second);
        linkedList.add(third);
        linkedList.add(last);

        // check the middle
        String previous = linkedList.previous(third);
        assertEquals(second, previous);

        // check the end
        previous = linkedList.previous(last);
        assertEquals(third, previous);

        // check the front
        previous = linkedList.previous(first);
        assertNull(previous);

    }

    @Test
    public void remove_String() {
        final DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
        final String first = RandomStringUtils.randomAlphanumeric(10);
        final String third = RandomStringUtils.randomAlphanumeric(10);
        final String second = RandomStringUtils.randomAlphanumeric(10);
        final String last = RandomStringUtils.randomAlphanumeric(10);

        linkedList.add(first);
        linkedList.add(second);
        linkedList.add(third);
        linkedList.add(last);

        final String removed = linkedList.remove(second);
        assertEquals(second, removed);
        assertEquals(3, linkedList.size());
        assertFalse(linkedList.contains(removed));

        assertEquals(third, linkedList.next(first));
        assertEquals(last, linkedList.next(third));
        assertNull(linkedList.next(last));

        assertNull(linkedList.previous(first));
        assertEquals(first, linkedList.previous(third));
        assertEquals(third, linkedList.previous(last));

    }

    @Test
    public void traverse() {
        final AbstractLinkedList<String> linkedList = new DoublyLinkedList<>();
        final String first = RandomStringUtils.randomAlphanumeric(10);
        final String third = RandomStringUtils.randomAlphanumeric(10);
        final String second = RandomStringUtils.randomAlphanumeric(10);
        final String last = RandomStringUtils.randomAlphanumeric(10);

        linkedList.add(first);
        linkedList.add(second);
        linkedList.add(third);
        linkedList.add(last);

        final String firstInList = linkedList.first();
        String next = linkedList.next(firstInList);
        assertEquals(second, next);
        next = linkedList.next(next);
        assertEquals(third, next);
        next = linkedList.next(next);
        assertEquals(last, next);

    }

    @Test
    public void traverse_reverse() {
        final DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
        final String first = RandomStringUtils.randomAlphanumeric(10);
        final String third = RandomStringUtils.randomAlphanumeric(10);
        final String second = RandomStringUtils.randomAlphanumeric(10);
        final String last = RandomStringUtils.randomAlphanumeric(10);

        linkedList.add(first);
        linkedList.add(second);
        linkedList.add(third);
        linkedList.add(last);

        final String lastInList = linkedList.last();
        String previous = linkedList.previous(lastInList);
        assertEquals(third, previous);
        previous = linkedList.previous(previous);
        assertEquals(second, previous);
        previous = linkedList.previous(previous);
        assertEquals(first, previous);

    }

}
