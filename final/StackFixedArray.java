
/**
 * A fixed-size array implementation of the Stack data structure.
 * 
 * @author Daniel J. Norment
 * @version 1.1
 */
public class StackFixedArray<T> implements StackInterface<Integer>
{
    private final static int STACK_SIZE = 10;
    private int numOfEntries;
    private Integer[] stack;
    
    public StackFixedArray()
    {
        this(STACK_SIZE);
    }
    
    public StackFixedArray(int size)
    {
        @SuppressWarnings("unchecked")
        Integer[] tempStack = new Integer[size];
        stack = tempStack;
        numOfEntries = 0;
    }
    
    /**
     * Adds a new entry to the top of this stack.
     * @param newEntry  An object to be added to the stack.
     * @throws FullStackException if the stack is full.
     */
    public void push(Integer newEntry) throws FullStackException
    {
        if (numOfEntries >= stack.length)
        {
            throw new FullStackException();
        }
        else
        {
            stack[numOfEntries] = newEntry;
            numOfEntries++;
        }
    }
    
    /**
     * Removes and returns this stack's top entry.
     * @return  The object at the top of the stack. 
     * @throws  EmptyStackException if the stack is empty before the operation.
     */
    public Integer pop() throws EmptyStackException
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            Integer tempEntry = stack[numOfEntries-1];
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
    public Integer peek() throws EmptyStackException
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
     * Returns the number of items in the stack.
     * @return  The number of items in the stack.
     */
    public int getSize()
    {
        return numOfEntries;
    }
    
    /**
     * Returns an array of all items in the stack.
     * @return  An array with items in the stack.
     */
    public Integer[] toArray()
    {
        return stack;
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
