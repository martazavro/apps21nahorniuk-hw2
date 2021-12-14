package ua.edu.ucu.collections.immutable;
import junit.framework.TestCase;
import static org.junit.Assert.*;

public class ImmutableArrayListTest extends TestCase {
    private ImmutableArrayList arrayList;
    private ImmutableArrayList arrayList2;
    private ImmutableList newArrayList;

    public void setUp() throws Exception {
        super.setUp();
        this.arrayList = new ImmutableArrayList(new Object[] {5, 3});
    }

    public void testAdd() {
        Object[] array =  {5, 3};
        arrayList = new ImmutableArrayList(array);
        arrayList2 = (ImmutableArrayList) arrayList.add(1);
        assertEquals("5 3 1 ", arrayList2.toString());
        assertEquals("5 3 ", arrayList.toString());
    }

    public void testAddAll() {
        Object[] array =  {5, 3};

        arrayList = new ImmutableArrayList(array);
        arrayList2 = (ImmutableArrayList) arrayList.addAll(array);
        assertEquals("5 3 5 3 ", arrayList2.toString());
        assertEquals("5 3 ", arrayList.toString());
        arrayList2 = (ImmutableArrayList) arrayList.addAll(0, array);
        assertEquals("5 3 5 3 ", arrayList2.toString());
        assertEquals("5 3 ", arrayList.toString());

        arrayList2 = (ImmutableArrayList) arrayList.addAll(1, array);
        assertEquals("5 5 3 3 ", arrayList2.toString());
        assertEquals("5 3 ", arrayList.toString());
    }

    public void testTestAddAll() {
        newArrayList = arrayList.addAll(1, new Object[] {7, 8});
        Object[] expectedRes = new Object[] {5, 7, 8, 3};
        Object[] actualRes = newArrayList.toArray();
        for (int i =0; i < 4; ++i) {
            assertEquals(expectedRes[i], actualRes[i]);
        }
    }

    public void testGet() {
        assertEquals(arrayList.get(1), 3);
    }

    public void testRemove() {
        ImmutableArrayList newList = (ImmutableArrayList) arrayList.remove(0);
        assertArrayEquals(newList.toArray(), new Object[]{3});
    }

    public void testSet() {
        newArrayList = arrayList.set(1, 10);
        Object[] expected = {5, 10};
        Object[] actual = newArrayList.toArray();
        for (int i =0; i < 2; ++i) {
            assertEquals(expected[i], actual[i]);
        }
    }

    public void testIndexOf() {
        assertEquals(arrayList.indexOf(5), 0);
    }

    public void testSize() {
        assertEquals(arrayList.size(), 2);
    }

    public void testClear() {
        ImmutableArrayList newList = (ImmutableArrayList) arrayList.clear();
        assertEquals(0, newList.size());
    }

    public void testIsEmpty() {
        assertFalse(arrayList.isEmpty());
    }

    public void testToArray() {
        assertArrayEquals(arrayList.toArray(), new Object[]{5, 3});
    }
}