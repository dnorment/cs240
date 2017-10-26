import java.util.Random;

/**
 * An iterative implementation of the insertion sort algorithm.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class InsertionIterative
{
    public static void sort(int[] array)
    {
        for (int i=1; i<array.length; i++)
        {
            int val = array[i];
            
            int j = i;
            while (j > 0 && val < array[j-1]) //until hit first or sorted
            {
                array[j] = array[j-1]; //keep making space
                j--;
            }
            array[j] = val;
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
        InsertionIterative.sort(sortArray);
        System.out.println();
        for (int x : sortArray)
        {
            System.out.print(x + " ");
        }
    }
}
