package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import java.util.EmptyStackException;

public class Queue {
    private ImmutableLinkedList list = new ImmutableLinkedList();

    public Object peek() throws EmptyStackException {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.getFirst();
    }

    public Object dequeue() {
        Object element = this.peek();
        this.list = this.list.removeFirst();
        return element;
    }

    public void enqueue(Object e) {
        this.list = this.list.addLast(e);
    }

}
