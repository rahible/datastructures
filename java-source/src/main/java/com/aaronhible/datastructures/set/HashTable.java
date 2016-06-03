package com.aaronhible.datastructures.set;

public class HashTable {

    private final int bucketCapacity = 100;

    public void add(final Object key, final Object value) {
        // hash the object

        // look up the hash in the
    }

    public int size() {
        return 0;
    }

    public void remove(final Object key) {

    }

    public boolean contains(final Object key) {
        return false;
    }

    /**
     * Simple mod hash, simple but not so effective as it will produce a lot of collisions for non-integer data types.
     * My non-scientific test (see test case) shows that out of 10000 buckets and 10000 random strings, only about 260
     * buckets will be used. Perfect Hash only works when you know the keys ahead of time.
     */
    int hash(final Object object, final int capacity) {
        return object.hashCode() % capacity;
    }

    /**
     * I had originally included the hash and index as one method. However, after looking at the Java implemenation I
     * noticed that they separated the methods. As well, they use the internally generated hash as a cached item on the
     * entry. I can see that there is at least one advantage to doing it this way. It avoids requiring the call to the
     * object's hash to compute its value every time. This will be expensive for large keys of strings.
     */
    int index(final int hash, final int capacity) {
        return hash & (capacity - 1);
    }
}
