
/**
 * A class implementing the ADT Deque using singly linked nodes
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class SLDeque<T> implements DequeInterface<T>
{
   private SLNode<T> head; //pointer to beginning of line
   private SLNode<T> tail; //pointer to end of line
   
   public SLDeque()
   {
       head = null;
       tail = null;
   }
   
   public SLDeque(SLNode<T> firstNode)
   {
       head = firstNode;
       tail = firstNode;
   }
   
   /** Adds a new entry to the front/back of this dequeue.
       @param newEntry  An object to be added. */
   public void addToFront(T newEntry)
   {
       SLNode<T> newNode = new SLNode<T>(newEntry);
       if (head == null)
       {
           head = newNode;
           tail = newNode;
       }
       else
       {
           head.setPrev(newNode);
           head = newNode;
       }
   }
   public void addToBack(T newEntry)
   {
       SLNode<T> newNode = new SLNode<T>(newEntry);
       if (tail == null)
       {
           head = newNode;
           tail = newNode;
       }
       else
       {
           newNode.setPrev(tail);
           tail = newNode;
       }
   }
   
   /** Removes and returns the front/back entry of this dequeue.
       @return  The object at the front/back of the dequeue.
       @throws  EmptyQueueException if the dequeue is empty before the operation. */
   public T removeFront()
   {
       if (head == null)
       {
           throw new EmptyQueueException();
       }
       else
       {
           T tempData = head.getData();
           head.setData(null);
           if (head == tail)
           {
               head = null;
               tail = null;
           }
           else
           {
               SLNode<T> lastNode = tail;
               while (lastNode.getPrev() != head)
               {
                   lastNode = lastNode.getPrev();
               }
               head = lastNode;
               head.setPrev(null);
           }
           return tempData;
       }
   }
   public T removeBack()
   {
       if (tail == null)
       {
           throw new EmptyQueueException();
       }
       else
       {
           T tempData = tail.getData();
           SLNode<T> newBack = tail.getPrev();
           tail.setPrev(null);
           tail.setData(null);
           tail = newBack;
           return tempData;
       }
   }
   
   /** Retrieves the front/back entry of this dequeue.
       @return  The object at the front/back of the dequeue.
       @throws  EmptyQueueException if the dequeue is empty before the operation. */
   public T getFront()
   {
       if (head == null)
       {
           throw new EmptyQueueException();
       }
       else
       {
           return head.getData();
       }
   }
   public T getBack()
   {
       if (tail == null)
       {
           throw new EmptyQueueException();
       }
       else
       {
           return tail.getData();
       }
   }
   
   /**  Detects whether this dequeue is empty.
        @return  True if the queue is empty, or false otherwise. */
   public boolean isEmpty()
   {
       return head == null && tail == null;
   }
   
   /**  Removes all entries from this dequeue. */
   public void clear()
   {
       if (!isEmpty())
       {
           SLNode<T> lastNode = tail;
           while (lastNode.getPrev() != null)
           {
               lastNode.setData(null);
               SLNode<T> nextNode = lastNode.getPrev();
               lastNode.setPrev(null);
               lastNode = nextNode;
           }
           head.setData(null);
           head = null;
           tail = null;
       }
   }
}
