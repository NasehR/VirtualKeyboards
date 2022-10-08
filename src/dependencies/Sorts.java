/*
 * Filename: Sorts.java
 * Purpose: Contains different sorting algorithms
 *
 * @author   : Naseh Rizvi
 * StudentNo : 20167671
 * Unit      : DSA
 * Date      : 25/09/22
 * Practical : 01
 */

public class Sorts<T>
{
    /*
     * Sorts a queue by their fCosts using bubble sort
     * 
     * @param A: The queue to be sorted
     * 
     * @return: void.
     */
    public void bubbleSort(DSAQueue<T> A)
    {
        Double temp;
        int pass = 0;
        boolean sorted = false;

        while(!sorted)
        {
            sorted = true;

            for(int i = 0; i < (A.length - 1 - pass); i++)
            {
                if(getVertex(A[i]).compareTo(getVertex(A[i+1])) == 1)
                {
                    temp = A[i];
                    A[i] = A[i+1];
                    A[i+1] = temp;
                    sorted = false;
                }
            }

            pass++;
        }
    }

    /*
     * Sorts a queue by their fCosts using selection sort
     * 
     * @param A: The queue to be sorted
     * 
     * @return: void.
     */
    public void selectionSort(DSAQueue<T> A)
    {
        Double temp;

        for(int i = 0; i < A.length; i++)
        {
            int min = i;

            for(int j = i + 1; j < A.length; j++)
            {
                if(getVertex(A[i]).compareTo(getVertex(A[i+1])) == 1)
                {
                    min = j;
                }
            }

            temp = A[i];
            A[i] = A[min];
            A[min] = temp;
        }
    }

    /* 
     * Sorts a queue by their fCosts using insertion sort
     * 
     * @param A: The queue to be sorted
     * 
     * @return: void.
     */
    public void insertionSort(DSAQueue<T> A)
    {
        Double temp;

        for(int i = 1; i < A.length; i++)
        {
            j = i;
            while(int j > 0 && (getVertex(A[i]).compareTo(getVertex(A[i+1])) == 1))
            {
                temp = A[j].getFCost();
                A[j].getFCost() = A[j-1].getFCost();
                A[j-1].getFCost() = temp;
                j--;
            }
        }
    }
}