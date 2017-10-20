
/**
 * A doubly linked node that stores references to both previous and next nodes and stores data.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class DLNode<T>
{
    private DLNode<T> prev;
    private DLNode<T> next;
    private T data;
    
    public DLNode()
    {
        prev = null;
        next = null;
        data = null;
    }
    
    public DLNode(T newData)
    {
        prev = null;
        next = null;
        data = newData;
    }
    
    /** Sets the previous node of this node.
        @param prevNode  The previous node to be set. */
    public void setPrev(DLNode<T> prevNode)
    {
        prev = prevNode;
    }
    
    /** Sets the next node of this node.
     *  @param nextNode  The next node to be set. */
    public void setNext(DLNode<T> nextNode)
    {
        next = nextNode;
    }
    
    /** Sets the data of this node.
     *  @param newData  The new data to be set. */
    public void setData(T newData)
    {
        data = newData;
    }
    
    /** Gets the previous node from this node.
     *  @return The previous node pointed at by this node. */
    public DLNode<T> getPrev()
    {
        return prev;
    }
    
    /** Gets the next node from this node.
     *  @return The next node pointed at by this node. */
    public DLNode<T> getNext()
    {
        return next;
    }
    
    /** Gets the data from this node.
     *  @return The data in this node. */
    public T getData()
    {
        return data;
    }
}
