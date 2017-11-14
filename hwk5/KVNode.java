
/**
 * A linked node that stores references to the next node, stores key and value, and is comparable by key.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class KVNode<K extends Comparable<K>, V> implements Comparable<KVNode<K, V>>
{
    private K key;
    private V value;
    private KVNode<K, V> next;
    
    public KVNode()
    {
        next = null;
        key = null;
        value = null;
    }
    
    public KVNode(K newKey, V newVal)
    {
        next = null;
        key = newKey;
        value = newVal;
    }

    /** Sets the next node of this node.
     *  @param nextNode  The next node to be set. */
    public void setNext(KVNode<K, V> nextNode)
    {
        next = nextNode;
    }
    
    /** Gets the next node from this node.
     *  @return The next node pointed at by this node. */
    public KVNode<K, V> getNext()
    {
        return next;
    }
    
    /** Sets the key for this node.
     *  @param newKey  The new key to be set. */
    public void setKey(K newKey)
    {
        key = newKey;
    }
    
    /** Gets the key from this node.
     *  @return The key of this node. */    
    public K getKey()
    {
        return key;
    }
    
    /** Sets the value for this node.
     *  @param newVal  The new value to be set. */
    public void setValue(V newVal)
    {
        value = newVal;
    }
    
    /** Gets the data from this node.
     *  @return The data in this node. */
    public V getValue()
    {
        return value;
    }
        
    /** Compares keys between two nodes.
     *  @param other  The node to which to compare this one.
     *  @return -1, 0, or 1 if the key in this node is less than, equal to, or greater than the key in the other node. */
    public int compareTo(KVNode<K, V> other)
    {
        return key.compareTo(other.getKey());
    }
}
