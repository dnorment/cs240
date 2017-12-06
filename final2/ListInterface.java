
/**
 * An interface for the ADT list.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public interface ListInterface<T>
{
    /**
     * Add an entry to the end of the list. 
     * The list size will be increased by 1.
     * Other item positions will be unaffected.
     * @param item  The object to be added.
     */
    public void add(T item);
    
    /**
     * Add an entry to the specified position of the list. 
     * The list size will be increased by 1. 
     * Other item positions at or after the given index will be increased by 1.
     * @param position  The index at which to add the item.
     * @param item  The object to be added.
     * @throws IndexOutOfBoundsException if position < 1 or position > getLength() + 1.
     */
    public void add(int position, T item);
    
    /**
     * Remove an entry from the specified position in the list.
     * The list size will be decreased by 1.
     * Other item positions at or after the given index will be decreased by 1.
     * @param position  The index at which the remove the item.
     * @throws IndexOutOfBoundsException if position < 1 or position > getLength() + 1.
     * @return The item removed at the given position.
     */
    public T remove(int position);
    
    /**
     * View an entry at the specified position in the list.
     * @param position  The index at which to view an item.
     * @throws IndexOutOfBoundsException if position < 1 or position > getLength() + 1.
     * @return The item at the given position.
     */
    public T view(int position);
    
    /**
     * Get the length of the list.
     * @return The length of the list.
     */
    public int getLength();
    
    /**
     * Check if the list is empty.
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty();
    
    /**
     * Clears all entries from the list.
     * The list size will be reset to 0.
     */
    public void clear();
}
