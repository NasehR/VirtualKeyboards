/*
 * Filename: UnitTestLinkedListIterator.java
 * Purpose: 
 *
 * @author   : Naseh Rizvi
 * StudentNo : 20167671
 * Unit      : DSA
 * Date      : 25/09/22
 * Practical : 06
 */

package test;

import java.util.*;
import dependencies.DSALinkedList;

public abstract class UnitTestLinkedListIterator implements Iterable<Object>
{
    public static void main(String[] args)
    {
        System.out.println("\nTesting DSALinkedListIterator...");

        testIteratorConstructor();
        testIterating();
        //testRemove();
    }

    public static void testIteratorConstructor()
    {
        System.out.print("\tTesting Iterator Constructor: ");

        DSALinkedList<Object> linkedList = new DSALinkedList<>();
        Iterator<Object> it = linkedList.iterator();

        assert it != null : "Iterator must exist";

        System.out.println("\t\t\t\tpassed.");
    }

    public static void testIterating()
    {
        System.out.println("\tTesting Iterating: ");

        int[] item = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        DSALinkedList<Object> linkedList = new DSALinkedList<>();
        Iterator<Object> iterator = linkedList.iterator();
        int counter;

        System.out.print("\t\tTesting Iterating with the linked list: ");

        for(int i = 0; i < item.length; i++)
        {
            linkedList.insertLast(item[i]);
        }

        System.out.print("\tpassed. \n");
        System.out.print("\t\tUsing for each: ");

        counter = 9;
        for(Object data : linkedList)
        {
            assert data.equals(item[counter]) : "The value should be " + item[counter];
            counter--;
        }

        System.out.print("\t\t\t\tpassed. \n");

        System.out.print("\t\tUsing iterator directly using while: ");

        iterator = linkedList.iterator();
        counter = 9;

        while(iterator.hasNext())
        {
            Object data = iterator.next();
            assert data.equals(item[counter]) : "The value should be " + item[counter];
            counter--;
        }

        System.out.println("\t\tpassed.");
    }
}