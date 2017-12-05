
/**
 * A fixed-size array implementation of the Queue data structure.
 * 
 * @author Daniel J. Norment
 * @version 1.2
 */
public class QueueFixedArray<T> implements QueueInterface<T>
{
    private final static int QUEUE_SIZE = 10;
    private T[] queue;
    private int front; //first item in queue
    private int back; //last item in queue
    private int numOfItems;
    
    public QueueFixedArray()
    {
        this(QUEUE_SIZE);
    }
    
    public QueueFixedArray(int size)
    {
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[])new Object[size];
        queue = tempQueue;
        front = 0;
        back = 0;
    }
    
    /** 
     * Adds a new entry to the back of this queue.
     * @param newEntry  An object to be added. 
     */
    public void enqueue(T newEntry)
    {
        back %= queue.length;
        queue[back] = newEntry;
        numOfItems++;
        back++;
    }
    
    /**
     * Removes and returns the entry at the front of this queue.
     * @return  The object at the front of the queue. 
     * @throws  EmptyQueueException if the queue is empty before the operation.
     */
    public T dequeue() throws EmptyQueueException
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        else
        {
            front %= queue.length;
            T tempItem = queue[front];
            queue[front] = null;
            numOfItems--;
            front++;
            return tempItem;
        }
    }
    
    /**
     * Retrieves the entry at the front of this queue.
     * @return  The object at the front of the queue.
     * @throws  EmptyQueueException if the queue is empty.
     */
    public T getFront() throws EmptyQueueException
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        else
        {
            return queue[front];
        }
    }
    
    /**
     * Detects whether this queue is empty.
     * @return  True if the queue is empty, or false otherwise.
     */
    public boolean isEmpty()
    {
        return numOfItems == 0;
    }
    
    /**
     * Returns the number of items in the queue.
     * @return  The number of items in the queue.
     */
    public int getSize()
    {
        return numOfItems;
    }
    
    /**
     * Removes all entries from this queue.
     */
    public void clear()
    {
        for (int i=0; i<queue.length; i++)
        {
            queue[i] = null;
        }
        front = 0;
        back = 0;
    }
}
