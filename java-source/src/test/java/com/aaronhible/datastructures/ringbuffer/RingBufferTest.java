package com.aaronhible.datastructures.ringbuffer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class RingBufferTest {

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void create_0() {
        new RingBuffer(0);
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void create_negative() {
        final String randomValue = RandomStringUtils.randomNumeric(3);
        int size = Integer.parseInt(randomValue);
        size = (size > 0) ? (size * -1) : size;
        new RingBuffer(size);
    }

    @Test
    public void add() {
        final RingBuffer buffer = new RingBuffer(3);
        // final String first = RandomStringUtils.randomAlphabetic(5);
        // final String second = RandomStringUtils.randomAlphabetic(5);
        // final String third = RandomStringUtils.randomAlphabetic(5);
        // final String fourth = RandomStringUtils.randomAlphabetic(5);
        // final String fifth = RandomStringUtils.randomAlphabetic(5);
        final String first = "A";
        final String second = "B";
        final String third = "C";
        final String fourth = "D";
        final String fifth = "E";
        buffer.add(first);
        buffer.add(second);
        buffer.add(third);
        buffer.add(fourth);// replaces first
        buffer.add(fifth);// replaces second

        // third should now be the oldest
        final String value = (String) buffer.get();
        assertEquals(third, value);
    }

    @Test
    public void get() {
        final RingBuffer buffer = new RingBuffer(3);
        final String first = RandomStringUtils.randomAlphabetic(5);
        final String second = RandomStringUtils.randomAlphabetic(5);
        final String third = RandomStringUtils.randomAlphabetic(5);
        final String fourth = RandomStringUtils.randomAlphabetic(5);
        buffer.add(first);
        buffer.add(second);
        buffer.add(third);

        // multiple calls should return the same oldest element
        assertEquals(first, buffer.get());
        assertEquals(first, buffer.get());
        assertEquals(first, buffer.get());

        // adding over capacity overwrites the first so get should be the second.
        buffer.add(fourth);
        assertEquals(second, buffer.get());
        assertEquals(second, buffer.get());
        assertEquals(second, buffer.get());

    }

    @Test
    public void remove() {
        final RingBuffer buffer = new RingBuffer(3);
        final String first = RandomStringUtils.randomAlphabetic(5);
        final String second = RandomStringUtils.randomAlphabetic(5);
        final String third = RandomStringUtils.randomAlphabetic(5);
        final String fourth = RandomStringUtils.randomAlphabetic(5);
        buffer.add(first);
        buffer.add(second);
        buffer.add(third);

        // each remove returns the oldest element
        assertEquals(first, buffer.remove());
        assertEquals(second, buffer.remove());
        assertEquals(third, buffer.remove());

        buffer.add(fourth);
        assertEquals(fourth, buffer.remove());
        final String removed = (String) buffer.remove();
        assertEquals(null, removed);
    }

    @Test
    public void size() {
        final RingBuffer buffer = new RingBuffer(3);
        final String first = RandomStringUtils.randomAlphabetic(5);
        final String second = RandomStringUtils.randomAlphabetic(5);
        final String third = RandomStringUtils.randomAlphabetic(5);
        final String fourth = RandomStringUtils.randomAlphabetic(5);
        final String fifth = RandomStringUtils.randomAlphabetic(5);
        buffer.add(first);
        assertEquals(1, buffer.size());
        buffer.add(second);
        assertEquals(2, buffer.size());
        buffer.add(third);
        assertEquals(3, buffer.size());
        buffer.add(fourth);
        assertEquals(3, buffer.size());
        buffer.add(fifth);
        assertEquals(3, buffer.size());

        // removal decrements the size
        buffer.remove();
        assertEquals(2, buffer.size());
        buffer.remove();
        assertEquals(1, buffer.size());
        buffer.remove();
        assertEquals(0, buffer.size());
        buffer.remove();
        assertEquals(0, buffer.size());
    }

    @Test
    public void contains() {
        final RingBuffer buffer = new RingBuffer(3);
        final String first = RandomStringUtils.randomAlphabetic(5);
        final String second = RandomStringUtils.randomAlphabetic(5);
        final String third = RandomStringUtils.randomAlphabetic(5);
        final String fourth = RandomStringUtils.randomAlphabetic(5);
        final String fifth = RandomStringUtils.randomAlphabetic(5);

        buffer.add(first);
        assertTrue(buffer.contains(first));
        buffer.add(second);
        assertTrue(buffer.contains(second));
        buffer.add(third);
        assertTrue(buffer.contains(third));

        // adding the fourth element should overwrite the first
        buffer.add(fourth);
        assertTrue(buffer.contains(fourth));
        assertFalse(buffer.contains(first));
        // adding the fifth element should overwrite the second
        buffer.add(fifth);
        assertTrue(buffer.contains(fifth));
        assertFalse(buffer.contains(first));
        assertFalse(buffer.contains(second));
    }

}
