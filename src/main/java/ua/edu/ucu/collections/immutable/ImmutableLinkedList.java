package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;
    private int length;

    public ImmutableLinkedList(Object[] elements) {
        Node lastNode = null;
        for (Object current: elements) {
            length++;
            Node curNode = new Node();
            curNode.setValue(current);
            curNode.setPrevious(lastNode);
            if (lastNode != null) {
                lastNode.setNext(curNode);
            }
            else {
                head = curNode;
            }
            lastNode = curNode;
        }

        tail = lastNode;
    }

    public ImmutableLinkedList() {
        head = null;
        tail = null;
    }
    private ImmutableList copy() {
        ImmutableLinkedList res = new ImmutableLinkedList();

        if (head == null) {
            return res;
        }
        Node current = head;
        Node newEl = new Node(current.getValue());

        res.head = newEl;
        res.tail = newEl;
        current = current.getNext();
        while (current != null) {
            newEl = new Node(current.getValue());
            res.tail.setNext(newEl);
            newEl.setPrevious(res.tail);
            res.tail = newEl;
            res.tail.setNext(null);
            current = current.getNext();
        }
        return res;
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(length, new Object[] {e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index > this.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newList = Arrays.copyOf(this.toArray(), this.length);
        Object[] array = new Object[this.length + c.length];
        for (int i = 0; i < array.length; ++i) {
            if (i < index + c.length) {
                array[i] = c[i-index];
            }
            else if (i < index) {
                array[i] = newList[i];
            } else {
                array[i] = newList[i - c.length];
            }
        }
        return new ImmutableLinkedList(Array);
    }

    @Override
    public Object get(int index) {
        if (index >= length || isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        Node curNode = tail;
        int counter = 0;
        while (curNode.getNext() != null) {
            if (counter == index) {
                break;
            }
            curNode = curNode.getNext();
            counter++;
        }
        return curNode.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] array = new Object[length-1];
        Node cur = head;
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (i == index) {
                cur = cur.getNext();
                continue;
            }
            array[j++] = cur.getValue();
            cur = cur.getNext();
        }

        return new ImmutableLinkedList(array);
    }

    @Override
    public ImmutableList set(int index, Object e)
            throws IndexOutOfBoundsException {
        ImmutableLinkedList res = (ImmutableLinkedList) copy();

        int indx = 0;
        Node curr = res.head;
        while (curr != null) {
            if (Objects.equals(index, indx)) {
                curr.setValue(e);
                return res;
            }
            indx++;
            curr = curr.getNext();
        }

        throw new IndexOutOfBoundsException();

    }

    @Override
    public int indexOf(Object e) {
        Node current = head;
        int counter = 0;
        while (current.getNext() != null) {
            if (current.getValue().equals(e)) {
                return counter;
            }
            counter++;
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }
    @Override
    public Object[] toArray() {
        Object[] res = new Object[this.length];
        Node curNode = this.head;
        int counter = 0;
        while (curNode != null) {
            res[counter++] = curNode.getValue();
            curNode = curNode.getNext();
        }
        return res;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) addAll(0, new Object[] {e});
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) addAll(size(), new Object[] {e});
    }
    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public Object getFirst() {
        if (this.head == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.head.getValue();
    }

    public Object getLast() {
        if (this.tail == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.tail.getValue();
    }


    public ImmutableLinkedList removeFirst() {
        if (size() == 0) {
            throw new IllegalArgumentException();
        }
        Object[] newList = Arrays.copyOfRange(toArray(), 1, length);
        return new ImmutableLinkedList(newList);
    }

    public ImmutableLinkedList removeLast() {
        if (size() == 0) {
            throw new IllegalArgumentException();
        }
        Object[] newList = Arrays.copyOf(toArray(), length - 1);
        return new ImmutableLinkedList(newList);
    }
}
