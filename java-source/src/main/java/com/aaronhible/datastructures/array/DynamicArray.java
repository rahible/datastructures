package com.aaronhible.datastructures.array;

public class DynamicArray {

    private Object[] array;

    private int size;

    public DynamicArray(final int capacity) {
        array = new Object[capacity];
    }

    public void add(final Object value) {
        resize();
        array[size] = value;
        size++;
    }

    /**
     *
     */
    protected void resize() {
        if (isResizeNeeded()) {
            final Object[] newArray = resizeAndCopy();
            this.array = newArray;
        }
    }

    /**
     * @return
     */
    protected boolean isResizeNeeded() {
        return size >= array.length;
    }

    /**
     * @param newArray
     */
    protected Object[] resizeAndCopy() {
        final Object[] newArray = new Object[array.length * 2];
        for (int index = 0; index < array.length; index++) {
            newArray[index] = array[index];
        }
        return newArray;
    }

    public int size() {
        return size;
    }

    /**
     * @param i
     * @return
     */
    public Object remove(final int index) {
        checkSize(index);
        final Object removal = array[index];
        if (removal != null) {
            int copyIndex = index;
            for (; copyIndex < array.length; copyIndex++) {
                // shift the values left
                final int nextIndex = copyIndex + 1;
                if (nextIndex < size) {
                    array[copyIndex] = array[nextIndex];
                }
            }
            // ensure that the last one is null so that the last element isn't repeated
            // and decrement the size
            array[--size] = null;
        }
        return removal;
    }

    /**
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
    protected void checkSize(final int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("index " + index + " is outside of " + (size - 1));
        }
    }

}
