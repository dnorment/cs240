import java.util.Random;

/**
 * A recursive implementation of the quick sort algorithm.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class QuickRecursive
{
    public static void sort(int[] array, int first, int last)
    {
        if (first < last)
        {
            int pivot = partition(array, first, last); //leave partition alone, sort about it
            //elements to each side of pivot will be less than and greater than / =, so sort each side
            sort(array, first, pivot - 1);
            sort(array, pivot + 1, last);
        }
    }
    
    public static int partition(int[] array, int first, int last)
    {
        int pivot = array[last]; //last element as pivot
        int i = first - 1;
        for (int j=first; j<last; j++) //effective subarray
        {
            if (array[j] <= pivot)
            {
                int temp = array[++i]; //swap if elements to right of pivot are less than pivot
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i+1]; //swap i+1 element and pivot then return its index
        array[i+1] = array[last];
        array[last] = temp;
        
        return i+1;
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
        QuickRecursive.sort(sortArray, 0, sortArray.length-1);
        System.out.println();
        for (int x : sortArray)
        {
            System.out.print(x + " ");
        }
    }
}
