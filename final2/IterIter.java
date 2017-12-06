import java.util.Iterator;

/**
 * An iterator of iterators which traverses through an arbitrary number of iterators.
 * @author Daniel J. Norment
 */
public class IterIter<T extends Iterator<T>>
{
    @SuppressWarnings("unchecked")
    private T[] iters = (T[])new Object[3];
    private int current;
    private T iterator;
    
    public IterIter()
    {
        
    }
    
    public boolean hasNext()
    {
        return false;
    }
    
    public T next()
    {
        iterator = iters[++current];
        return iterator;
    }
}