/*
 * Filename: DSAGraphTestHarness.java
 * Purpose: 
 *
 * @author   : Naseh Rizvi
 * StudentNo : 20167671
 * Unit      : DSA
 * Date      : 25/09/22
 * Practical : 06
 */

import java.util.*;

public class UnitTestGraph
{
    public static void main(String[] args)
    {
        System.out.println("Test Harness for DSAGraph.java");
        
        testConstructor();
        testAddVertex();
        testAddVertex();
        testGetVertexCount();
        testGetEdgeCount();
        testGetVertex();
        testGetEdge();
        testGetAdjacentVertex();
        testIsAdjacent();
        testDisplayAsList();
    }

    public static void testConstructor()
    {
        System.out.print("\tTesting Default: ");

        DSAGraph<String> graph = new DSAGraph<>();

        assert graph != null : "Should not be null";

        System.out.println("\t\t\tpassed.");
    }

    public static void testAddVertex()
    {
        System.out.print("\tTesting Add Vertex: ");

        String[] labels = {"A", "B", "C", "D"};
        DSAGraph<String> graph = new DSAGraph<>();

        for(String label: labels)
        {
            graph.addVertex(label, (double) 1);
        }

        assert graph.getVertexCount() == labels.length : "Length should be " + labels.length +".";

        try
        {
            graph.addVertex("A", (double) 1);
        }

        catch(IllegalArgumentException e)
        {
            System.out.println("\t\t\tpassed.");
        }
    }

    public static void testAddEdge()
    {
        System.out.print("\tTesting Add Edge: ");

        String[] labels = {"A", "B", "C", "D", "E"};
        DSAGraph<String> graph = new DSAGraph<>();

        for(String label: labels)
        {
            graph.addVertex(label, (double) 1);
        }

        graph.addEdge("A", "B", (double) 1);
        graph.addEdge("A", "C", (double) 1);
        graph.addEdge("A", "D", (double) 1);
        graph.addEdge("A", "E", (double) 1);
        graph.addEdge("B", "A", (double) 1);
        graph.addEdge("B", "D", (double) 1);
        graph.addEdge("B", "E", (double) 1);

        assert graph.getEdgeCount() == 7 : "Edge count should be 7.";

        try
        {
            graph.addEdge("A", "B", (double) 1);
        }

        catch(IllegalArgumentException e)
        {
            System.out.println("\t\t\tpassed.");
        }
    } 

    public static void testGetVertexCount()
    {
        System.out.print("\tTesting Get Vertex Count: ");

        String[] labels = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        DSAGraph<String> graph = new DSAGraph<>();

        for(String label: labels)
        {
            graph.addVertex(label, (double) 1);
        }

        assert graph.getVertexCount() == labels.length : "Length should be " + labels.length +".";

        System.out.println("\t\tpassed.");
    }

    public static void testGetEdgeCount()
    {
        System.out.print("\tTesting Get Edge Count: ");

        String[] labels = {"A", "B", "C", "D", "E", "F"};
        DSAGraph<String> graph = new DSAGraph<>();

        for(String label: labels)
        {
            graph.addVertex(label, (double) 1);
        }

        for(String label: labels)
        {
            graph.addEdge("A", label, (double) 1);
            graph.addEdge("D", label, (double) 1);
        }


        assert graph.getEdgeCount() == 12 : "Edge count should be 12.";

        System.out.println("\t\tpassed.");
    }

    public static void testGetVertex()
    {
        System.out.print("\tTesting Get Vertex: ");

        String[] labels = {"A", "B", "C", "D", "E", "F"};
        DSAGraph<String> graph = new DSAGraph<>();

        for(String label: labels)
        {
            graph.addVertex(label, (double) 1);
        }

        assert graph.getVertex("A") != null : "Vertex should not be null.";

        try
        {
            graph.getVertex("Z");
        }

        catch(NoSuchElementException e)
        {
            System.out.println("\t\t\tpassed.");
        }
    }

    public static void testGetEdge()
    {
        System.out.print("\tTesting Get Edge: ");

        String[] labels = {"A", "B", "C", "D", "E"};
        DSAGraph<String> graph = new DSAGraph<>();

        for(String label: labels)
        {
            graph.addVertex(label, (double) 1);
        }

        for(String label: labels)
        {
            graph.addEdge("A", label, (double) 1);
            graph.addEdge("D", label, (double) 1);
        }

        assert graph.getEdge("A-B") != null : "Edge should not be null.";

        try 
        {
            graph.getEdge("C-E");  
        } 
        
        catch(NoSuchElementException e)
        {
            System.out.println("\t\t\tpassed.");
        }
    }

    public static void testGetAdjacentVertex()
    {
        System.out.print("\tTesting Get Adjacent Vertices: ");

        String[] labels = {"A", "B", "C", "D", "E"};
        DSAGraph<String> graph = new DSAGraph<>();

        for(String label: labels)
        {
            graph.addVertex(label, (double) 1);
        }

        for(String label: labels)
        {
            graph.addEdge("A", label, (double) 1);
            graph.addEdge("D", label, (double) 1);
        }

        assert graph.getAdjacentVertex("A") != null : "Adjacent vertices should not be null.";

        try
        {
            graph.getAdjacentVertex("Z");
        }

        catch(NoSuchElementException e)
        {
            System.out.println("\t\tpassed.");
        }
    }

    public static void testIsAdjacent()
    {
        System.out.print("\tTesting Is Adjacent: ");

        String[] labels = {"A", "B", "C", "D", "E"};
        DSAGraph<String> graph = new DSAGraph<>();

        for(String label: labels)
        {
            graph.addVertex(label, (double) 1);
        }

        for(String label: labels)
        {
            graph.addEdge("A", label, (double) 1);
            graph.addEdge("D", label, (double) 1);
        }

        assert graph.isAdjacent("A", "B") : "Should be adjacent.";
        assert graph.isAdjacent("D", "E") : "Should be adjacent.";
        assert graph.isAdjacent("A", "E") : "Should be adjacent.";
        
        try
        {
            graph.isAdjacent("A", "Z");
        }

        catch(NoSuchElementException e)
        {
            System.out.println("\t\t\tpassed.");
        }
    }

    public static void testDisplayAsList()
    {
        System.out.print("\tTesting Display As List: ");

        String[] labels = {"A", "B", "C", "D", "E"};
        DSAGraph<String> graph = new DSAGraph<>();

        for(String label: labels)
        {
            graph.addVertex(label, (double) 1);
        }

        for(String label: labels)
        {
            graph.addEdge("A", label, (double) 1);
            graph.addEdge("D", label, (double) 1);
        }
        
        System.out.println("\t\tpassed.");

        graph.displayAsList();
    }
}