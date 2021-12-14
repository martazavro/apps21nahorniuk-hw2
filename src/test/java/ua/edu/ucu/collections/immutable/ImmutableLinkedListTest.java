package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    ImmutableLinkedList immutableLinkedList;
    ImmutableList LinkedList;


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
    public void testAddFirst() {
        ImmutableLinkedList expected = new ImmutableLinkedList(
                new Object[]{1, 2, 3, 4, 5}).addFirst(0);
        Object[] actual = new Object[]{0, 1, 2, 3, 4, 5};
        assertArrayEquals(expected.toArray(), actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllBeforeError() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {5, 3, 1});
        ImmutableList newLinkedList = linkedList.addAll(-1, new Object[] {6, 3});

    }
    @Test(expected = IndexOutOfBoundsException.class)

    public void testAddAllError() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        ImmutableList newLinkedList = linkedList.addAll(4, new Object[] {4, 5});
    }
    @Test
    public void isEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {0});
        assertEquals(linkedList.isEmpty(), false);
    }
    @Test
    public void isEmptyEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {});
        assertEquals(linkedList.isEmpty(), true);
    }
    @Test
    public void toArray() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1,1, 1, 1});
        int[] expected = new int[]{1, 1, 1, 1};
        Object[] actual = linkedList.toArray();
        for (int i = 0; i < expected.length; i ++) {
            assertEquals(actual[i], expected[i]);
        }
    }

    @Test
    public void testSize() {
        immutableLinkedList = new ImmutableLinkedList(new Integer[] {Integer.valueOf(3), Integer.valueOf(5)});
        assertEquals(2, immutableLinkedList.size());
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetInvalidIndexRight() {
        immutableLinkedList.get(5);
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveInvalidIndexRight() {
        immutableLinkedList.remove(10);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveInvalidIndexLeft() {
        immutableLinkedList.remove(-3);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetFirstEmpty() {
        ImmutableLinkedList empty = new ImmutableLinkedList();
        empty.getFirst();
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
    public void testIndexOf() {
        assertEquals(immutableLinkedList.indexOf(3), 0);
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
    public void getHeadEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {});
        assertEquals(linkedList.getHead(), null);
    }

    @Test
    public void getTailEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[]{});
        assertEquals(linkedList.getTail(), null);
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

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddAllInvalidIndexRight() {
        immutableLinkedList.addAll(9,new Object[]{1, 2});
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddAllInvalidIndexLeft() {
        immutableLinkedList.addAll(-5, new Object[]{1, 2});
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddInvalidIndexRight() {
        immutableLinkedList.add(10,1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddInvalidIndexLeft() {
        immutableLinkedList.add(-1,10);
}}
