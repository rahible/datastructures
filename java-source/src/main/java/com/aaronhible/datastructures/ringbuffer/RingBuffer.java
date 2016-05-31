package com.aaronhible.datastructures.ringbuffer;

public class RingBuffer {
    // index of the oldest (first) item
    private final int start = 0;
    // index newest (last) item in the buffer??
    private final int end = 0;

    private final Object[] buffer;

    public RingBuffer(final int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0.");
        }

        buffer = new Object[size];

    }

    /**
     * Adds the element to the buffer. If the buffer is full, it replaces the oldest element.
     *
     * @param
     */
    public void add(final Object element) {
        // can't add null
    }

    /**
     * Returns the oldest element in the buffer. But does not remove it. Successive calls will return the same object.
     *
     * @return
     */
    public Object get() {
        return null;
    }

    /**
     * Returns the oldest element in the buffer, removing it. Successive calls will return the oldest element in the
     * buffer until the buffer is depleted.
     *
     * @return
     */
    public Object remove() {
        return null;
    }

    /**
     * Returns the number of elements populated in the buffer or the capacity if the buffer is full.
     *
     * @return
     */
    public int size() {
        return 0;
    }

    /**
     * Returns true if the buffer contains the element.
     *
     * @param element
     * @return
     */
    public boolean contains(final Object element) {
        return false;
    }
}
