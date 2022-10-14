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
        // DSAListNode Class Fields:
        private T data;
        private DSAListNode prev;
        private DSAListNode next;
        
        // Constructor:
        public DSAListNode(T data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        // Accessors getData:
        public T getData()
        {
            return data;
        }

        // Accessors getNext:
        public DSAListNode getNext()
        {
            return next;
        }

        // Mutators setNext
        public void setNext(DSAListNode next)
        {
            this.next = next;
        }

        // Accessors getPrev:
        public DSAListNode getPrev()
        {
            return prev;
        }

        // Mutators setPrev:
        public void setPrev(DSAListNode prev)
        {
            this.prev = prev;
        }
    }

    // Linked List Iterator:
    private class DSALinkedListIterator implements Iterator<T>
    {
        // DSALinkedListIterator Class Fields:
        private DSAListNode nextNode;
        private DSAListNode current;

        // Constructor:
        public DSALinkedListIterator(DSALinkedList<T> list)
        {
            nextNode = list.head;
            current = null;
        }

        // Accessor hasNext:
        public boolean hasNext()
        {
            return (nextNode != null);
        }

        // Accessor next
        public T next()
        {
            T value;
            
            if(nextNode == null)
            {
                value = null;
            }

            else
            {
                value = nextNode.getData();
                current = nextNode;
                nextNode = nextNode.getNext();
            }

            return value;
        }
         
        // Mutator remove
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

    /*
     * Iterates through the LinkedList.
     * 
     * @param: void.
     * 
     * @return: DSALinkedListIterator.
     */
    public Iterator<T> iterator()
    {
        return new DSALinkedListIterator(this);
    }

    /*
     * Inserts the given value to the front of the linked list.
     * 
     * @param newValue: Value to insert.
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
     * @param newValue: Value to insert.
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
     *
     * @throws NoSuchElementException: Linkedlist is empty.
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
     * Removes the value in the middle of the linked list.
     * 
     * @param: void.
     * 
     * @return: T.
     *
     * @throws NoSuchElementException: Linkedlist is empty.
     */
    public T removeMiddle(T nodeData) throws NoSuchElementException
    {
        T tempData;
        boolean exit, found;
        DSAListNode currentNode, prevNode, nextNode;

        if(isEmpty())
        {
            throw new NoSuchElementException("List is empty");
        }

        else
        {
            exit = false;
            found = false;
            currentNode = head;
            tempData = currentNode.getData();

            while(!exit)
            {
                if(currentNode.getData().equals(nodeData))
                {
                    found = true;
                    exit = true;
                }

                else if(currentNode.getNext().equals(null))
                {
                    exit = true;
                }

                else
                {
                    currentNode = currentNode.getNext();
                }
            }

            if(found)
            {
                tempData = currentNode.getData();

                if(currentNode.equals(head))
                {
                    removeFirst();
                }

                else if(currentNode.equals(tail))
                {
                    removeLast();
                }

                else
                {
                    nextNode = currentNode.getNext();
                    prevNode = currentNode.getPrev();
                    prevNode.setNext(nextNode);
                    nextNode.setPrev(prevNode);
                }

                counter--;
            }

            else
            {
                throw new NoSuchElementException("Node not found");
            }
        }

        return tempData;
    }

    /*
     * Removes the value at the end of the linked list.
     * 
     * @param: void.
     * 
     * @return: T.
     * 
     * @throws NoSuchElementException: Linkedlist is empty.
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
     * 
     * @throws NoSuchElementException: Linkedlist is empty.
     */
    public T peekFirst() throws NoSuchElementException
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
     * 
     * @throws NoSuchElementException: Linkedlist is empty.
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
