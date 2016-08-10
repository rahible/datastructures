package com.aaronhible.datastructures.heap;

/**
 * min-heap property implementation of a Binary Heap - where the value of each node is greater than or equal to the
 * value of its parent, with the minimum-value element at the root.
 */
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

    private static int leftChildIndex(final int k) {
        return 2 * k;
    }

    private static int rightChildIndex(final int k) {
        return 2 * k + 1;
    }

    public String deleteMin() {
        final int rootIndex = 1;
        // first element (min) is index 1
        final String rootItem = heap[rootIndex];
        // replace the root with the last time
        heap[rootIndex] = heap[size--];
        // find where in the tree that last item belongs.
        percolateDown(rootIndex);
        // return the former root
        return rootItem;
    }

    /**
     * @param rootIndex
     */
    private void percolateDown(final int index) {
        int hole = index;
        final String tmp = heap[hole];
        int child;
        // while we aren't at the end of the tree (child index is less than size)
        while ((leftChildIndex(hole)) < size) {
            child = leftChildIndex(hole);
            // if the sybling is less then the child then use the sybling
            if ((child != size) && (heap[rightChildIndex(hole)].compareTo(heap[leftChildIndex(hole)]) < 0)) {
                // move to the right child since it's smaller
                child++;
            }
            // best child has been chosen let us see how it compares to the new parent
            if (heap[child].compareTo(tmp) < 0) {
                heap[hole] = heap[child];
            } else {
                break;
            }
            // the child has now created a hole
            hole = child;
        }
        // fill in the hole with our tmp guy.
        heap[hole] = tmp;
    }
}
