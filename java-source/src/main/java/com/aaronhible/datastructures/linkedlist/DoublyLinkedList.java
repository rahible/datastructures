package com.aaronhible.datastructures.linkedlist;

public class DoublyLinkedList<T> extends AbstractLinkedList<T> {

    /**
     * @param previous
     * @param element
     */
    @Override
    protected void setLink(final Element<T> previous, final Element<T> element) {
        previous.setNext(element);
        element.setPrevious(previous);
    }

    /**
     * @param value
     * @return
     */
    public T previous(final T value) {
        return previous(head, value);
    }

    /**
     * @param element
     * @param previous
     * @param value
     */
    private T previous(final Element<T> element, final T value) {
        // end of list and value wasn't found
        if (element == null) {
            return null;
        }

        if (equals(element, value)) {
            return (element.getPrevious() == null) ? null : element.getPrevious().getValue();
        }

        return previous(element.getNext(), value);
    }
}
