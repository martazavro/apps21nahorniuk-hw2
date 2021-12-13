package ua.edu.ucu.collections.immutable;


import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {


    private Object[] array;
    private int arrLength = 0;

    public ImmutableArrayList(Object[] array) {

        if (array.length == 0) {
            this.array = new Object[]{};
            this.arrLength = 0;
        }
        else {
            this.array = Arrays.copyOf(array, array.length);
            this.arrLength = array.length;
        }
    }


    public ImmutableArrayList() {
        this.array = new Object[] {};
        this.arrLength = 0;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < this.arrLength; i++) {
            res.append(array[i]);
            res.append(" ");
        }
        return res.toString();
    }

    private Object[] createCopy(int len) {
        Object[] arrCopy;
        if (Objects.equals(len, array.length) || len > array.length) {
            arrCopy = new Object[2*(len + 1)];
        }
        else {
            arrCopy = new Object[len];
        }
        return arrCopy;
    }


    @Override
    public ImmutableList add(Object e) {
        return this.addAll(this.arrLength, new Object[] {e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(this.arrLength, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c)
            throws IndexOutOfBoundsException {
        if (index > arrLength  || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] arrCopy = createCopy(arrLength + c.length);
        for (int i = 0; i < index; i++) {
            arrCopy[i] = array[i];
        }
        for (int i = index; i < index + c.length; i++) {
            arrCopy[i] = c[i - index];
        }
        for (int i = index + c.length; i < arrLength + c.length; i++) {
            arrCopy[i] = array[i - c.length];
        }
        ImmutableArrayList res = new ImmutableArrayList(arrCopy);
        res.arrLength = arrLength + c.length;
        return  res;
    }


    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > arrLength) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }


    @Override
    public ImmutableArrayList remove(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newArr = new Object[array.length-1];
        System.arraycopy(array, 0, newArr, 0, index);
        if (index != array.length-1) {
            System.arraycopy(array, index+1, newArr, index,
                    array.length-index-1);
        }
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newElems = array.clone();
        newElems[index] = e;
        return new ImmutableArrayList(newElems);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.arrLength; i++) {
            if (array[i] == e) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public Object[] toArray() {
        return array.clone();
    }
}
