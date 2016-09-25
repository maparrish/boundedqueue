package boundedqueue;

import java.util.Iterator;

/**
 *  An {@code AbstractQueue} class implements the secondary methods that are
 *  common to all concrete implementations of boundqueue.queue interface
 *
 *  @author Mike Parrish
 *  @version 2016.09.25
 *
 *  @param <E> the type of elements in this stack
 */
public abstract class AbstractQueue<E> implements Queue<E>
{

    //=============================================================
    // Private member variables
    //=============================================================


    protected final int capacity;


    //=============================================================
    // Constructor(s)
    //=============================================================


    /**
     * Constructs a new {@code AbstractQueue} object.
     * @param max is the maximum capacity of this queue.
     */
    protected AbstractQueue(int max)
    {
        capacity = max;
    }


    //=============================================================
    // Accessor Methods
    //=============================================================


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty()
    {
        return this.length() == 0;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isFull()
    {
        return length() == capacity();
    }


    /**
     * {@inheritDoc}
     */
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + capacity();
        result = prime * result + length();
        for (E elem : this)
        {
            result = prime * result + elem.hashCode();
        }
        return result;
    }


    /**
     * {@inheritDoc}
     */
     public boolean equals(Object obj)
     {
         if (obj == null) return false;
         if (!(obj instanceof Queue)) return false;
         Queue<?> other = (Queue<?>)obj;

         if (capacity() != other.capacity()) return false;
         if (length() != other.length()) return false;

         Iterator<?> otherIter = other.iterator();
         for (E elem : this)
         {
             if (!elem.equals(otherIter.next()))
             {
                 return false;
             }
         }
         return true;
     }


     /**
      * {@inheritDoc}
      */
     @Override
     public String toString()
     {
         StringBuilder sb = new StringBuilder();
         sb.append("[");

         Iterator<E> iter = this.iterator();
         while (iter.hasNext())
         {
             E elem = iter.next();
             if (iter.hasNext())
             {
                 sb.append(elem.toString() + ", ");
             }
             else
             {
                 sb.append(elem.toString());
             }
         }
         sb.append("]:");
         sb.append(this.capacity());
         return sb.toString();
     }

    //=============================================================
    // Mutator Methods
    //=============================================================


    /**
     * {@inheritDoc}
     */
    @Override
    public void append(Queue<E> that) throws IllegalStateException
    {
        if (that.length() > capacity - this.length())
        {
            throw new IllegalStateException();
        }

        for (E elem : that)
        {
            this.enqueue(elem);
        }

        that.clear();

    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Queue<E> copy()
    {
        Queue<E> result = this.newInstance();

        for (E elem : this)
        {
            result.enqueue(elem);
        }

        return result;
    }

}
