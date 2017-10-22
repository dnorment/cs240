import java.util.Random;

/**
 * A recursive implementation of the insertion sort algorithm.
 *
 * @author Daniel J. Norment
 */
public class InsertionRecursive
{
    public static void sort(int[] array, int first, int last)
    {
        if (first < last)
        {
            sort(array, first, last-1); //insert up to last
            insert(array[last], array, first, last-1); //insert last
        }
    }
    
    public static void insert(int value, int[] array, int first, int last)
    {
        if (value >= array[last]) //value is highest
        {
            array[last+1] = value; //put at end
        }
        else if (first < last) //array length >= 1
        {
            array[last+1] = array[last]; //make space for insert
            insert(value, array, first, last-1); //insert when enough space
        }
        else
        {
            array[last+1] = array[last]; 
            array[last] = value; //insert at last
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
        InsertionRecursive.sort(sortArray, 0, ARRAY_SIZE-1);
        System.out.println();
        for (int x : sortArray)
        {
            System.out.print(x + " ");
        }
    }
}
