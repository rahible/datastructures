package com.aaronhible.interview.linkedlist;

public class Element<T> {

    private final T value;
    private Element<T> next;

    public Element(final T value, final Element<T> next) {
        this.value = value;
        this.next = next;
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
}
