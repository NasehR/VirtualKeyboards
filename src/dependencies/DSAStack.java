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

 package dependencies;

import java.util.*;

public class DSAStack<T>
{
    //Class fields
    private DSALinkedList<T> stack;

    //Constructor
    public DSAStack()
    {
        stack = new DSALinkedList<T>();
    }

    //Getter Iterator:
    public Iterator<T> iterator()
    {
        return stack.iterator();
    }

    //Getter Capacity:
    public int getCount()
    {
        return (stack.getCount());
    }

    //Getter isEmpty:
    public boolean isEmpty()
    {
        return (stack.isEmpty());
    }

    //Setter push:
    public void push(T value) throws IllegalStateException
    {
        stack.insertLast(value);
    }

    //Setter pop:
    public T pop() throws IllegalStateException
    {
        if(isEmpty())
        {
            throw new IllegalStateException("The stack is empty.");
        }

        return stack.removeLast();
    }

    //Setter top:
    public T top() throws IllegalStateException
    {
        if(isEmpty())
        {
            throw new IllegalStateException("The stack is empty.");
        }

        return stack.peekLast();
    }
}