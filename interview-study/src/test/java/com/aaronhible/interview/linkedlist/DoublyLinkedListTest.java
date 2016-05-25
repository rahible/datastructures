package com.aaronhible.interview.linkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

}
