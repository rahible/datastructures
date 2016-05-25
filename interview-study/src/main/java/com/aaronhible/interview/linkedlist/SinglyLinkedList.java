package com.aaronhible.interview.linkedlist;

public class SinglyLinkedList<T> {

    Element<T> head;
    int size = 0;

    public void add(final T object) {
        add(head, null, object);
    }

    /**
     * @param element
     * @param object
     */
    private void add(Element<T> element, final Element<T> previous, final T object) {
        if (element == null) {
            element = new Element<T>(object, null);
            if (head == null) {
                head = element;
            }
            if (previous != null) {
                previous.setNext(element);
            }
            size++;
            return;
        }
        add(element.getNext(), element, object);
    }

    /**
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * @param Integer
     * @return
     */
    public boolean contains(final T object) {
        return contains(head, object);
    }

    /**
     * @param element
     * @param object
     * @return
     */
    private boolean contains(final Element<T> element, final T object) {
        if (element == null) {
            return false;
        }
        if (object == element.getValue() || object.equals(element.getValue())) {
            return true;
        }
        return contains(element.getNext(), object);
    }

    /**
     * @param value
     * @return
     */
    public T next(final T object) {
        return next(head, object);
    }

    /**
     * @param element
     * @param object
     * @return
     */
    private T next(final Element<T> element, final T object) {
        // end of list and not found
        if (element == null) {
            return null;
        }
        if (object == element.getValue() || object.equals(element.getValue())) {
            // no next value
            if (element.getNext() == null) {
                return null;
            }
            return element.getNext().getValue();
        }
        return next(element.getNext(), object);
    }

    /**
     * @param value
     */
    public T remove(final T object) {
        return remove(head, null, object);
    }

    /**
     * @param element
     * @param previous
     * @param value
     * @return
     */
    private T remove(final Element<T> element, final Element<T> previous, final T value) {
        // element has not been found
        if (element == null) {
            return null;
        }

        // found it lets remove it by unlinking it
        if (value == element.getValue() || value.equals(element.getValue())) {
            final Element<T> next = element.getNext();
            // no previous? because we are removing the head.
            if (previous == null) {
                head = null;
            } else {
                previous.setNext(next);
            }
            size--;
            return element.getValue();
        }

        return remove(element.getNext(), element, value);
    }

}
