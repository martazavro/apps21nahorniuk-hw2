package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    ImmutableLinkedList immutableLinkedList;

    @Before
    public void setUp() {
        immutableLinkedList = new ImmutableLinkedList(new Integer[] {Integer.valueOf(3), Integer.valueOf(5)});
    }

    @Test
    public void testGet() {
        assertEquals(Integer.valueOf(5), immutableLinkedList.get(1));
    }

    @Test
    public void testRemove() {
        immutableLinkedList = (ImmutableLinkedList) immutableLinkedList.remove(0);
        assertArrayEquals(new Integer[] {Integer.valueOf(5)}, immutableLinkedList.toArray());
    }


    @Test
    public void testSize() {
        immutableLinkedList = new ImmutableLinkedList(new Integer[] {Integer.valueOf(3), Integer.valueOf(5)});
        assertEquals(2, immutableLinkedList.size());
    }

    @Test
    public void testClear() {
        immutableLinkedList = (ImmutableLinkedList) immutableLinkedList.clear();
        assertArrayEquals(new Integer[]{}, immutableLinkedList.toArray());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(immutableLinkedList.clear().isEmpty());
    }

    @Test
    public void testToArray() {
        assertArrayEquals(new Integer[] {Integer.valueOf(3), Integer.valueOf(5)}, immutableLinkedList.toArray());
    }

    @Test
    public void testAddFirst() {
        assertArrayEquals(new Integer[] {Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(5)}, immutableLinkedList.addFirst(Integer.valueOf(2)).toArray());

    }


    @Test
    public void testGetHead() {
        assertEquals(3, immutableLinkedList.getHead().getValue());
    }

    @Test
    public void testGetTail() {
        assertEquals(5, immutableLinkedList.getTail().getValue());
    }

    @Test
    public void testGetFirst() {
        assertEquals(3, immutableLinkedList.getFirst());
    }

    @Test
    public void testGetLast() {
        assertEquals(5, immutableLinkedList.getLast());
    }

    @Test
    public void testRemoveFirst() {
        assertArrayEquals(new Integer[] {Integer.valueOf(5)}, immutableLinkedList.removeFirst().toArray());
    }

    @Test
    public void testRemoveLast() {
        assertArrayEquals(new Integer[] {Integer.valueOf(3)}, immutableLinkedList.removeLast().toArray());
    }
}