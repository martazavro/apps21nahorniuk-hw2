package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class NodeTest {

    Node nextNode;
    Node previousNode;

    @Before
    public void setUp() {
        nextNode = new Node();
        previousNode = new Node();
        previousNode.setNext(nextNode);
        nextNode.setPrevious(previousNode);
        previousNode.setValue(2);
        nextNode.setValue(7);
    }

    @Test
    public void testToString() {
        assertEquals(nextNode.toString(), "7");
    }

    @Test
    public void getPrevious() {
        assertEquals(nextNode.getPrevious(), previousNode);
    }

    @Test
    public void setPrevious() {
        previousNode.setPrevious(nextNode);
        assertEquals(previousNode.getPrevious(), nextNode);

    }

    @Test
    public void getNext() {
        assertEquals(previousNode.getNext(), nextNode);
    }

    @Test
    public void setNext() {
        nextNode.setNext(previousNode);
        assertEquals(nextNode.getNext(), previousNode);
    }

    @Test
    public void getValue() {
        assertEquals(nextNode.getValue(), 7);
    }

    @Test
    public void setValue() {
        nextNode.setValue(1);
        assertEquals(nextNode.toString(), "1");
    }

}