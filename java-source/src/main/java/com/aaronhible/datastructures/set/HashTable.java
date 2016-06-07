package com.aaronhible.datastructures.set;

public class HashTable {

    private int bucketCapacity = 100;
    private int size;
    private final Entry[] buckets;

    public HashTable() {
        buckets = new Entry[bucketCapacity];
    }

    public HashTable(final int capacity) {
        bucketCapacity = capacity;
        buckets = new Entry[bucketCapacity];
    }

    public void add(Entry entry, final int hash, final Object key, final Object value) {
        if (entry == null) {
            entry = buildNewEntry(hash, key, value);
            return;
        }
        if (entry.getKey() == key || entry.getKey().equals(key)) {
            entry.value = value;
            return;
        }
        add(entry.next, hash, key, value);
    }

    public void add(final Object key, final Object value) {
        // hash the key
        final int hash = this.hash(key, bucketCapacity);
        // get the index
        final int index = this.index(hash, bucketCapacity);
        // get the object out of the bucket
        final Entry entry = buckets[index];
        // if null add it
        if (entry == null) {
            buckets[index] = buildNewEntry(hash, key, value);
            return;
        }
        add(entry, hash, key, value);
    }

    boolean isValuesEqual(final Object lhs, final Object rhs) {
        // if the references are equal (including null), or the object equals are equal
        if ((lhs == rhs) || ((lhs != null) && lhs.equals(rhs))) {
            return true;
        }
        return false;
    }

    /**
     * @param hash
     * @param key
     * @param value
     * @return
     */
    private Entry buildNewEntry(final int hash, final Object key, final Object value) {
        final Entry entry = new Entry(hash, key, value);
        size++;
        return entry;
    }

    public int size() {
        return size;
    }

    public void remove(final Object key) {

    }

    public boolean contains(final Object key) {
        final int hash = this.hash(key, bucketCapacity);
        final int index = this.index(hash, bucketCapacity);
        final Entry entry = getEntry(index, key);
        return (entry != null);

    }

    public Object get(final Object key) {
        final int hash = this.hash(key, bucketCapacity);
        final int index = this.index(hash, bucketCapacity);
        final Entry entry = getEntry(index, key);
        return (entry == null) ? null : entry.getValue();
    }

    /**
     * @param index
     * @return
     */
    private Entry getEntry(final int index, final Object key) {
        return getEntry(this.buckets[index], key);
    }

    /**
     * @param entry
     * @param key
     * @return
     */
    private Entry getEntry(final Entry entry, final Object key) {
        if (entry == null) {
            return null;
        }

        if (entry.getKey().equals(key) || entry.getKey() == key) {
            return entry;
        }

        return getEntry(entry.next, key);

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
