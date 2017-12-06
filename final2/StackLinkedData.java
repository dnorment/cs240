
/**
 * A linked data implementation of the Stack data structure.
 * 
 * @author Daniel J. Norment
 * @version 1.0
 */

public class StackLinkedData<T> implements StackInterface<T>
{
    Node<T> top;
    
    public StackLinkedData()
    {
        top = null;
    }
    
    public StackLinkedData(Node<T> start)
    {
        top = start;
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
     * Removes all entries from this stack.
     */
    public void clear()
    {
        top = null;
    }
}
