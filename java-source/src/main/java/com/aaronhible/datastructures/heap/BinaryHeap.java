package com.aaronhible.datastructures.heap;

/**
 * min-heap property implementation of a Binary Heap - where the value of each node is greater than or equal to the
 * value of its parent, with the minimum-value element at the root.
 */
public class BinaryHeap {

    private static final int DEFAULT_HEAP_SIZE = 100;

    private final Integer[] heap = new Integer[DEFAULT_HEAP_SIZE];

    private int size;

    public BinaryHeap() {

    }

    public void insert(final Integer value) {
        // start from the first empty spot at the end of the array.
        int position = ++size;
        // heap[position] = value; //don't set the value yet

        // keep moving until we hit the root or our value is greater than the parent
        while (position > 1 && value.compareTo(heap[position / 2]) < 0) {
            heap[position] = heap[position / 2]; // move the empty position to the parent because we haven't found the
            // spot yet.
            position = position / 2; // move to the next parent
        }

        heap[position] = value;// position should be empty now

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

    public Integer deleteMin() {
        final int rootIndex = 1;
        // first element (min) is index 1
        final Integer rootItem = heap[rootIndex];
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
        final Integer tmp = heap[hole];
        int child;
        // while we aren't at the end of the tree (child index is less than size)
        while ((leftChildIndex(hole)) < size) {
            child = leftChildIndex(hole);
            // if the right is less then the left then use the right
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
