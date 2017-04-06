package Lab10;
/**
   The SelectionSortBenchmarker class performs a 
	selection sort on an int array. It keeps count 
	of the number of swaps made.
   Code taken from textBook ARCHIVE
*/

public class SelectionSortBenchmarker
{
   private int array[];  // The array to sort
   private int numSwaps; // To count the number of swaps made
   private int numComparisons;
    private int numAssignments;
   
   /**
      Constructor
      @param a The array to sort.
   */
   
   public SelectionSortBenchmarker(int a[])
   {
      array = a;
      numSwaps = 0;
      numComparisons = 0;
      numAssignments = 0;
      selectionSort();
   }


   /**
      The selectionSort method performs a selection sort on
      the array.
   */

   private void selectionSort()
   {
      int startScan;   // Starting position of the scan
      int index;       // To hold a subscript value
      int minIndex;    // Element with smallest value in the scan
      int minValue;    // The smallest value found in the scan

      // The outer loop iterates once for each element in the
      // array. The startScan variable marks the position where
      // the scan should begin.
      for (startScan = 0; startScan < (array.length-1); startScan++)
      {
         // Assume the first element in the scannable area
         // is the smallest value.
         minIndex = startScan;
         minValue = array[startScan];
         numAssignments++;
         
         // Scan the array, starting at the 2nd element in
         // the scannable area. We are looking for the smallest
         // value in the scannable area. 
         for(index = startScan + 1; index < array.length; index++)
         {
            numComparisons++;
            if (array[index] < minValue)
            {
               minValue = array[index];
               numAssignments++;
               minIndex = index;
            }
         }

         // Swap the element with the smallest value 
         // with the first element in the scannable area.
         array[minIndex] = array[startScan];
         array[startScan] = minValue;
            numAssignments++;
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