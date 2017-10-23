import java.util.ArrayList;
import java.util.Random;

/**
 * An iterative implementation of the radix sort algorithm.
 *
 * @author Daniel J. Norment
 */
public class RadixIterative
{
    public static void sort(int[] array)
    {
        final int ARRAY_SIZE = 10;
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] bucket = (ArrayList<Integer>[])new ArrayList[ARRAY_SIZE];
        for (int i=0; i<bucket.length; i++)
        {
            bucket[i] = new ArrayList<Integer>(ARRAY_SIZE);
        }
        for (int pow=1; pow<1000; pow*=10)
        {
            for (int i=0; i<array.length; i++)
            {
                bucket[array[i]/pow % 10].add(array[i]);
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
        RadixIterative.sort(sortArray);
        System.out.println();
        for (int x : sortArray)
        {
            System.out.print(x + " ");
        }
    }
}
