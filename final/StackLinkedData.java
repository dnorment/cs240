
/**
 * A linked data implementation of the Stack data structure.
 * 
 * @author Daniel J. Norment
 * @version 1.0
 */

public class StackLinkedData<T> implements StackInterface<T>
{
    Node<T> top;
    int numOfItems;
    
    public StackLinkedData()
    {
        top = null;
        numOfItems = 0;
    }
    
    public StackLinkedData(Node<T> start)
    {
        top = start;
        numOfItems = 1;
    }
    
    /**
     * Adds a new entry to the top of this stack.
     * @param newEntry  An object to be added to the stack.
     */
    public void push(T newEntry)
    {
        Node<T> newNode = new Node<T>(newEntry, top);
        top = newNode;
        newNode = null;
        numOfItems++;
    }
    
    /**
     * Removes and returns this stack's top entry.
     * @return  The object at the top of the stack. 
     * @throws  EmptyStackException if the stack is empty before the operation.
     */
    public T pop() throws EmptyStackException
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            Node<T> tempNode = top;
            top = tempNode.getNext();
            numOfItems--;
            return tempNode.getData();
        }
    }
    
    /** 
     * Retrieves this stack's top entry.
     * @return  The object at the top of the stack.
     * @throws  EmptyStackException if the stack is empty. 
     */
    public T peek() throws EmptyStackException
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return top.getData();
        }
    }
    
    /**
     * Detects whether this stack is empty.
     * @return  True if the stack is empty.
     */
    public boolean isEmpty()
    {
        return top == null;
    }
    
    /**
     * Returns the number of items in the stack.
     * @return  The number of items in the stack.
     */
    public int getSize()
    {
        return numOfItems;
    }
    
    /**
     * Removes all entries from this stack.
     */
    public void clear()
    {
        top = null;
    }
}
