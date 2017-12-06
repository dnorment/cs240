import java.util.ArrayList;
import java.util.Iterator;
/**
 * An implementation of the ADT Dictionary using sorted linked data (each node with reference to a key and next node).
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class DictionarySortedLinked<K extends Comparable<K>, V> implements DictionaryInterface<K, V>
{
    private int numOfNodes;
    private KVNode<K, V> head;
    private KVNode<K, V> tail;
    
    public DictionarySortedLinked()
    {
        head = null;
        tail = null;
        numOfNodes = 0;
    }
    
    /** Adds a new entry to this dictionary. If the given search key already
       exists in the dictionary, replaces the corresponding value.
       @param key    An object search key of the new entry.
       @param value  An object associated with the search key.
       @return  Either null if the new entry was added to the dictionary
                or the value that was associated with key if that value
                was replaced. */
    public V add(K key, V value)
    {
       if (contains(key))
       {
           V tempVal = null;
           KVNode<K, V> thisNode = tail;
           while (thisNode != null)
           {
               if (thisNode.getKey().equals(key))
               {
                   tempVal = thisNode.getValue();
                   thisNode.setValue(value);
               }
               thisNode = thisNode.getNext();
           }
           return tempVal;
       }
       else
       {
            KVNode<K, V> newNode = new KVNode<K, V>(key, value);
            if (isEmpty())
            {
                head = newNode;
                tail = newNode;
            }
            else if (numOfNodes == 1)
            {
                if (key.compareTo(tail.getKey()) < 0) //key lower than existing
                {
                    newNode.setNext(tail);
                    tail = newNode;
                }
                else //key higher
                {
                    head.setNext(newNode);
                    head = newNode;
                }
            }
            else
            {
                KVNode<K, V> thisNode = tail;
                if (key.compareTo(tail.getKey()) < 0) //belongs at front
                {
                    newNode.setNext(tail);
                    tail = newNode;
                    numOfNodes++;
                    return null;
                }
                while (thisNode.getNext() != null && key.compareTo(thisNode.getKey()) > 0)
                //while not at end and this key higher
                {
                    thisNode = thisNode.getNext();
                }
                if (thisNode.getNext() == null && key.compareTo(thisNode.getKey()) > 0) 
                //node belongs at end
                {
                    thisNode.setNext(newNode);
                    head = newNode;
                }
                else //node other place
                {
                    KVNode<K, V> beforeNode = tail;
                    while (beforeNode.getNext() != thisNode)
                    {
                        beforeNode = beforeNode.getNext();
                    }
                    newNode.setNext(thisNode);
                    beforeNode.setNext(newNode);
                }
            }
            numOfNodes++;
            return null;
       }
    }
   
    /** Removes a specific entry from this dictionary.
       @param key  An object search key of the entry to be removed.
       @return  Either the value that was associated with the search key
                or null if no such object exists. */
    public V remove(K key)
    {
        if (contains(key))
        {
            V tempVal = getValue(key);
            if (numOfNodes == 1)
            {
                tail.setValue(null);
                tail.setKey(null);
                head = null;
                tail = null;
            }
            else if (numOfNodes == 2)
            {
                if (tail.getKey().equals(key)) //remove tail
                {
                    tail.setValue(null);
                    tail.setKey(null);
                    tail.setNext(null);
                    tail = head;
                }
                else //remove head
                {
                    head.setValue(null);
                    head.setKey(null);
                    tail.setNext(null);
                    head = tail;
                }
            }
            else
            {
                KVNode<K, V> beforeNode = tail;
                KVNode<K, V> rmNode = tail.getNext();
                while (rmNode.getNext() != null && !rmNode.getKey().equals(key))
                {
                    beforeNode = beforeNode.getNext();
                    rmNode = rmNode.getNext();
                }
                if (rmNode == head)
                {
                    rmNode.setValue(null);
                    rmNode.setKey(null);
                    beforeNode.setNext(null);
                    head = beforeNode;
                }
                else //if (rmNode.getKey().equals(key))
                {
                    rmNode.setValue(null);
                    rmNode.setKey(null);
                    beforeNode.setNext(rmNode.getNext());
                    rmNode.setNext(null);
                }
                /*else
                {
                    
                }*/
            }
            numOfNodes--;
            return tempVal;
        }
        else
        {
            return null;
        }
    }
   
    /** Retrieves from this dictionary the value associated with a given
       search key.
       @param key  An object search key of the entry to be retrieved.
       @return  Either the value that is associated with the search key
                or null if no such object exists. */
    public V getValue(K key)
    {
        V tempVal = null;
        KVNode<K, V> thisNode = tail;
        while (thisNode != null)
        {
            if (thisNode.getKey().equals(key))
            {
                tempVal = thisNode.getValue();
            }
            thisNode = thisNode.getNext();
        }
        return tempVal;
    }
   
    /** Sees whether a specific entry is in this dictionary.
       @param key  An object search key of the desired entry.
       @return  True if key is associated with an entry in the dictionary. */
    public boolean contains(K key)
    {
        boolean contains = false;
        KVNode<K, V> thisNode = tail;
        while (thisNode != null)
        {
            if (thisNode.getKey().equals(key))
            {
                contains = true;
            }
            thisNode = thisNode.getNext();
        }
        return contains; 
    }
   
    /** Creates an iterator that traverses all search keys in this dictionary.
       @return  An iterator that provides sequential access to the search
                keys in the dictionary. */
    public Iterator<K> getKeyIterator()
    {
        ArrayList<K> list = new ArrayList<K>();
        KVNode<K, V> thisNode = tail;
        do
        {
            if (!isEmpty())
            {
                list.add(thisNode.getKey());
                thisNode = thisNode.getNext();
            }
        } while (thisNode != null && thisNode.getNext() != null);
        return list.iterator();
    }
   
    /** Creates an iterator that traverses all values in this dictionary.
       @return  An iterator that provides sequential access to the values
                in this dictionary. */
    public Iterator<V> getValueIterator()
    {
        ArrayList<V> list = new ArrayList<V>();
        KVNode<K, V> thisNode = tail;
        do
        {
            list.add(thisNode.getValue());
            thisNode = thisNode.getNext();
        } while (thisNode.getNext() != null);
        return list.iterator();
    }
   
    /** Sees whether this dictionary is empty.
       @return  True if the dictionary is empty. */
    public boolean isEmpty()
    {
        return head == null && tail == null;
    }
   
    /** Gets the size of this dictionary.
       @return  The number of entries (key-value pairs) currently
                in the dictionary. */
    public int getSize()
    {
        return numOfNodes;
    }
   
    /** Removes all entries from this dictionary. */
    public void clear()
    {
       if (!isEmpty())
       {
           KVNode<K, V> lastNode = tail;
           while (lastNode.getNext() != null)
           {
               lastNode.setKey(null);
               lastNode.setValue(null);
               KVNode<K, V> nextNode = lastNode.getNext();
               lastNode.setNext(null);
               lastNode = nextNode;
           }
           head.setKey(null);
           head.setValue(null);
           head.setNext(null);
           head = null;
           tail = null;
           numOfNodes = 0;
       }
    }
}
