package test;

import java.util.*;
import dependencies.DSAQueue;

public class UnitTestQueue 
{
    public static void main(String[] args)
    {
        System.out.println("\nTesting DSAQueue...");

        testDefault();
        testAlternate();
        testGetCount();
        testIsEmpty();
        testIsFull();
        testEnqueue();
        testDequeue();
        testPeek();
    }

    public static void testDefault()
    {
        System.out.print("\tTesting Default Constructor: ");
        
        DSAQueue<Object> queue = new DSAQueue<>();

        assert queue.getCount() == 0 : "The count should be 0";
        assert queue.isEmpty() : "The queue should be empty";
        
        System.out.println("\tpassed.");
    }

    public static void testAlternate()
    {
        System.out.print("\tTesting Alternate Constructor: ");
        
        DSAQueue<Object> queue = new DSAQueue<>(2);

        assert queue.getCount() == 0 : "The count should be 0";
        assert queue.isEmpty() : "The queue should be empty";

        try
        {
            DSAQueue<Object> newQueue = new DSAQueue<>(-5);
        }

        catch(IllegalArgumentException ex)
        {
            System.out.println("\tpassed.");
        }
    }

    public static void testGetCount()
    {
        System.out.print("\tTesting getCount: ");
        
        int[] count = {1,2};
        double value = 2;

        DSAQueue<Object> queue = new DSAQueue<>(2);

        for(int i = 0; i < count.length; i++)
        {
            queue.enqueue(value);
            assert queue.getCount() == count[i] : "The count should be " + count[i];
        }

        System.out.println("\t\tpassed.");
    }

    public static void testIsEmpty()
    {
        System.out.print("\tTesting isEmpty: ");
        
        int[] count = {1, 2};
        double value = 2;

        DSAQueue<Object> queue = new DSAQueue<>(2);
        assert queue.isEmpty() : "The queue should initially be empty";
        queue.enqueue(value);

        assert !(queue.isEmpty()) : "The queue should not be empty";
        queue.enqueue(value);

        assert queue.isFull() : "The queue should be full";
        System.out.println("\t\tpassed.");
    }

    public static void testIsFull()
    {
        System.out.print("\tTesting isFull: ");
        
        int[] count = {1, 2};
        double value = 2;

        DSAQueue<Object> queue = new DSAQueue<>(2);
        assert !(queue.isFull()) : "The queue should initially be empty";
        queue.enqueue(value);

        assert !(queue.isFull()) : "The queue should not be empty";
        queue.enqueue(value);

        assert queue.isFull() : "The queue should be full";
        System.out.println("\t\tpassed.");
    }

    public static void testEnqueue()
    {
        System.out.print("\tTesting enqueue: ");

        int[] item = {1, 2, 3, 4, 5};
        Object condition;

        DSAQueue<Object> queue = new DSAQueue<>(4);

        queue.enqueue(item[0]);
        condition = queue.peek();
        assert condition.equals(item[0]) : "The peek should be " + item[0];
        condition = queue.dequeue();
        assert condition.equals(item[0]) : "The peek should be " + item[0];

        queue.enqueue(item[1]);
        condition = queue.peek();
        assert condition.equals(item[1]) : "The peek should be " + item[1];
        condition = queue.dequeue();
        assert condition.equals(item[1]) : "The peek should be " + item[1];

        try
        {
            for(int i = 0; i < item.length; i++)
            {
                queue.enqueue(item[i]);
                condition = queue.peek();
                assert condition.equals(1) : "Top should be the first one pushed";
            }
        }
        catch(IllegalStateException ex)
        {
            System.out.println("\t\tpassed.");
        }

    }

    public static void testDequeue()
    {
        System.out.print("\tTesting dequeue: ");

        int[] item = {1, 2, 3, 4, 5};
        Object condition;
        DSAQueue<Object> queue = new DSAQueue<>(5);

        //Remove from the queue
        queue.enqueue(item[0]);
        condition = queue.dequeue();
        assert condition.equals(item[0]) : "The peek should be " + item[0];
        assert queue.isEmpty() : "The queue should be empty";

        //Tesing the wrap around and removing from the queue
        queue.enqueue(item[0]);
        queue.enqueue(item[1]);
        queue.enqueue(item[2]);
        queue.enqueue(item[3]);
        queue.enqueue(item[4]);

        condition = queue.dequeue();
        assert condition.equals(item[0]) : item[0] + " should have been dequeued";
        condition = queue.dequeue();
        assert condition.equals(item[1]) : item[1] + " should have been dequeued";
        condition = queue.dequeue();
        assert condition.equals(item[2]) : item[2] + " should have been dequeued";
        condition = queue.dequeue();
        assert condition.equals(item[3]) : item[3] + " should have been dequeued";


        queue.enqueue(item[0]);
        queue.enqueue(item[1]);
        queue.enqueue(item[2]);
        queue.enqueue(item[3]);

        condition = queue.dequeue();
        assert condition.equals(item[4]) : item[4] + " should have been dequeued";
        condition = queue.peek();
        assert condition.equals(item[0]) : "The peek should be " + item[0];
        condition = queue.dequeue();
        assert condition.equals(item[0]) : item[0] + " should have been dequeued";
        condition = queue.dequeue();
        assert condition.equals(item[1]) : item[1] + " should have been dequeued";
        condition = queue.dequeue();
        assert condition.equals(item[2]) : item[2] + " should have been dequeued";
        condition = queue.dequeue();
        assert condition.equals(item[3]) : item[3] + " should have been dequeued";

        queue.enqueue(item[0]);
        queue.enqueue(item[1]);
        queue.enqueue(item[2]);
        queue.enqueue(item[3]);
        queue.enqueue(item[4]);

        for(int i = 0; i < item.length; i++)
        {
            condition = queue.dequeue();
            assert condition.equals(item[i]) : item[i] + " should have been dequeued";
        }

        try
        {
            assert queue.isEmpty() : "The queue should be empty";
            queue.dequeue();
        } 
        
        catch(NoSuchElementException ex)
        {
            System.out.println("\t\tpassed.");
        }
    }

    
    public static void testPeek()
    {
        System.out.print("\tTesting peek: ");

        int[] item = {1, 2, 3, 4, 5};
        Object condition;
        DSAQueue<Object> queue = new DSAQueue<>(5);

        queue.enqueue(item[0]);
        queue.enqueue(item[1]);
        queue.enqueue(item[2]);
        queue.enqueue(item[3]);
        queue.enqueue(item[4]);

        for(int i = 0; i < item.length; i++)
        {
            condition = queue.peek();
            assert condition.equals(item[i]) : "The peek should be " + item[i];
            condition = queue.dequeue();
            assert condition.equals(item[i]) : item[i] + " should have been dequeued";
        }

        try
        {
            queue.peek();
        }
        catch(NoSuchElementException ex)
        {
            System.out.println("\t\t\tpassed.");
        }
    }
    
}
