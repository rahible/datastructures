package com.aaronhible.interview.linkedlist;

public class SinglyLinkedList {

    Element[] elements = new Element[10];
    // we can't use elements.length because it'll be 10
    int size = 0;

    /**
     * @param integer
     */
    public void add(final Integer integer) {
        if (size == elements.length) {
            throw new IndexOutOfBoundsException("list is full");
        }

        Element previous = null;
        for (int index = 0; index < elements.length; index++) {
            if (elements[index] == null) {
                elements[index] = new Element(integer, previous);
                break;
            }
            previous = elements[index];
        }
        size++;
    }

    /**
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * @param integer
     * @return
     */
    public boolean contains(final Integer integer) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @param one
     * @return
     */
    public Integer next(final Integer one) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param one
     */
    public Integer remove(final Integer one) {
        return null;

    }

}
