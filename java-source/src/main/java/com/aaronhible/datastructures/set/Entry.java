package com.aaronhible.datastructures.set;

class Entry {
    int hash;
    Object key;
    Object value;
    Entry next;

    public Entry(final int hash, final Object key, final Object value) {
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
    public Object getKey() {
        return key;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

}
