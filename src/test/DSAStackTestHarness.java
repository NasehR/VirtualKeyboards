package test;

import java.util.*;
import main.dependency.DSAStack;

public class DSAStackTestHarness 
{
    public static void main(String[] args)
    {
        System.out.println("\nTesting DSAStack...");
        
        testDefault();
        testGetCount();
        testIsEmpty();
        testPush();
        testPop();
        testTop();
    }

    public static void testDefault()
    {
        System.out.print("\tTesting Default Constructor: ");

        DSAStack<Object> stack = new DSAStack<>();

        assert stack.getCount() == 0 : "The count should be 0";
        assert stack.isEmpty() : "The stack should be empty";

        System.out.println("\tpassed.");
    } 


    public static void testGetCount()
    {
        System.out.print("\tTesting getCount: ");

        int[] count = {1, 2, 3, 4, 5};
        //double value = 5;
        Object condition;

        DSAStack<Object> stack = new DSAStack<>();

        for(int i = 0; i < count.length; i++)
        {
            stack.push(count[i]);

            condition = stack.top();
            assert stack.getCount() == count[i] : "The count should be " + count[i];
            assert condition.equals(count[i]) : "The top value should be " + count[i];
        }

        System.out.println("\t\tpassed.");
    }

    public static void testIsEmpty()
    {
        System.out.print("\tTesting isEmpty: ");

        int[] count = {1, 2, 3};
        //double value = 3;
        //Object condition;
        DSAStack<Object> stack = new DSAStack<>();

        assert stack.isEmpty() : "The stack should initially be empty";
        stack.push(count[0]);
        assert !(stack.isEmpty()) : "The stack should not be empty";
        stack.push(count[1]);
        stack.push(count[2]);
        assert !(stack.isEmpty()) : "The stack should be full";

        System.out.println("\t\tpassed.");
        
    }

    public static void testPush()
    {
        System.out.print("\tTesting push: ");
        
        int[] count = {1, 2, 3, 4, 5};
        //double value = 5;
        Object condition;
        DSAStack<Object> stack = new DSAStack<>();
        
        for(int i = 0; i < count.length; i++)
        {
            stack.push(count[i]);
            condition = stack.top();
            assert stack.getCount() == count[i] : "The count should be " + count[i];
            assert condition.equals(count[i]) : "The top value should be " + count[i];
        }
        
        System.out.println("\t\t\tpassed.");
    }

    public static void testPop()
    {
        System.out.print("\tTesting pop: ");
        
        int[] count = {1, 2, 3, 4, 5};
        //double value = 5;
        Object condition;
        DSAStack<Object> stack = new DSAStack<>();
        
        for(int i = 0; i < count.length; i++)
        {
            stack.push(count[i]);
            condition = stack.top();
            assert stack.getCount() == count[i] : "The count should be " + count[i];
            assert condition.equals(count[i]) : "The top value should be " + count[i];
        }
        
        for(int i = 0; i < count.length; i++)
        {
            condition = stack.pop();
            assert stack.getCount() == count.length - i - 1 : "The count should be " + (count.length - i - 1);
            assert condition.equals(count[i]) : "The top value should be " + count[i];
        }
        
        System.out.println("\t\t\tpassed.");
    }

    public static void testTop()
    {
        System.out.print("\tTesting top: ");

        int[] count = {1, 2, 3, 4, 5};
        //double value = 5;
        Object condition;
        DSAStack<Object> stack = new DSAStack<>();

        stack.push(count[4]);
        stack.push(count[3]);
        stack.push(count[2]);
        stack.push(count[1]);
        stack.push(count[0]);

        for(int i = 0; i < count.length; i++)
        {
            condition = stack.top();
            assert condition.equals(count[i]) : "The top value should be " + count[i];
            stack.pop();
        }

        try
        {
            stack.top();
        }

        catch(IllegalStateException ex)
        {
            System.out.println("\t\t\tpassed.");
        }
    }
}
