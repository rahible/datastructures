package com.aaronhible.datastructures.list;

public class DynamicArray<T> {

    private T[] array;

    private int size;

    @SuppressWarnings("unchecked")
    public DynamicArray(final int capacity) {
        array = (T[]) new Object[capacity];
    }

    /**
     * Adding to the array is O(1) because we know the size and know where to put the element at the end without
     * traversing the array. With one exception, expansion of the array which is O(n). Since expansion does not happen
     * at every insertion, and the array expands exponentially (x2 on each expansion), then the cost can be amortized
     * leaving the original O(1).
     *
     * @param value
     */
    public void add(final T value) {
        expansion();
        array[size++] = value;
    }

    /**
     * Adding an element to the middle of the array is an O(n) operation because every time we add other than the end,
     * the elements in the array must be shifted right.
     *
     * @param index
     * @param value
     */
    public void add(final int index, final T value) {
        expansion();
        copyRight(index);
        array[index] = value;
        size++;
    }

    /**
     * @param index
     */
    private void copyRight(final int index) {
        // start with the size which will be pointing to the index one
        // past the end of the array.
        int newIndex = size;
        while (newIndex > index) {
            this.array[newIndex] = this.array[--newIndex];
        }
    }

    /**
     *
     */
    private void expansion() {
        if (isExpansionNeeded()) {
            final T[] newArray = resizeAndCopy();
            this.array = newArray;
        }
    }

    /**
     * @return
     */
    private boolean isExpansionNeeded() {
        // not sure how size can ever be greater than array.length???
        return size >= array.length;
    }

    /**
     * @param newArray
     */
    private T[] resizeAndCopy() {
        @SuppressWarnings("unchecked")
        final T[] newArray = (T[]) new Object[array.length * 2];
        for (int index = 0; index < array.length; index++) {
            newArray[index] = array[index];
        }
        return newArray;
    }

    public int size() {
        return size;
    }

    /**
     * The complexity of removal is O(n) because when we remove the element, the other elements must be moved left to
     * fill in the empty space. The definition of an array include contiguous elements, so no empty spots are allowed.
     *
     * @param i
     * @return
     */
    public T remove(final int index) {
        checkSize(index);
        final T removal = array[index];
        if (removal != null) {
            contraction(index);
            // ensure that the last one is null so that the last element isn't repeated
            // and decrement the size
            array[--size] = null;
        }
        return removal;
    }

    /**
     * @param index
     */
    private void contraction(final int index) {
        int copyIndex = index;
        for (; copyIndex < array.length; copyIndex++) {
            copyLeft(copyIndex);
        }
    }

    /**
     * @param copyIndex
     */
    protected void copyLeft(final int copyIndex) {
        // shift the values left
        final int nextIndex = copyIndex + 1;
        if (nextIndex < size) {
            array[copyIndex] = array[nextIndex];
        }
    }

    /**
     * Getting an element based on the index is 0(n), since the array does not have to be traversed.
     *
     * @param i
     * @return
     */
    public Object get(final int index) {
        checkSize(index);
        return array[index];
    }

    /**
     * @param index
     */
    private void checkSize(final int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("index " + index + " is outside of " + (size - 1));
        }
    }

}
