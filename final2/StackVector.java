
/**
 * A vector implementation of the Stack data structure.
 * 
 * @author Daniel J. Norment
 * @version 1.0
 */

import java.util.Vector;

public class StackVector<T> implements StackInterface<T>
{
    Vector<T> stack;
    
    public StackVector()
    {
        stack = new Vector<T>(); //default size = 10
    }
    
    /**
     * Adds a new entry to the top of this stack.
     * @param newEntry  An object to be added to the stack.
     */
    public void push(T newEntry)
    {
        stack.add(newEntry);
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
            T tempItem = stack.lastElement();
            int index = stack.lastIndexOf(tempItem);
            return stack.remove(index);
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
            return stack.lastElement();
        }
    }
    
    /**
     * Detects whether this stack is empty.
     * @return  True if the stack is empty.
     */
    public boolean isEmpty()
    {
        return stack.isEmpty();
    }
    
    /**
     * Removes all entries from this stack.
     */
    public void clear()
    {
        stack.removeAllElements();
    }
}
