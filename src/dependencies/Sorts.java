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

public class Sorts
{
    public void bubbleSort(DSAQueue<DSAGraph.DSAGraphVertex> A)
    {
        Double temp;
        int pass = 0;
        boolean sorted = false;

        while(!sorted)
        {
            sorted = true;

            for(int i = 0; i < (A.length - 1 - pass); i++)
            {
                if(A[i].getFCost() > A[i+1].getFCost())
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

    public void selectionSort(DSAQueue A)
    {
        Double temp;

        for(int i = 0; i < A.length; i++)
        {
            int min = i;

            for(int j = i + 1; j < A.length; j++)
            {
                if(A[j].getFCost() < A[min].getFCost())
                {
                    min = j;
                }
            }

            temp = A[i];
            A[i] = A[min];
            A[min] = temp;
        }
    }

    public void insertionSort(DSAQueue A)
    {
        Double temp;

        for(int i = 1; i < A.length; i++)
        {
            j = i;
            while(int j > 0 && A[j].getFCost() < A[j-1].getFCost())
            {
                temp = A[j].getFCost();
                A[j].getFCost() = A[j-1].getFCost();
                A[j-1].getFCost() = temp;
                j--;
            }
        }
    }
}