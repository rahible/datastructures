package com.aaronhible.datastructures.linkedlist;

public abstract class AbstractLinkedList<T> {

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
            element = add(previous, object);
            return;
        }
        add(element.getNext(), element, object);
    }

    /**
     * @param previous
     * @param object
     * @return
     */
    private Element<T> add(final Element<T> previous, final T object) {
        Element<T> element;
        element = new Element<T>(object);
        if (head == null) {
            head = element;
        }
        if (previous != null) {
            setLink(previous, element);
        }
        size++;
        return element;
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
        if (equals(element, object)) {
            return true;
        }
        return contains(element.getNext(), object);
    }

    /**
     * @param element
     * @param object
     * @return
     */
    boolean equals(final Element<T> element, final T object) {
        return object == element.getValue() || object.equals(element.getValue());
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
        if (equals(element, object)) {
            return nextValue(element);
        }
        return next(element.getNext(), object);
    }

    /**
     * @param element
     * @return
     */
    private T nextValue(final Element<T> element) {
        // no next value
        if (element.getNext() == null) {
            return null;
        }
        return element.getNext().getValue();
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
        if (equals(element, value)) {
            return remove(element, previous);
        }

        return remove(element.getNext(), element, value);
    }

    /**
     * @param element
     * @param previous
     * @return
     */
    private T remove(final Element<T> element, final Element<T> previous) {
        final Element<T> next = element.getNext();
        // no previous? because we are removing the head.
        if (previous == null) {
            head = null;
        } else {
            setLink(previous, next);
        }
        size--;
        return element.getValue();
    }

    protected abstract void setLink(final Element<T> previous, Element<T> element);
}
