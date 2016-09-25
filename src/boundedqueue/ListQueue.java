package boundedqueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *  An {@code ListQueue} is an implementation of the {@link
 *  boundedqueue.ListQueue#ListQueue(int)} that uses a list.
 *  <p>
 *  A typical <strong>representation</strong> is:
 *  <pre>{@code
 *      private List<E> List; // the list that holds the queue elements}
 *  </pre>
 *  <p>
 *  The <strong>abstraction function</strong> is:
 *  <pre>{@code
 *      [elements[0], elements[1], ..., elements[length - 1]]:capacity
 *  }</pre>
 *  <p>
 *  The <strong>representation invariant</strong> is:
 *  <pre>{@code
 *      0 < capacity &&
 *      list.size() <= capacity
 * }</pre>
 *
 *  @author Mike Parrish
 *  @version 2016.09.20
 *
 *  @param <E> the type of elements in this stack
 *
 */


public class ListQueue<E> extends AbstractQueue<E>
{

    //=============================================================
    // Private member variables
    //=============================================================

    private List<E> list;


    //=============================================================
    // Constructor(s)
    //=============================================================

    /**
     * Constructs a new {@code ListQueue} object
     * @param max is the maximum capacity of this queue.
     * @throws IllegalArgumentException if {@code max <= 0}
     */
    public ListQueue(int max) throws IllegalArgumentException
    {
        super(max);
        if (max <= 0)
        {
            throw new IllegalArgumentException();
        }

        list = new LinkedList<>();
    }


    //=============================================================
    // Accessor Methods
    //=============================================================


    @Override
    public int length()
    {
        return list.size();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public int capacity()
    {
        return capacity;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator()
    {
        return list.iterator();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Queue<E> newInstance()
    {
        return new ListQueue<>(capacity);
    }

    //=============================================================
    // Mutator Methods
    //=============================================================
    /**
     * {@inheritDoc}
     */
    @Override
    public void enqueue(E element) throws IllegalArgumentException,
        IllegalStateException
    {
        if (element == null)
        {
            throw new IllegalArgumentException();
        }

        if (list.size() == capacity)
        {
            throw new IllegalStateException();
        }

        list.add(element);

    }


    /**
     * {@inheritDoc}
     */
    @Override
    public E dequeue() throws IllegalStateException
    {
        if (list.isEmpty())
        {
            throw new IllegalStateException();
        }

        return list.remove(0);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void clear()
    {
        list.clear();

    }

}
