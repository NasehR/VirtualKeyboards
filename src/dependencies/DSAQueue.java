/*
 * Filename: DSAQueue.java
 * Purpose: Contains the DSAQueue class
 *
 * @author   : Naseh Rizvi
 * StudentNo : 20167671
 * Unit      : DSA
 * Date      : 25/09/22
 * Practical : 04
 */

 package dependencies;

import java.util.*;

public class DSAQueue<T> implements Iterable<T>
{
    //Class fields
    private DSALinkedList<T> queue;
    private int capacity;

    //Constructor
    public DSAQueue()
    {
        queue  = new DSALinkedList<T>();
        capacity = 100;
    }

    //Alternate Constructor
    public DSAQueue(int capacity) throws IllegalArgumentException
    {
        if(capacity < 1)
        {
            throw new IllegalArgumentException("Capacity must be greater than 1");
        }

        queue = new DSALinkedList<T>();
        this.capacity = capacity;
    }

    //Getter Iterator:
    public Iterator<T> iterator()
    {
        return queue.iterator();
    }
    
    //Getter Capacity:
    public int getCount()
    {
        return (queue.getCount());
    }

    //Getter isEmpty:
    public boolean isEmpty()
    {
        return (queue.isEmpty());
    }

    //Getter isFull:
    public boolean isFull()
    {
        return (queue.getCount() == capacity);
    }

    //Setter enqueue:
    public void enqueue(T value) throws IllegalStateException
    {
        if(isFull())
        {
            throw new IllegalStateException("The queue is full.");
        }

        queue.insertLast(value);
    }

    //Setter dequeue:
    public T dequeue() throws NoSuchElementException
    {
        if(isEmpty())
        {
            throw new NoSuchElementException("The queue is empty.");
        }

        return (queue.removeFirst());
    }

    //Getter peek:
    public T peek() throws NoSuchElementException
    {
        if(isEmpty())
        {
            throw new NoSuchElementException("The queue is empty.");
        }
        
        return (queue.peekFirst());
    }
}