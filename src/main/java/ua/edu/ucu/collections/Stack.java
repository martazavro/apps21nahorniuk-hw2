package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList list;
    public Stack() {
        this.list = new ImmutableLinkedList();
    }
    public void push(Object e) {
        this.list = this.list.addFirst(e);
    }

    public Object pop() {
        Object element = this.peek();
        this.list = this.list.removeFirst();
        return element;
    }

    public Object peek() {
        return this.list.getFirst();
    }
}