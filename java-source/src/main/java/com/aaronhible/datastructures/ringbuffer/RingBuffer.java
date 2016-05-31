package com.aaronhible.datastructures.ringbuffer;

public class RingBuffer {
    // index of the read (first) item
    private int read = 0;
    // index newest (last) item in the buffer??
    private int write = 0;
    // tells if we are full
    private boolean full;

    private final Object[] buffer;

    public RingBuffer(final int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0.");
        }

        buffer = new Object[capacity];

    }

    /**
     * Adds the element to the buffer. If the buffer is full, it replaces the read element.
     *
     * @param
     */
    public void add(final Object element) {
        if (full) {
            remove();
        }

        buffer[write++] = element;
        circulateEnd();
        if (read == write) {
            full = true;
        }
    }

    /**
     *
     */
    private void circulateEnd() {
        // if we are at the write of the array roll over, write should never
        // point OutOfBounds
        if (write == buffer.length) {
            write = 0;
        }

    }

    // /**
    // *
    // */
    // private void circulateOldest() {
    // if (read == write) {
    // full = true;
    // // check the bounds and read over if we need to;
    // // read and write should never point OutOfBounds
    // if (read == buffer.length) {
    // read = 0;
    // }
    // }
    // }
    //
    /**
     * Returns the read element in the buffer. But does not remove it. Successive calls will return the same object.
     *
     * @return
     */
    public Object get() {
        return buffer[read];
    }

    /**
     * Returns the read element in the buffer, removing it. Successive calls will return the read element in the buffer
     * until the buffer is depleted.
     *
     * @return
     */
    public Object remove() {

        final Object element = buffer[read];

        // this guards against calling read on an empty buffer
        // we return null because nothing was there, but we don't
        // do any calculations that would cause us to falsify our size
        if (element != null) {
            // clear it out
            buffer[read++] = null;

            // if we cross the boundary start back at zero
            if (read == buffer.length) {
                read = 0;
            }

            full = false;
        }

        return element;
    }

    /**
     * Returns the number of elements populated in the buffer or the capacity if the buffer is full.
     *
     * @return
     */
    public int size() {
        // if the read index is greater than the write index we have crossed the boundary and circled back around
        // then calculate beginning of the array to the write ((write - 1) - 0) remember write points to an empty spot
        // , and read to the end of the array ((buffer.length-1) - read).
        if (write < read) {
            return (write) + ((buffer.length) - read);
        }

        // we are either empty or full, this is why we need a full indicator
        if (write == read) {
            return (full) ? buffer.length : 0;
        }

        // we are in the array and just need to do simple subtraction
        if (write > read) {
            return write - read;
        }

        return 0;
    }

    /**
     * Returns true if the buffer contains the element.
     *
     * @param element
     * @return
     */
    public boolean contains(final Object element) {

        // if size is zero we return false (fail fast)
        if (size() == 0) {
            return false;
        }

        // 3 conditions:
        // 1) write > read which isn't full but doesn't cross boundary
        // 2) write == read which is full, so traverse from 0 to length
        // 3) write < read boundary so search 2 arrays
        if (write > read) {
            int start = read;
            final int end = (write == read) ? buffer.length : write;
            for (; start < end; start++) {
                final Object test = buffer[start];
                // null guard, test "shouldn't" be null
                if (test != null && (element == test || element.equals(test))) {
                    return true;
                }
            }
        } else if (full) {
            for (final Object test : buffer) {
                // null guard, test "shouldn't" be null
                if (test != null && (element == test || element.equals(test))) {
                    return true;
                }
            }
        } else {
            for (int index = 0; index < write; index++) {
                final Object test = buffer[index];
                // null guard, test "shouldn't" be null
                if (test != null && (element == test || element.equals(test))) {
                    return true;
                }
            }
            // not found in the first half trying the second
            for (int index = read; index < buffer.length; index++) {
                final Object test = buffer[index];
                // null guard, test "shouldn't" be null
                if (test != null && (element == test || element.equals(test))) {
                    return true;
                }
            }
        }

        return false;
    }
}
