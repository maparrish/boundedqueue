package boundedqueue;


/**
 *  A bounded queue is a bounded First-In, First-Out(FIFO) collection
 *  of non-null elements.
 *  <p>
 *  Any concrete class that implements this interface should have the
 *  following one argument constructor:
 *  <pre>{@code
 *      public MyQueue(int max) throws IllegalArgumentException;}
 *  </pre>
 *  The argument {@code max} will be the capacity of the queue and the
 *  constructor will throw an {@code IllegalArgumentException} if
 *  {@code max <= 0}
 *  <p>
 *  A typical bounded queue is {@code [e1, e2, ..., ek]:N} where
 *  {@code e1...ek} are the elements of the queue from first in to last in
 *  and N is the capacity of queue.
 *
 *  @param <E>
 *
 *  @author Mike Parrish
 *  @version 2016.09.25
 */
public interface Queue<E> extends Iterable<E>
{

    // ============================================================
    // Primary Methods
    // ============================================================


    /**
     * Adds the specified element onto this queue.
     * @param element is the element to be added to the queue
     * @throws IllegalArgumentException if {@code element == null}
     * @throws IllegalStateException if this queue is full
     */
    public void enqueue(E element) throws IllegalArgumentException,
        IllegalStateException;


    /**
     * Removes and returns the first element of the queue
     * @return the first element of this queue
     * @throws IllegalStateException if this queue is empty
     */
    public E dequeue() throws IllegalStateException;


    /**
     * Returns the length of this queue
     * @return the length of this queue
     */
    public int length();


    /**
     * Returns the capacity of this queue
     * @return the capacity of this queue
     */
    public int capacity();


    /**
     * Returns a new empty queue with the same capacity as this queue
     * @return a new empty queue with the same capacity as this queue
     */
    public Queue<E> newInstance();


    /**
     * Empties this queue
     */
    public void clear();

    // ============================================================
    // Secondary Methods
    // ============================================================


    /**
     * Returns true if this queue is empty.
     * @return true if this queue is empty.
     */
    public boolean isEmpty();

    /**
     * Returns true if this queue is full.
     * @return true if this queue is full.
     */
    public boolean isFull();


    /**
     * Append empties its queue
     * @param that is the queue to be emptied
     */
    public void append(Queue<E> that);


    /**
     * Returns a new queue that is a shallow copy of this queue.  The new
     * queue has the same capacity as this queue.
     * @return a new queue that is a shallow copy of this queue.
     */
    public Queue<E> copy();
}

