import java.util.ArrayList;
import java.util.Random;

/**
 * A recursive implementation of the radix sort algorithm.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class RadixRecursive
{
    public static void sort(int[] array, int place)
    {
        if (place <= 1000)
        {
            final int ARRAY_SIZE = 10;
            @SuppressWarnings("unchecked")
            ArrayList<Integer>[] bucket = (ArrayList<Integer>[])new ArrayList[ARRAY_SIZE];
            for (int i=0; i<bucket.length; i++)
            {
                bucket[i] = new ArrayList<Integer>(ARRAY_SIZE);
            }
            for (int i=0; i<array.length; i++)
            {
                bucket[array[i]/place % 10].add(array[i]);
            }
            int next = 0;
            for (int i=0; i<array.length; i++)
            {
                for (int j=0; j<bucket[i].size(); j++)
                {
                    array[next] = bucket[i].get(j);
                    next++;
                }
                bucket[i].clear();
            }
            sort(array, place*=10);
        }
    }
    
    public static void main(String[] args)
    {
        final int ARRAY_SIZE = 10;
        
        int[] sortArray = new int[ARRAY_SIZE];
        Random rng = new Random();
        for (int i=0; i<sortArray.length; i++)
        {
            sortArray[i] = rng.nextInt(100);
        }
        
        for (int x : sortArray)
        {
            System.out.print(x + " ");
        }
        RadixRecursive.sort(sortArray, 1);
        System.out.println();
        for (int x : sortArray)
        {
            System.out.print(x + " ");
        }
    }
}
