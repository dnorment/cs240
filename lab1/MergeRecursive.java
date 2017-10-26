import java.util.Random;

/**
 * A recursive implementation of the merge sort algorithm.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class MergeRecursive
{
    public static void sort(int[] array, int left, int right)
    {
        if (left < right) //size > 1
        {
            int mid = (left + right) / 2;
            sort(array, left, mid);
            sort(array, mid+1, right);
            merge(array, left, mid, right);
        }
    }
        
    public static void merge(int[] array, int left, int mid, int right)
    {
        int[] leftArray = new int[mid - left + 1]; //size of each array to merge
        int[] rightArray = new int[right - mid]; 
        
        for (int i=0; i<mid-left+1; i++) //copy subarrays to temp arrays
        {
            leftArray[i] = array[left + i]; 
        }
        for (int i=0; i<right-mid; i++)
        {
            rightArray[i] = array[mid+1 + i];
        }
        
        int i=0; //index of left array
        int j=0; //index of right array
        int k=left; //index of beginning of effective array
        while (i < leftArray.length && j < rightArray.length)
        {
            if (leftArray[i] < rightArray[j])
            {
                array[k] = leftArray[i]; //insert item from left array
                i++;
            }
            else
            {
                array[k] = rightArray[j]; //insert item from right array
                j++;
            }
            k++;
        }
        //will only exit above loop if one array inserts all of its elements, so add rest of other array
        while (i < leftArray.length) //insert remaining of left array
        {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightArray.length) //insert remaining of right array
        {
            array[k] = rightArray[j];
            j++;
            k++;
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
        MergeRecursive.sort(sortArray, 0, ARRAY_SIZE-1);
        System.out.println();
        for (int x : sortArray)
        {
            System.out.print(x + " ");
        }
    }
}
