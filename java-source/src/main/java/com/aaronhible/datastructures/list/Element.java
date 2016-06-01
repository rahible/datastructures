package com.aaronhible.datastructures.list;

public class Element<T> {

    private final T value;
    private Element<T> next;
    private Element<T> previous;

    public Element(final T value) {
        this.value = value;
    }

    /**
     * @return
     */
    public T getValue() {
        return value;
    }

    /**
     * @return
     */
    public Element<T> getNext() {
        return next;
    }

    /**
     * @param element
     */
    public void setNext(final Element<T> element) {
        this.next = element;
    }

    /**
     * @return the previous
     */
    public Element<T> getPrevious() {
        return previous;
    }

    /**
     * @param previous the previous to set
     */
    public void setPrevious(final Element<T> previous) {
        this.previous = previous;
    }
}
