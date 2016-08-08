package com.aaronhible.datastructures.set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class HashSetTest {
    @Test
    public void add() {
        final HashSet<String> hashSet = new HashSet<>();
        final String one = RandomStringUtils.random(5);
        final String two = RandomStringUtils.random(5);
        final String three = RandomStringUtils.random(5);

        hashSet.add(one);

        assertTrue(hashSet.contains(one));
        assertFalse(hashSet.contains(two));

        hashSet.add(two);

        assertTrue(hashSet.contains(one));
        assertTrue(hashSet.contains(two));
        assertFalse(hashSet.contains(three));

    }

    @Test
    public void remove() {
        final HashSet<String> hashSet = new HashSet<>();
        final String one = RandomStringUtils.random(5);
        final String two = RandomStringUtils.random(5);
        final String three = RandomStringUtils.random(5);

        hashSet.add(one);
        hashSet.add(two);
        hashSet.add(three);

        assertTrue(hashSet.contains(one));
        assertTrue(hashSet.contains(two));

        assertTrue(hashSet.remove(two));
        assertFalse(hashSet.remove(two));
        assertFalse(hashSet.contains(two));
    }

    @Test
    public void size() {

        final HashSet<String> hashSet = new HashSet<>();
        final String one = RandomStringUtils.random(5);
        final String two = RandomStringUtils.random(5);
        final String three = RandomStringUtils.random(5);
        hashSet.add(one);
        hashSet.add(two);
        hashSet.add(three);

        assertEquals(3, hashSet.size());

        // adding the same one doesn't increase the size.
        hashSet.add(three);

        assertEquals(3, hashSet.size());

        final String four = RandomStringUtils.random(5);
        hashSet.add(four);

        assertEquals(4, hashSet.size());

        hashSet.remove(two);

        assertEquals(3, hashSet.size());

        hashSet.remove(four);

        assertEquals(2, hashSet.size());

    }
}
