import java.util.Random;

/**
 * A recursive implementation of the selective sort algorithm.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class SelectiveRecursive
{
    public static void sort(int[] array, int index, int last)
    {
        if (index == last)
        {
            return; //last value already sorted
        }
        else
        {
            int lowestIndex = index;
            for (int i=index; i<array.length; i++)
            {
                if (array[i] < array[lowestIndex])
                {
                    lowestIndex = i;
                }
            }
            int lowestVal = array[lowestIndex];
            array[lowestIndex] = array[index];
            array[index] = lowestVal;
            sort(array, index+1, last);
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
        SelectiveRecursive.sort(sortArray, 0, ARRAY_SIZE-1);
        System.out.println();
        for (int x : sortArray)
        {
            System.out.print(x + " ");
        }
    }
}
