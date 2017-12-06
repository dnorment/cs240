
/**
 * A fixed size array implementation of the ADT list.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class ListFixedSize<T> implements ListInterface<T>
{
    public static final int MAX_SIZE = 10;
    private T[] list;
    private int numOfEntries;
    
    public ListFixedSize()
    {
        @SuppressWarnings("unchecked")
        T[] tempList = (T[])new Object[MAX_SIZE];
        list = tempList;
        numOfEntries = 0;
    }
    
    /**
     * Add an entry to the end of the list. 
     * The list size will be increased by 1.
     * Other item positions will be unaffected.
     * @param item  The object to be added.
     */
    public void add(T item)
    {
        list[numOfEntries++] = item;
    }
    
    /**
     * Add an entry to the specified position of the list. 
     * The list size will be increased by 1. 
     * Other item positions at or after the given index will be increased by 1.
     * @param position  The index at which to add the item.
     * @param item  The object to be added.
     * @throws IndexOutOfBoundsException if position < 0 or position > getLength() + 1.
     */
    public void add(int position, T item)
    {
        if (position < 0 || position > numOfEntries)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            list[position+1] = list[position];
            for (int i=numOfEntries-1; i>position; i--) //move items over if necessary
            {
                list[i+1] = list[i];
            }
            list[position] = item;
            numOfEntries++;
        }
    }
    
    /**
     * Remove an entry from the specified position in the list.
     * The list size will be decreased by 1.
     * Other item positions at or after the given index will be decreased by 1.
     * @param position  The index at which the remove the item.
     * @throws IndexOutOfBoundsException if position < 0 or position > getLength() + 1.
     * @return The item removed at the given position.
     */
    public T remove(int position)
    {
        if (position < 0 || position >= numOfEntries)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            T temp = list[position];
            for(int i=position; i<numOfEntries; i++)
            {
                list[i] = list[i+1];
            }
            list[numOfEntries-1] = null;
            numOfEntries--;
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
        if (position < 0 || position >= numOfEntries)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            return list[position];
        }
    }
    
    /**
     * Get the length of the list.
     * @return The length of the list.
     */
    public int getLength()
    {
        return numOfEntries;
    }
    
    /**
     * Check if the list is empty.
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return numOfEntries == 0;
    }
    
    /**
     * Clears all entries from the list.
     * The list size will be reset to 0.
     */
    public void clear()
    {
        for (int i=0; i<MAX_SIZE; i++)
        {
            list[i] = null;
        }
        numOfEntries = 0;
    }
}
