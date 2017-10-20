
/**
 * A singly linked node that stores references to previous node and stores data.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class SLNode<T>
{
    private SLNode<T> prev;
    private T data;
    
    public SLNode()
    {
        prev = null;
        data = null;
    }
    
    public SLNode(T newData)
    {
        prev = null;
        data = newData;
    }
    
    /** Sets the previous node of this node.
        @param prevNode  The previous node to be set. */
    public void setPrev(SLNode<T> prevNode)
    {
        prev = prevNode;
    }
    
    /** Sets the data of this node.
     *  @param newData  The new data to be set. */
    public void setData(T newData)
    {
        data = newData;
    }
    
    /** Gets the previous node from this node.
     *  @return The previous node pointed at by this node. */
    public SLNode<T> getPrev()
    {
        return prev;
    }
    
    /** Gets the data from this node.
     *  @return The data in this node. */
    public T getData()
    {
        return data;
    }
}
