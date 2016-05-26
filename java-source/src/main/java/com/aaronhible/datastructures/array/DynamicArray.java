package com.aaronhible.datastructures.array;

public class DynamicArray {

    private final Object[] array;

    private int size;

    public DynamicArray(final int capacity) {
        array = new Object[capacity];
    }

    // https://www.youtube.com/watch?v=XGJeXLlhfdA#t=2.249206

    public void add(final Object value) {
        if (size < array.length) {
            array[size] = value;
            size++;
        } else {
            resizeAdd(value);
        }
    }

    /**
     * @param value
     */
    private void resizeAdd(final Object value) {
        // TODO Auto-generated method stub

    }

    public int size() {
        return size;
    }

    /**
     * @param i
     * @return
     */
    public Object remove(final int index) {
        return 0;
    }

    /**
     * @param i
     * @return
     */
    public Integer get(final int idex) {
        // TODO Auto-generated method stub
        return null;
    }

}
