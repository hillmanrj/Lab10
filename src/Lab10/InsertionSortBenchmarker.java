package Lab10;
/**
   The InsertionSortBenchmarker class performs an
	insertion sort on an int array. It keeps count 
	of the number of swaps made.
*/

public class InsertionSortBenchmarker
{
   private int array[];  // The array to sort
   private int numSwaps; // To count the number of swaps made
   private int numComparisons;
   private int numAssignments;
   
   /**
      Constructor
      @param a The array to sort.
   */
   
   public InsertionSortBenchmarker(int a[])
   {
      array = a;
      numSwaps = 0;
      numComparisons = 0;
      numAssignments = 0;
      insertionSort();
   }

   /**
      The insertionSort method performs an insertion sort on
      the array.
   */

   private void insertionSort()
   {
      int unsortedValue;  // The first unsorted value
      int scan;           // Used to scan the array
      
      // The outer loop steps the index variable through 
      // each subscript in the array, starting at 1. This
      // is because element 0 is considered already sorted.
      for (int index = 1; index < array.length; index++)
      {
         // The first element outside the sorted subset is
         // array[index]. Store the value of this element
         // in unsortedValue.
         unsortedValue = array[index];
         numAssignments++;
         
         // Start scan at the subscript of the first element
         // outside the sorted subset.
         scan = index;
         numComparisons++;
         // Move the first element outside the sorted subset
         // into its proper position within the sorted subset.
         while (scan > 0 && array[scan-1] > unsortedValue)
         {
            array[scan] = array[scan - 1];
            numAssignments++;
            scan--;
            numSwaps++;
            numComparisons++;
         }
         
         // Insert the unsorted value in its proper position
         // within the sorted subset.
         array[scan] = unsortedValue;
         numAssignments++;
         // In line 41 we stored array[index] in unsortedValue.
         // Here we just stored unsortedValue in array[scan].
         // We will count those twos steps as one swap.
         numSwaps++;
      }
   }
   
   /**
      The getNumSwaps method returns the number of
      swaps made.
      @return The number of swaps made.
   */
   
   public int getNumSwaps()
   {
      return numSwaps;
   }

   public int getNumComparisons()
   {
      return numComparisons;
   }

   public int getNumAssignments() {
      return numAssignments;
   }
}