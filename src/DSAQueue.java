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

import java.util.*;

public class DSAQueue<T> implements Iterable<T>
{
    // Class fields
    private DSALinkedList<T> queue;

    // Constructor
    public DSAQueue()
    {
        queue  = new DSALinkedList<T>();
    }

    /*
     * Iterates through the queue.
     * 
     * @param: void.
     * 
     * @return: Iterator<T>.
     */
    public Iterator<T> iterator()
    {
        return queue.iterator();
    }
    
    /*
     * Gets the length of the queue.
     * 
     * @param: void.
     * 
     * @return: int.
     */
    public int getCount()
    {
        return (queue.getCount());
    }

    /*
     * Checks if the queue is empty.
     * 
     * @param: void.
     * 
     * @return: boolean.
     */
    public boolean isEmpty()
    {
        return (queue.isEmpty());
    }

    /*
     * Enqueues the value to the queue.
     * 
     * @param: value.
     * 
     * @return: void.
     */
    public void enqueue(T value)
    {
        queue.insertLast(value);
    }

    /*
     * Dequeues the value from the queue.
     * 
     * @param: void.
     * 
     * @return: T.
     *
     * @throws NoSuchElementException: Queue is empty.
     */    
    public T dequeue() throws NoSuchElementException
    {
        if(isEmpty())
        {
            throw new NoSuchElementException("The queue is empty.");
        }

        return (queue.removeFirst());
    }

    /*
     * Gets the value at the start of the queue.
     * 
     * @param: void.
     * 
     * @return: T.
     * 
     * @throws NoSuchElementException: Queue is empty.
     */
    public T peek() throws NoSuchElementException
    {
        if(isEmpty())
        {
            throw new NoSuchElementException("The queue is empty.");
        }
        
        return (queue.peekFirst());
    }
}