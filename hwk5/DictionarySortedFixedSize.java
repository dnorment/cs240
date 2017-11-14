import java.util.ArrayList;
import java.util.Iterator;
/**
 * An implementation of the ADT Dictionary using a sorted array.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class DictionarySortedFixedSize<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V>
{
     public static final int MAX_SIZE = 10;
     private K[] dictKeys;
     private V[] dictValues;
     private int numOfPairs;
    
     public DictionarySortedFixedSize()
     {
        @SuppressWarnings("unchecked")
        K[] tempKeys = (K[])new Comparable[MAX_SIZE];
        @SuppressWarnings("unchecked")
        V[] tempVals = (V[])new Comparable[MAX_SIZE];
        dictKeys = tempKeys;
        dictValues = tempVals;
        numOfPairs = 0;
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
            for (int i=0; i<dictKeys.length; i++)
            {
                if (dictKeys[i] == key)
                {
                    tempVal = dictValues[i];
                    dictValues[i] = value;
                }
            }
            return tempVal;
        }
        else
        {
            if (isEmpty())
            {
                dictKeys[0] = key;
                dictValues[0] = value;
            }
            else
            {
                int index = 0;
                while (dictKeys[index] != null && key.compareTo(dictKeys[index]) > 0)
                {
                    index++;
                }
                if (dictKeys[index] == null)
                {
                    dictKeys[index] = key;
                    dictValues[index] = value;
                }
                else
                {
                    for (int i=numOfPairs; i > index; i--)
                    {
                        dictKeys[i] = dictKeys[i-1];
                        dictValues[i] = dictValues[i-1];
                    }
                    dictKeys[index] = key;
                    dictValues[index] = value;                    
                }
            }
            numOfPairs++;
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
             for (int i=0; i<numOfPairs; i++)
             {
                 if (dictKeys[i].equals(key))
                 {
                     if (i == numOfPairs - 1) //key at end
                     {
                         dictKeys[i] = null;
                         dictValues[i] = null;
                     }
                     else //key has keys after itself, so move them down 1
                     {
                         for (int j=i; j<numOfPairs-1; j++)
                         {
                             dictKeys[j] = dictKeys[j+1];
                             dictValues[j] = dictValues[j+1];
                         }
                         dictKeys[numOfPairs-1] = null;
                         dictValues[numOfPairs-1] = null;
                     }
                     numOfPairs--;
                 }
             }
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
         if (contains(key))
         {
             V tempVal = null;
             for (int i=0; i<numOfPairs; i++)
             {
                if (dictKeys[i].equals(key))
                {
                    tempVal = dictValues[i];
                }
             }
             return tempVal;
         }
         else
         {
             return null;
         }
     }
   
     /** Sees whether a specific entry is in this dictionary.
       @param key  An object search key of the desired entry.
       @return  True if key is associated with an entry in the dictionary. */
     public boolean contains(K key)
     {
         boolean contains = false;
         for (int i=0; i<numOfPairs; i++)
         {
             if (dictKeys[i].equals(key))
             {
                 contains = true;
             }
         }
         return contains;
     }
   
     /** Creates an iterator that traverses all search keys in this dictionary.
       @return  An iterator that provides sequential access to the search
                keys in the dictionary. */
     public Iterator<K> getKeyIterator()
     {
        ArrayList<K> list = new ArrayList<K>();
        for (int i=0; i<numOfPairs; i++)
        {
            list.add(dictKeys[i]);
        }
        return list.iterator();
     }
   
     /** Creates an iterator that traverses all values in this dictionary.
       @return  An iterator that provides sequential access to the values
                in this dictionary. */
     public Iterator<V> getValueIterator()
     {
        ArrayList<V> list = new ArrayList<V>();
        for (int i=0; i<numOfPairs; i++)
        {
            list.add(dictValues[i]);
        }
        return list.iterator();
     }
   
     /** Sees whether this dictionary is empty.
       @return  True if the dictionary is empty. */
     public boolean isEmpty()
     {
         return numOfPairs == 0;
     }
   
     /** Gets the size of this dictionary.
       @return  The number of entries (key-value pairs) currently
                in the dictionary. */
     public int getSize()
     {
         return numOfPairs;
     }
   
     /** Removes all entries from this dictionary. */
     public void clear()
     {
         for (int i=0; i<dictKeys.length; i++)
         {
             dictKeys[i] = null;
             dictValues[i] = null; //will be same length always
         }
         numOfPairs = 0;
     }
}
