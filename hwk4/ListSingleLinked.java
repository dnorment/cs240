
/**
 * An implementation of the ADT List using singly linked data.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class ListSingleLinked<T extends Comparable<T>> implements ListInterface<T>
{
    private SLNode<T> head;
    private SLNode<T> tail;
    private int nodes;
    
    public ListSingleLinked()
    {
        head = null;
        tail = null;
        nodes = 0;
    }
    
    /**
     * Add an entry to the end of the list. 
     * The list size will be increased by 1.
     * Other item positions will be unaffected.
     * @param item  The object to be added.
     */
    public void add(T item)
    {
        SLNode<T> newNode = new SLNode<T>(item);
        if (isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            head.setNext(newNode);
            head = newNode;
        }
        nodes++;
    }
    
    /**
     * Add an entry to the specified position of the list. 
     * The list size will be increased by 1. 
     * Other item positions at or after the given index will be increased by 1.
     * @param position  The index at which to add the item.
     * @param item  The object to be added.
     * @throws IndexOutOfBoundsException if position < 1 or position > getLength() + 1.
     */
    public void add(int position, T item)
    {
        if (position < 1 || position > nodes+1)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            SLNode<T> newNode = new SLNode<T>(item);
            SLNode<T> beforeNode = tail;
            if (isEmpty())
            {
                add(item);
            }
            else
            {
                if (position == 1)
                {
                    newNode.setNext(beforeNode);
                    tail = newNode;
                }
                else
                {
                    for (int i=2; i<position; i++)
                    {
                        beforeNode = beforeNode.getNext();
                    }
                    
                    newNode.setNext(beforeNode.getNext());
                    beforeNode.setNext(newNode);
                    
                    if (newNode.getNext() == null)
                    {
                        head = newNode;
                    }
                }
                nodes++;
            }

        }
    }
    
    /**
     * Remove an entry from the specified position in the list.
     * The list size will be decreased by 1.
     * Other item positions at or after the given index will be decreased by 1.
     * @param position  The index at which the remove the item.
     * @throws IndexOutOfBoundsException if position < 1 or position > getLength() + 1.
     * @return The item removed at the given position.
     */
    public T remove(int position)
    {
        if (position < 1 || position > nodes)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            SLNode<T> beforeNode = tail;
            T temp;
            if (nodes == 1)
            {
                temp = beforeNode.getData();
                clear();
            }
            else if (position == 1)
            {
                SLNode<T> newTail = tail.getNext();
                temp = tail.getData();
                tail.setData(null);
                tail.setNext(null);
                tail = newTail;
                nodes--;
            }
            else
            {
                SLNode<T> rmNode = tail.getNext();
                for (int i=2; i<position; i++)
                {
                    beforeNode = beforeNode.getNext();
                    rmNode = beforeNode.getNext();
                }
                temp = rmNode.getData();
                if (rmNode.getNext() == null)
                {
                    beforeNode.setNext(null);
                    head = beforeNode;
                }
                else
                {
                    beforeNode.setNext(rmNode.getNext());
                    rmNode.setNext(null);
                }
                rmNode.setData(null);
                nodes--;
            }
            return temp;
        }
    }
    
    /**
     * View an entry at the specified position in the list.
     * @param position  The index at which to view an item.
     * @throws IndexOutOfBoundsException if position < 1 or position > getLength() + 1.
     * @return The item at the given position.
     */
    public T view(int position)
    {
        if (position < 1 || position > nodes)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            SLNode<T> thisNode = tail;
            for (int i=1; i<position; i++)
            {
                thisNode = thisNode.getNext();
            }
            return thisNode.getData();
        }
    }
    
    /**
     * Get the length of the list.
     * @return The length of the list.
     */
    public int getLength()
    {
        return nodes;
    }
    
    /**
     * Check if the list is empty.
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return head == null && tail == null;
    }
    
    /**
     * Clears all entries from the list.
     * The list size will be reset to 0.
     */
    public void clear()
    {
       if (!isEmpty())
       {
           SLNode<T> lastNode = tail;
           while (lastNode.getNext() != null)
           {
               lastNode.setData(null);
               SLNode<T> nextNode = lastNode.getNext();
               lastNode.setNext(null);
               lastNode = nextNode;
           }
           head.setData(null);
           head.setNext(null);
           head = null;
           tail = null;
           nodes = 0;
       }
    }
}
