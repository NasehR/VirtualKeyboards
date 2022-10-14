# Shortest Path on Virtual Keyboards

## Overview
This project was created to explore the shortest path between characters the a string.
To browse the code please visit the following link: [Source Code](https://github.com/NasehR/VirtualKeyboards/tree/main/src)

## Command-Line Instructions
* **Prerequisites:**
    * Make sure you have java installed on your machine by calling `javac --version` in your terminal.

* **How to run:**
    * In your terminal `cd` to the main folder `src`.

    
    * Compile the main class file by typing the following command in your terminal:
        ```
        make
        ```

    * To run the program in interactive mode, type the following command in your terminal:
        ```
        java keyMeUp -i
        ```

    * To run the program in silent mode, type the following command in your terminal:
        ```
        java keyMeUp -s [File 1] [File 2] [File 3]
        ```
        * where :
            * [File 1] is the keyboards layout file.
            * [File 2] contains the string(s) that the program would search for.
            * [File 3] saves the output to the file.

    * Run test cases:
        * To run test case for DSALinkedList, type the following command in your terminal:
            ```
            make linkedlist && java UnitTestLinkedList && java UnitTestLinkedListIterator
            ```
        * To run test case for DSAStack, type the following command in your terminal:
            ```
            make stack && java UnitTestStack
            ```
        * To run test case for DSAQueue, type the following command in your terminal: 
            ```
            make queue && java UnitTestQueue
            ```
        * To run test case for DSAGraph, type the following command in your terminal: 
            ```
            make graph && java UnitTestGraph
            ```

## Features
- For this project, the program reads in a keyboard file with a general layout of starting vertex adjacent vertices.
Here is an example of the format required to describe the adjacenecy list:
```
    0 a q z
    1 s
```
In this example, from vertex 0 you can reach vertex a or q or z. From Vertex 1 you can reach vertex s. These edges are also directed which means that vertexc 0 goes to vertexc q but vertex q does not go back to vertex 0. For vertex q to go to vertex 0 we need to add and extra line where vertex q connects to vertex 0.

- To find the shortest path between the characters of a string, the program implements a dijkstra shortest path algorithm. The algorithm finds the length of shortest path from starting vertex to the ending vertex. This is done by starting at the starting vertex and iterating through each adjacent vertex to determine if the distance from the current vertex to the adjacent vertex could possibly lead to the shortest path to the ending vertex. Since the edges are directed, we must iterate through both the current and adjacent vertex finding its recently updated known shortest path.

- For this project I implemented a priority queue. A priority queue is both a queue and a list where elements within the queue has there own priority based on the value associated with each element. A normal queue is 1st in, 1st out FIFO style while a priority queue has a head that is constantly updated to have the smallest element in the list. This priority queue can add and remove elements at O(log N) time.

## File Description and Dependencies
* **DSALinkedList:**

    * Class constains the implementation of a generic doubly linked list. It has private inner class Node that creates each individual node in the linked list. Each node contains private member data for both the data and the Node objects to neighboring linked list nodes in front and back of the Node. 

* **DSAStack:**

    * Class contains the implementation of a Generic stack for data input. It uses the linked lists preimplemented class to create its stack. As items are pushed into the stack they are added to the heads of the linked list structure.

* **DSAQueue:**

    * Class contains the implementation of a generic queue for data input. It uses the linked lists preimplemented class to create its queue. As items are pushed into the queue they are added to the the back of the linked list structure.

* **DSAGraph:**

    * Class contains the implementation of a graph data type that can be created with a adjacency list. Each vertex is connected to another vertex through an edge where edges have a weight of 1. Also each vertex can be given a label.

* **FileIO:**

    * Class contains static methods to be used for file IO. As the methods have static scope they can be called from a invoker elsewhere without needing to instantiate the class.

* **modes:**

    * Class contains static methods to be used during program output. Has two public methods: interactive and silent.
    * In the interactive method the user is allowed to interact with the program while it is running to output custom code.
    * In the silent method the user is not allowed to interact with the program and no output from the program is diplayed. The code runs silently.

* **UserInputs:**

    * Class contains static methods to be used for user input within the program.

