package com.aaronhible.interview.linkedlist;

public class Element {

    private final Integer value;
    private Element next;

    public Element(final Integer value, final Element next) {
        this.value = value;
        this.next = next;
    }

    /**
     * @return
     */
    public Integer getValue() {
        return value;
    }

    /**
     * @return
     */
    public Element getNext() {
        return next;
    }

    /**
     * @param element
     */
    public void setNext(final Element element) {
        this.next = element;
    }
}
