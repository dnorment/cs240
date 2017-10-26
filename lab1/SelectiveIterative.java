import java.util.Random;

/**
 * An iterative implementation of the selective sort algorithm.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class SelectiveIterative
{
    public static void sort(int[] array)
    {
        for (int i=0; i<array.length-1; i++)
        {
            int lowestIndex = i;
            for (int j=i; j<array.length; j++)
            {
                if (array[j] < array[lowestIndex])
                {
                    lowestIndex = j;
                }
            }
            int lowestVal = array[lowestIndex];
            array[lowestIndex] = array[i];
            array[i] = lowestVal;
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
        SelectiveIterative.sort(sortArray);
        System.out.println();
        for (int x : sortArray)
        {
            System.out.print(x + " ");
        }
    }
}
