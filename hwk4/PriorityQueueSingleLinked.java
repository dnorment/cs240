
/**
 * An implementation of the ADT Priority Queue using singly linked data. 
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class PriorityQueueSingleLinked<T extends Comparable<T>> implements PriorityQueueInterface<T>
{
    private SLPNode<T> head;
    private SLPNode<T> tail;
    private int nodes;
    
    public PriorityQueueSingleLinked()
    {
        head = null;
        tail = null;
        nodes = 0;
    }
    
    /** Adds a new entry to the end of this priority queue.
       @param newEntry  An object to be added. */
    public void add(T newEntry)
    {
       add(newEntry, 0);
    }
    
    /** Adds a new entry to this priority queue with a certain priority.
     * @param newEntry  An object to be added.
     * @param pri  The priority of the object to be added (>=0). */
    public void add(T newEntry, int pri)
    {
       SLPNode<T> newNode = new SLPNode<T>(newEntry, pri);
       if (isEmpty())
       {
           head = newNode;
           tail = newNode;
       }
       else
       {
           SLPNode<T> beforeNode = search(newNode);
           if (beforeNode.getNext() != null)
           {
               newNode.setNext(beforeNode.getNext());
           }
           
           if (beforeNode == tail)
           {
               if (beforeNode == head)
               {
                   if (newNode.compareTo(beforeNode) < 0)
                   {
                       newNode.setNext(beforeNode);
                   }
                   else
                   {
                       beforeNode.setNext(newNode);
                   }
               }
               else
               {
                   newNode.setNext(beforeNode);
                   tail = newNode;
               }
           }
           else
           {
               beforeNode.setNext(newNode);
           }
           if (beforeNode == head)
           {
              head = newNode;
           }
       }
       nodes++;
    }
    
    public SLPNode<T> search(SLPNode<T> newNode)
    {
        SLPNode<T> thisNode = tail;
        SLPNode<T> beforeNode = tail;
        int zexit = 0;
        while (newNode.compareTo(thisNode) > 0 && zexit != 1)
        {
            beforeNode = thisNode;
            if (thisNode.getNext() == null)
            {
                zexit = 1;
            }
            else
            {
                thisNode = thisNode.getNext();
            }
        }
        return beforeNode;
    }

    /** Removes and returns the entry having the highest priority.
       @return  Either the object having the highest priority or,
                if the priority queue is empty before the operation, null. */
    public T remove()
    {
       if (isEmpty())
       {
           return null;
       }
       else
       {
           return null;
       }
    }

    /** Retrieves the entry having the highest priority.
       @return  Either the object having the highest priority or,
                if the priority queue is empty, null. */
    public T peek()
    {
       if (isEmpty())
       {
           return null;
       }
       else
       {
           return head.getData();
       }
    }

    /** Detects whether this priority queue is empty.
       @return  True if the priority queue is empty, or false otherwise. */
    public boolean isEmpty()
    {
       return head == null && tail == null;
    }

    /** Gets the size of this priority queue.
       @return  The number of entries currently in the priority queue. */
    public int getSize()
    {
       return nodes;
    }

    /** Removes all entries from this priority queue. */
    public void clear()
    {
       //
    }
}
