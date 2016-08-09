package com.aaronhible.datastructures.heap;

public class BinaryHeap {

    private static final int DEFAULT_HEAP_SIZE = 100;

    private final String[] heap = new String[DEFAULT_HEAP_SIZE];

    private int size;

    public BinaryHeap() {

    }

    public void insert(final String value) {
        // start from the end of the array
        final int position = ++size;
        heap[position] = value;
        // start moving things around
        percolateUp(position);
    }

    /**
     * @param index
     */
    private void percolateUp(final int index) {
        int child = index;
        final int parent = child / 2;
        // while we aren't in the first position and our parent is less than us.
        while (child > 1 && less(parent, child)) {
            swap(child, parent);
            child = parent / 2;
        }
    }

    /**
     * Swaps the child and parent elements.
     *
     * @param child
     * @param parent
     */
    private void swap(final int child, final int parent) {
        final String swap = heap[child];
        heap[child] = heap[parent];
        heap[parent] = swap;
    }

    /**
     * Compares if the parent is less than the child
     *
     * @param parent
     * @param child
     * @return
     */
    private boolean less(final int parent, final int child) {
        return heap[parent].compareTo(heap[child]) < 0;
    }

    public int size() {
        return size;
    }

    private int getParentIndex(final int k) {
        return (k - 1) / 2;
    }

    private int getLeftChildIndex(final int k) {
        return 2 * k;
    }

    private int getRightChildIndex(final int k) {
        return 2 * k + 1;
    }

    public String deleteMin() {
        return null;
    }
}
