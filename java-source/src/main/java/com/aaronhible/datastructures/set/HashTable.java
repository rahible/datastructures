package com.aaronhible.datastructures.set;

public class HashTable<K, V> {

    private int bucketCapacity = 100;
    private int size;
    private final Entry<K, V>[] buckets;

    @SuppressWarnings("unchecked")
    public HashTable() {
        buckets = new Entry[bucketCapacity];
    }

    @SuppressWarnings("unchecked")
    public HashTable(final int capacity) {
        bucketCapacity = capacity;
        buckets = new Entry[bucketCapacity];
    }

    /**
     * Looking at the createEntry of Java's HashMap implementation, I thought that the adding would be less complex if I
     * implemented the same solution. However, tracing the usages up to put, shows that Java's put on HashMap iterates
     * to find a matching key first and replaces the value. If there is no match it then adds the head. Since I chose
     * recursion for this method I was able to add first if the bucket is empty and then recursively find the value. The
     * difference is that this implementation will add to the tail of a chain if that chain is found. Java's
     * implementation will always replace the head of the chain.
     *
     * @param key
     * @param value
     */
    public void add(final K key, final V value) {
        // hash the key
        final int hash = this.hash(key, bucketCapacity);
        // get the index
        final int index = this.index(hash, bucketCapacity);
        // get the object out of the bucket
        final Entry<K, V> entry = buckets[index];
        // if null add it
        if (entry == null) {
            buckets[index] = buildNewEntry(key, value);
            return;
        }
        add(null, entry, key, value);
    }

    private void add(final Entry<K, V> previous, Entry<K, V> entry, final K key, final V value) {
        if (entry == null) {
            entry = buildNewEntry(key, value);
            if (previous != null) {
                previous.next = entry;
            }
            return;
        }
        if (isValuesEqual(entry.getKey(), key)) {
            entry.value = value;
            return;
        }
        add(entry, entry.next, key, value);
    }

    boolean isValuesEqual(final K lhs, final K rhs) {
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
    private Entry<K, V> buildNewEntry(final K key, final V value) {
        final Entry<K, V> entry = new Entry<>(key, value);
        size++;
        return entry;
    }

    public int size() {
        return size;
    }

    public Object remove(final K key) {
        final int hash = this.hash(key, bucketCapacity);
        final int index = this.index(hash, bucketCapacity);
        return removeEntry(index, key);
    }

    /**
     * @param index
     * @param key
     */
    private Object removeEntry(final int index, final K key) {
        final Entry<K, V> entry = buckets[index];
        // there is no entry fast return
        if (entry == null) {
            return null;
        }

        // the entry matches, but there is no chaining empty the bucket and return the value
        if (isValuesEqual(entry.getKey(), key)) {
            // next goes into the bucket
            buckets[index] = entry.next;
            size--;
            return entry.getValue();
        }

        // go through the chain and remove / splice the chain if key is found
        return removeEntry(entry.next, entry, key);
    }

    private Object removeEntry(final Entry<K, V> current, final Entry<K, V> previous, final K key) {
        // not found
        if (current == null) {
            return null; // break here
        }
        if (isValuesEqual(current.getKey(), key)) {
            // point the previous one to the next->next one.
            previous.next = current.next;
            // remove reference for GC
            current.next = null;
            size--;
            return current.getValue();
        }
        return removeEntry(current.next, current, key);
    }

    public boolean contains(final K key) {
        final int hash = this.hash(key, bucketCapacity);
        final int index = this.index(hash, bucketCapacity);
        final Entry<K, V> entry = getEntry(index, key);
        return (entry != null);

    }

    public V get(final K key) {
        final int hash = this.hash(key, bucketCapacity);
        final int index = this.index(hash, bucketCapacity);
        final Entry<K, V> entry = getEntry(index, key);
        return (entry == null) ? null : entry.getValue();
    }

    /**
     * @param index
     * @return
     */
    private Entry<K, V> getEntry(final int index, final K key) {
        return getEntry(this.buckets[index], key);
    }

    /**
     * @param entry
     * @param key
     * @return
     */
    private Entry<K, V> getEntry(final Entry<K, V> entry, final K key) {
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
    int hash(final K key, final int capacity) {
        return key.hashCode() % capacity;
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
