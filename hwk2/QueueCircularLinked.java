
/**
 * A two part circular linked data implementation of the Queue data structure.
 * 
 * @author Daniel J. Norment
 * @version 1.0
 */
public class QueueCircularLinked<T> implements QueueInterface<T>
{
    private final static int QUEUE_SIZE = 10;
    private int numOfNodes; //not counting the free node
    private Node<T> free; //last empty node in the queue
    private Node<T> back; //last node in the queue with an item inside
    
    public QueueCircularLinked()
    {
        Node<T> emptyNode = new Node<T>();
        emptyNode.setNext(emptyNode);
        numOfNodes = 0;
        free = emptyNode;
        back = null;
    }
    
    /** 
     * Adds a new entry to the back of this queue.
     * @param newEntry  An object to be added. 
     * @throws  FullQueueException if number of nodes is more than QUEUE_SIZE
     */
    public void enqueue(T newEntry) throws FullQueueException
    {
       if (numOfNodes >= QUEUE_SIZE)
       {
           throw new FullQueueException();
       }
       else
       {
           if (isEmpty())
           {
           Node<T> newNode = new Node<T>(newEntry, free);
           back = newNode;
           free.setNext(back);
           }
           else
           {
           Node<T> newNode = new Node<T>(newEntry, back);
           back = newNode;
           free.setNext(back);
           }
           numOfNodes++;
       }
       
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
            while (secondNode.getNext().getNext() != free)
            {
                secondNode = secondNode.getNext();
            }
            Node<T> firstNode = secondNode.getNext();
            secondNode.setNext(free);
            back = free.getNext();
            return firstNode.getData();
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
            Node<T> secondNode = back.getNext();
            while (secondNode.getNext().getNext() != free)
            {
                secondNode = secondNode.getNext();
            }
            Node<T> front = secondNode.getNext();
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
       while (free.getNext() != free)
       {
           free.setNext(back.getNext());
           back = free.getNext();
       }
       back = null;
    }
}
