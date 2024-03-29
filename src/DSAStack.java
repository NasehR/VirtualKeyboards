/*
 * Filename: DSAStack.java
 * Purpose: Contains the DSAStack class
 *
 * @author   : Naseh Rizvi
 * StudentNo : 20167671
 * Unit      : DSA
 * Date      : 25/09/22
 * Practical : 04
 */

import java.util.*;

public class DSAStack<T>
{
    //Class fields
    private DSALinkedList<T> stack;

    // Constructor
    public DSAStack()
    {
        stack = new DSALinkedList<T>();
    }

    /*
     * Iterates through the stack.
     * 
     * @param: void.
     * 
     * @return: Iterator<T>.
     */    
    public Iterator<T> iterator()
    {
        return stack.iterator();
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
        return (stack.getCount());
    }

    /*
     * Checks if the stack is empty.
     * 
     * @param: void.
     * 
     * @return: boolean.
     */
    public boolean isEmpty()
    {
        return (stack.isEmpty());
    }

    /*
     * Push the value into the stack.
     * 
     * @param: value.
     * 
     * @return: void.
     */
    public void push(T value)
    {
        stack.insertLast(value);
    }

    /*
     * Pops the value out of the stack.
     * 
     * @param: void.
     * 
     * @return: T.
     * 
     * @throws NoSuchElementException: Stack is empty.
     */
    public T pop() throws NoSuchElementException
    {
        if(isEmpty())
        {
            throw new IllegalStateException("The stack is empty.");
        }

        return stack.removeLast();
    }

    /*
     * Gives the last value in the stack.
     * 
     * @param: void.
     * 
     * @return: T.
     * 
     * @throws NoSuchElementException: Stack is empty.
     */
    public T top() throws NoSuchElementException
    {
        if(isEmpty())
        {
            throw new IllegalStateException("The stack is empty.");
        }

        return stack.peekLast();
    }
}