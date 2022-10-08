/*
 * Filename: DSALinkedList.java
 * Purpose: Contains the DSALinkedList class
 *
 * @author   : Naseh Rizvi
 * StudentNo : 20167671
 * Unit      : DSA
 * Date      : 25/09/22
 * Practical : 04
 */

package dependencies;

import java.io.*;
import java.util.*;

public class DSALinkedList<T> implements Serializable, Iterable<T>
{
    // Class fields:
    private int counter;
    private DSAListNode head;
    private DSAListNode tail;

    // Linked List Node:
    private class DSAListNode implements Serializable
    {
        // Class Fields:
        private T data;
        private DSAListNode prev;
        private DSAListNode next;
        
        //Constructor:
        public DSAListNode(T data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Linked List Iterator:
    private class DSALinkedListIterator implements Iterator<T>
    {
        // Class Fields:
        private DSAListNode nextNode;
        private DSAListNode current;

        // Alternate Constructor:
        public DSALinkedListIterator(DSALinkedList<T> list)
        {
            nextNode = list.head;
            current = null;
        }

        //Getter hasNext:
        public boolean hasNext()
        {
            return (nextNode != null);
        }

        //Setter next
        public T next()
        {
            T value;
            
            if(nextNode == null)
            {
                value = null;
            }

            else
            {
                value = nextNode.data;
                current = nextNode;
                nextNode = nextNode.next;
            }

            return value;
        }
        
        public void remove() throws IllegalStateException
        {
            throw new UnsupportedOperationException("Unsupported Operation.");
        }
    }

    //Constructor:
    public DSALinkedList() 
    {
        head = null;
        tail = null;
        counter = 0;
    }

    //Getter iterator:
    public Iterator<T> iterator()
    {
        return new DSALinkedListIterator(this);
    }

    /*
     * Inserts the given value to the front of the linked list.
     * 
     * @param: Value to insert.
     * 
     * @return: void.
     */
    public void insertFirst(T newValue)
    {
        DSAListNode newNode = new DSAListNode(newValue);

        if(isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        
        else
        {
            newNode.next = head;
            head.prev = newNode;
        }

        head = newNode;
        counter++;
    }

    /*
     * Inserts the given value to the end of the linked list.
     * 
     * @param: Value to insert.
     * 
     * @return: void.
     */
    public void insertLast(T newValue)
    {
        DSAListNode newNode = new DSAListNode(newValue) ;

        if(isEmpty())
        {
            head = newNode;
            tail = newNode;
        }

        else
        {
            newNode.prev = tail;
            tail.next = newNode;

            tail = newNode;
        }

        tail = newNode;
        counter++;
    }

    /*
     * Remove the value at the front of the linked list.
     * 
     * @param: void.
     * 
     * @return: T.
     */
    public T removeFirst() throws NoSuchElementException
    {    
        T data;
        DSAListNode tmp;

        if(isEmpty())
        {
            throw new NoSuchElementException("List is empty");
        }

        data = head.data;

        if(counter == 1)
        {
            head = null;
            tail = null;
        }
        else
        {
            head = head.next;

            head.prev = null;
        }

        counter--;

        return data;
    }

    /*
     * Removes the value at the end of the linked list.
     * 
     * @param: void.
     * 
     * @return: T.
     */
    public T removeLast() throws NoSuchElementException
    {
        T data;
        DSAListNode tmp;

        if(isEmpty())
        {
            throw new NoSuchElementException("List is empty");
        }

        data = tail.data;

        if(counter == 1)
        {
            head = null;
            tail = null;
        }
        else
        {
            tail = tail.prev;

            tail.next = null;
        }

        counter--;
        
        return data;
    }

    /*
     * Checks if the linked list is empty.
     * 
     * @param: void.
     * 
     * @return: boolean.
     */
    public boolean isEmpty()
    {
        return ((head == null) && (tail == null));
    }

    /*
     * Gets the length of the linked list.
     * 
     * @param: void.
     * 
     * @return: int.
     */
    public int getCount()
    {
        return counter;
    }

    /*
     * Shows the fisrt value in the linked list.
     * 
     * @param: void.
     * 
     * @return: T.
     */
    public T peekFirst()
    {
        if(isEmpty())
        {
            throw new NoSuchElementException("List is empty");
        }

        return (head.data);
    }

    /*
     * Shows the last value in the linked list.
     * 
     * @param: void.
     * 
     * @return: T.
     */
    public T peekLast()
    {
        if(isEmpty())
        {
            throw new NoSuchElementException("List is empty");
        }

        return (tail.data);
    }

    /*
     * Displays the linked list.
     * 
     * @param: void.
     * 
     * @return: void.
     */
    public void display()
    {
        DSAListNode tmp;

        tmp = head;

        while(tmp != null)
        {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }
}
