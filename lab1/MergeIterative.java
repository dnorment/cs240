import java.util.Random;

/**
 * An iterative implementation of the merge sort algorithm.
 *
 * @author Daniel J. Norment
 * @version 1.1
 */
public class MergeIterative
{
<<<<<<< HEAD
    public static int countMove=0;
    public static int countCompare=0;
=======
>>>>>>> 5be5898353b8a27291670afcfaeda1b72b6ceb11
    public static void sort(int[] array)
    {
        for (int i=1; i<array.length; i*=2) //look thru subarrays of size 2^n
        {
            for (int j=0; i+j<array.length; j+=i*2) //merge those subarrays, loop for each one
            {
                merge(array, j, i+j-1, Math.min((j+ 2*i -1), array.length-1));
            }
        }
    }
        
    public static void merge(int[] array, int left, int mid, int right)
    {
        int[] leftArray = new int[mid - left + 1]; //size of each array to merge
        int[] rightArray = new int[right - mid]; 
        
        for (int i=0; i<mid-left+1; i++) //copy subarrays to temp arrays
        {
            leftArray[i] = array[left + i]; 
<<<<<<< HEAD
            countMove++;
            countCompare++;
=======
>>>>>>> 5be5898353b8a27291670afcfaeda1b72b6ceb11
        }
        for (int i=0; i<right-mid; i++)
        {
            rightArray[i] = array[mid+1 + i];
<<<<<<< HEAD
            countMove++;
            countCompare++;
=======
>>>>>>> 5be5898353b8a27291670afcfaeda1b72b6ceb11
        }
        
        int i=0; //index of left array
        int j=0; //index of right array
        int k=left; //index of beginning of effective array
        while (i < leftArray.length && j < rightArray.length)
        {
<<<<<<< HEAD
            countCompare+=2;
            if (leftArray[i] < rightArray[j])
            {
                array[k++] = leftArray[i++]; //insert item from left array
                countCompare++;
                countMove++;
=======
            if (leftArray[i] < rightArray[j])
            {
                array[k++] = leftArray[i++]; //insert item from left array
>>>>>>> 5be5898353b8a27291670afcfaeda1b72b6ceb11
            }
            else
            {
                array[k++] = rightArray[j++]; //insert item from right array
<<<<<<< HEAD
                countCompare++;
                countMove++;
=======
>>>>>>> 5be5898353b8a27291670afcfaeda1b72b6ceb11
            }
        }
        //will only exit above loop if one array inserts all of its elements, so add rest of other array
        while (i < leftArray.length) //insert remaining of left array
        {
            array[k++] = leftArray[i++];
<<<<<<< HEAD
            countMove++;
=======
>>>>>>> 5be5898353b8a27291670afcfaeda1b72b6ceb11
        }
        while (j < rightArray.length) //insert remaining of right array
        {
            array[k++] = rightArray[j++];
<<<<<<< HEAD
            countMove++;
=======
>>>>>>> 5be5898353b8a27291670afcfaeda1b72b6ceb11
        }
    }
    
    public static void main(String[] args)
    {
<<<<<<< HEAD
        final int ARRAY_SIZE = 1000;
=======
        final int ARRAY_SIZE = 10;
>>>>>>> 5be5898353b8a27291670afcfaeda1b72b6ceb11
        
        int[] sortArray = new int[ARRAY_SIZE];
        Random rng = new Random();
        for (int i=0; i<sortArray.length; i++)
        {
<<<<<<< HEAD
            sortArray[i] = rng.nextInt(1000);
=======
            sortArray[i] = rng.nextInt(100);
>>>>>>> 5be5898353b8a27291670afcfaeda1b72b6ceb11
        }
        
        for (int x : sortArray)
        {
            System.out.print(x + " ");
        }
        MergeIterative.sort(sortArray);
        System.out.println();
        for (int x : sortArray)
        {
            System.out.print(x + " ");
        }
<<<<<<< HEAD
        System.out.println(countMove + " moves");
        System.out.println(countCompare + " compares");
=======
>>>>>>> 5be5898353b8a27291670afcfaeda1b72b6ceb11
    }
}
