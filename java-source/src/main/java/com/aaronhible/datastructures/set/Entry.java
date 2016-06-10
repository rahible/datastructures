package com.aaronhible.datastructures.set;

class Entry<K, V> {
    int hash;
    K key;
    V value;
    Entry<K, V> next;

    public Entry(final int hash, final K key, final V value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
    }

    /**
     * @return the hash
     */
    public int getHash() {
        return hash;
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
