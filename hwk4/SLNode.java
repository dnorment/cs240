
/**
 * A singly linked node that stores references to previous node, stores data, and is comparable.
 *
 * @author Daniel J. Norment
 * @version 1.1
 */
public class SLNode<T extends Comparable<T>> implements Comparable<SLNode<T>>
{
    private SLNode<T> next;
    private T data;
    
    public SLNode()
    {
        next = null;
        data = null;
    }
    
    public SLNode(T newData)
    {
        next = null;
        data = newData;
    }
    
    /** Sets the previous node of this node.
        @param prevNode  The previous node to be set. */
    public void setNext(SLNode<T> prevNode)
    {
        next = prevNode;
    }
    
    /** Sets the data of this node.
     *  @param newData  The new data to be set. */
    public void setData(T newData)
    {
        data = newData;
    }
    
    /** Gets the previous node from this node.
     *  @return The previous node pointed at by this node. */
    public SLNode<T> getNext()
    {
        return next;
    }
    
    /** Gets the data from this node.
     *  @return The data in this node. */
    public T getData()
    {
        return data;
    }
    
    /** Compares data between two nodes.
     *  @param other  The node to which to compare this one.
     *  @return -1, 0, or 1 if the priority of this node is less than, equal to, or greater than the priority of the other node. */
    public int compareTo(SLNode<T> other)
    {
        return data.compareTo(other.getData());
    }
}
