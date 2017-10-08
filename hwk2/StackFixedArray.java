
/**
 * A fixed-size array implementation of the Stack data structure.
 * 
 * @author Daniel J. Norment
 * @version 1.0
 */
public class StackFixedArray<T> implements StackInterface<T>
{
    private final static int STACK_SIZE = 10;
    private int numOfEntries;
    private T[] stack;
    
    public StackFixedArray()
    {
        this(STACK_SIZE);
    }
    
    public StackFixedArray(int size)
    {
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[size];
        stack = tempStack;
        numOfEntries = 0;
    }
    
    /**
     * Adds a new entry to the top of this stack.
     * @param newEntry  An object to be added to the stack.
     */
    public void push(T newEntry)
    {
        stack[numOfEntries] = newEntry;
        numOfEntries++;
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
            T tempEntry = stack[numOfEntries-1];
            stack[numOfEntries-1] = null;
            numOfEntries--;
            return tempEntry;
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
            return stack[numOfEntries-1];
        }
    }
    
    /**
     * Detects whether this stack is empty.
     * @return  True if the stack is empty.
     */
    public boolean isEmpty()
    {
        return numOfEntries == 0;
    }
    
    /**
     * Removes all entries from this stack.
     */
    public void clear()
    {
        for (int i=0; i<numOfEntries; i++)
        {
            stack[i] = null;
        }
        numOfEntries = 0;
    }
}
