package boundedqueue;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains unit tests for the ListQueue class. It purpose is to
 * test all constructors and methods of the ListQueue class.
 *
 *  @author Mike Parrish
 *  @version 2016.09.25
 */
public class ListQueueTest
{

    //==================================================
    // Private Member Variables
    //==================================================


    private Queue<String> q0;
    private Queue<String> q4;


    //==================================================
    // Constructor Tests
    //==================================================


    /**
     * Place a description of your method here.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        q0 = new ListQueue<>(10);
        q4 = new ListQueue<>(10);
        q4.enqueue("A");
        q4.enqueue("B");
        q4.enqueue("C");
        q4.enqueue("D");

    }


    /**
     * Test method for {@link boundedqueue.ListQueue#ListQueue(int)}.
     */
    @Test
    public void testListQueue()
    {
        assertTrue(q0.isEmpty());
        assertFalse(q4.isEmpty());
        assertTrue(q0.length() == 0);
        assertTrue(q4.length() == 4);
    }


    /**
     * Test method for {@link boundedqueue.ListQueue#ListQueue(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testListQueueIAE()
    {
        q0 = new ListQueue<>(-5);
        fail();
    }


    /**
     * Test method for {@link boundedqueue.ListQueue#ListQueue(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testListQueueIAE2()
    {
        q0 = new ListQueue<>(0);
        fail();
    }


    //==================================================
    // Accessor Tests
    //==================================================

    // NOTE: The following accessor methods are not tested
    //       directly because they are tested in adjacent accessor
    //       and mutator tests:
    //       1.  length()
    //       2.  capacity()
    //       3.  isEmpty()


    /**
     * Test method for {@link boundedqueue.ListQueue#iterator()}.
     */
    @Test
    public void testIterator()
    {
        int count = 0;

        for (String s : q4)
        {
            count++;
        }

        assertEquals(4, count);
    }


    /**
     * Test method for {@link boundedqueue.ListQueue#newInstance()}.
     */
    @Test
    public void testNewInstance()
    {
        Queue<String> q = q4.newInstance();
        assertTrue(q.isEmpty());
        assertEquals(q.capacity(), q4.capacity());
    }


    /**
     * Test method for {@link boundedqueue.AbstractQueue#isFull()}.
     */
    @Test
    public void testIsFull()
    {
        assertFalse(q4.isFull());
        q4.enqueue("E");
        q4.enqueue("F");
        q4.enqueue("G");
        q4.enqueue("H");
        q4.enqueue("I");
        q4.enqueue("J");
        assertTrue(q4.isFull());

    }


    /**
     * Test method for {@link boundedqueue.AbstractQueue#hashCode()}.
     */
    @Test
    public void testHashCode()
    {
        Queue<String> q = new ListQueue<>(10);
        assertEquals(q0.hashCode(), q.hashCode());

        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.enqueue("D");
        assertEquals(q4.hashCode(), q.hashCode());

    }


    /**
     * Test method for {@link boundedqueue.AbstractQueue#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObject()
    {
        assertTrue(q0.equals(q0));

        Queue<String> q;
        q = new ListQueue<>(10);
        assertTrue(q0.equals(q));

        q.enqueue("A");
        q.enqueue("B");
        assertFalse(q4.equals(q));
        q.enqueue("C");
        q.enqueue("D");
        assertTrue(q4.equals(q));

        q.dequeue();
        q.enqueue("E");
        assertFalse(q4.equals(q));

        assertFalse(q0.equals(null));

        q = new ListQueue<>(20);
        assertFalse(q0.equals(q));

        assertFalse(q0.equals("A"));


    }

    /**
     * Test method for {@link boundedqueue.AbstractQueue#toString()}.
     */
    @Test
    public void testToString()
    {
        assertEquals("[]:10", q0.toString());
        assertEquals("[A, B, C, D]:10", q4.toString());
    }


    //==================================================
    // Mutator Tests
    //==================================================


    /**
     * Test method for {@link boundedqueue.ListQueue#enqueue(java.lang.Object)}.
     */
    @Test
    public void testEnqueue()
    {
        assertEquals(4, q4.length());
    }


    /**
     * Test method for {@link boundedqueue.ListQueue#enqueue(java.lang.Object)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testEnqueueIAE()
    {
        q4.enqueue(null);
        fail();
    }


    /**
     * Test method for {@link boundedqueue.ListQueue#enqueue(java.lang.Object)}.
     */
    @Test(expected=IllegalStateException.class)
    public void testEnqueueISE()
    {
        q4.enqueue("E");
        q4.enqueue("F");
        q4.enqueue("G");
        q4.enqueue("H");
        q4.enqueue("I");
        q4.enqueue("J");
        q4.enqueue("K");
        fail();
    }


    /**
     * Test method for {@link boundedqueue.ListQueue#dequeue()}.
     */
    @Test
    public void testDequeue()
    {
        String str = q4.dequeue();
        assertEquals("A", str);
        assertEquals(3, q4.length());
    }

    /**
     * Test method for {@link boundedqueue.ListQueue#dequeue()}.
     */
    @Test
    public void testDequeue3Times()
    {
        String str1 = q4.dequeue();
        assertEquals("A", str1);
        assertEquals(3, q4.length());

        String str2 = q4.dequeue();
        assertEquals("B", str2);
        assertEquals(2, q4.length());

        String str3 = q4.dequeue();
        assertEquals("C", str3);
        assertEquals(1, q4.length());

    }


    /**
     * Test method for {@link boundedqueue.ListQueue#dequeue()}.
     */
    @Test(expected=IllegalStateException.class)
    public void testDequeueISE()
    {
        q0.dequeue();
        fail();
    }



    /**
     * Test method for {@link boundedqueue.ListQueue#clear()}.
     */
    @Test
    public void testClear()
    {
        q4.clear();
        assertTrue(q4.isEmpty());
    }

    /**
     * Test method for {@link boundedqueue.AbstractQueue#append(boundedqueue.Queue)}.
     */
    @Test
    public void testAppend()
    {
        Queue<String> q = new ListQueue<>(10);
        q.enqueue("E");
        q.enqueue("F");
        q.enqueue("G");

        q4.append(q);
        assertEquals(7, q4.length());


    }


    /**
     * Test method for {@link boundedqueue.AbstractQueue#append(boundedqueue.Queue)}.
     */
    @Test(expected=IllegalStateException.class)
    public void testAppendISE()
    {
        Queue<String> q = new ListQueue<>(10);
        q.enqueue("E");
        q.enqueue("f");
        q.enqueue("G");
        q.enqueue("H");
        q.enqueue("I");
        q.enqueue("J");
        q.enqueue("k");
        q4.append(q);
        fail();

    }


    /**
     * Test method for {@link boundedqueue.AbstractQueue#copy()}.
     */
    @Test
    public void testCopy()
    {
        Queue<String> q = q4.copy();
        assertEquals(q4.length(), q.length());

        String str1 = q4.dequeue();
        String str2 = q.dequeue();
        assertTrue(str1 == str2);

    }

}
