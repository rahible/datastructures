package com.aaronhible.datastructures.set;

public class HashSet<K> {

    private static final Object DUMMY = new Object();
    private final HashTable<K, Object> set;

    public HashSet() {
        set = new HashTable<K, Object>();
    }

    public void add(final K element) {
        set.add(element, DUMMY);
    }

    public boolean contains(final K element) {
        return set.contains(element);
    }

    public boolean remove(final K element) {
        return (set.remove(element) == DUMMY);
    }

    /**
     * @return
     */
    public int size() {
        return set.size();
    }

}
