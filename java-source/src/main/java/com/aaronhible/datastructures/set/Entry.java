package com.aaronhible.datastructures.set;

class Entry<K, V> {
    K key;
    V value;
    Entry<K, V> next;

    public Entry(final K key, final V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * @return the key
     */
    public K getKey() {
        return key;
    }

    /**
     * @return the value
     */
    public V getValue() {
        return value;
    }

}
