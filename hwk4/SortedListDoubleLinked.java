
/**
 * An implementation of the ADT Sorted List using doubly linked data. 
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class SortedListDoubleLinked<T extends Comparable<T>> extends ListDoubleLinked<T> implements SortedListInterface<T>
{
    /**
     * Overrides superclass add() to add an entry to the appropriate sorted position in the list. 
     * The list size will be increased by 1.
     * Other item positions above the entry when sorted will be increased by 1.
     * @param item  The object to be added.
     */
    public void add(T item)
    {
        if (isEmpty())
        {
            super.add(item);
        }
        else if (nodes == 1)
        {
            if (tail.getData().compareTo(item) < 0) //tail < item
            {
                add(2, item);
            }
            else
            {
                add(1, item);
            }
        }
        else
        {
            DLNode<T> beforeNode = tail;
            int pos = 1;
            while (beforeNode.getData().compareTo(item) < 0 && beforeNode.getNext() != null) //new item higher
            {
                beforeNode = beforeNode.getNext();
                pos++;
            }
            if (head.getData().compareTo(item) < 0) //head < item
            {
                super.add(item);
            }
            else
            {
                add(pos, item);
            }
        }
    }
}
