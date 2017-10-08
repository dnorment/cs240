
/**
 * An object containing both data and a reference to the next Node in the stack.
 * 
 * @author Daniel J. Norment
 * @version 1.0
 */
public class Node<T>
{
    private T data;
    private Node<T> next;

    public Node()
    {
        data = null;
        next = null;
    }
    
    public Node(T info, Node<T> nextNode)
    {
        data = info;
        next = nextNode;
    }
    
    /**
     * Returns the data in the node.
     * @return  The data contained in the node.
     */
    public T getData()
    {
        return data;
    }
    
    /**
     * Returns the node referenced by this node.
     * @return  The Node object referenced by this node.
     */
    public Node<T> getNext()
    {
        return next;
    }
    
    /**
     * Sets the data in the node.
     * @param info  The data to be set.
     */
    public void setData(T info)
    {
        data = info;
    }
    
    /**
     * Sets the next node in the link.
     * @param nextNode  The next node to be referenced.
     */
    public void setNext(Node<T> nextNode)
    {
        next = nextNode;
    }
}
