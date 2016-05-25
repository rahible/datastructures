package com.aaronhible.interview.linkedlist;

public class SinglyLinkedList {

    Element head;
    int size = 0;

    public void add(final Integer object) {
        add(head, null, object);
    }

    /**
     * @param element
     * @param object
     */
    private void add(Element element, final Element previous, final Integer object) {
        if (element == null) {
            element = new Element(object, null);
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
    public boolean contains(final Integer object) {
        return contains(head, object);
    }

    /**
     * @param element
     * @param object
     * @return
     */
    private boolean contains(final Element element, final Integer object) {
        if (element == null) {
            return false;
        }
        if (object == element.getValue() || object.equals(element.getValue())) {
            return true;
        }
        return contains(element.getNext(), object);
    }

    /**
     * @param Integer
     * @return
     */
    public Integer next(final Integer object) {
        return next(head, object);
    }

    /**
     * @param element
     * @param object
     * @return
     */
    private Integer next(final Element element, final Integer object) {
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
     * @param Integer
     */
    public Integer remove(final Integer object) {
        return remove(head, null, object);
    }

    /**
     * @param element
     * @param previous
     * @param value
     * @return
     */
    private Integer remove(final Element element, final Element previous, final Integer value) {
        // element has not been found
        if (element == null) {
            return null;
        }

        // found it lets remove it by unlinking it
        if (value == element.getValue() || value.equals(element.getValue())) {
            final Element next = element.getNext();
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
