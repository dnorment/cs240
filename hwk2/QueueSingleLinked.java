
/**
 * A single linked data implementation of the Queue data structure.
 * 
 * @author Daniel J. Norment
 * @version 1.0
 */
public class QueueSingleLinked<T> implements QueueInterface<T>
{
    private Node<T> front; //first item in queue
    private Node<T> back; //last item in queue
    
    public QueueSingleLinked()
    {
        front = null;
        back = null;
    }
    
    /** 
     * Adds a new entry to the back of this queue.
     * @param newEntry  An object to be added. 
     */
    public void enqueue(T newEntry)
    {
       Node<T> newNode = new Node<T>(newEntry, back);
       if (isEmpty())
       {
           front = newNode;
       }
       back = newNode;
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
            Node<T> secondNode = back.getNext();
            while (secondNode.getNext() != front)
            {
                secondNode = secondNode.getNext();
            }
            Node<T> tempFront = front;
            secondNode.setNext(null);
            front = secondNode;
            return tempFront.getData();
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
            return front.getData();
        }
    }
    
    /**
     * Detects whether this queue is empty.
     * @return  True if the queue is empty, or false otherwise.
     */
    public boolean isEmpty()
    {
       return back == null;
    }
    
    /**
     * Removes all entries from this queue.
     */
    public void clear()
    {
       front = null;
       back = null;
    }
}
