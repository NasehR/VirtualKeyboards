/*
 * Filename: DSAGraph.java
 * Purpose: Contains the DSALinkedList class
 *
 * @author   : Naseh Rizvi
 * StudentNo : 20167671
 * Unit      : DSA
 * Date      : 25/09/22
 * Practical : 06
 */

import java.util.*;
import java.io.*;

public class DSAGraph implements Serializable
{
    // Graph Vertex
    private class DSAGraphVertex implements Comparable<Double>, Serializable
    {
        // DSAGraphVertex Class Fields:
        private String label;
        private Double distance;
        private DSALinkedList<DSAGraphVertex> links;
        private boolean visited;
		private DSAGraphVertex previousVertex;

        // Constructor:
        public DSAGraphVertex(String inLabel, Double inDistance)
        {
            label = inLabel;
            distance = inDistance;
            links = new DSALinkedList<>();
            previousVertex = null;
        }

        // Alternative Constructor
        public DSAGraphVertex(String inLabel)
        {
            label = inLabel;
            distance = null;
            links = new DSALinkedList<>();
            previousVertex = null;
        }
       
        // Accessor getLabel:
        public String getLabel()
        {
            return label;
        }

        // Accessor getDistance:
        public Double getDistance()
        {
            return distance;
        }
        
        // Accessor getAdjacent:
        public DSALinkedList<DSAGraphVertex> getAdjacent()
        {
            return links;
        }

        // Mutator addEdge:
        public void addEdge(DSAGraphVertex vertex)
        {
            links.insertLast(vertex);
        }

        // Mutator setVisited:
        public void setVisited()
        {
            visited = true;
        }

        // Mutator clearVisited:
        public void clearVisited()
        {
            visited = false;
        }
        
        // Accessor getVisited:
        public boolean getVisited()
        {
            return visited;
        }

        // Mutator setDistance:
		public void setDistance(double newDistance)
		{
			distance = newDistance;
		}

        // Mutator setPreviousVertex:
        public void setPreviousVertex(DSAGraphVertex vertex)
        {
            previousVertex = vertex;
        }

        // Accessor getPreviousVertex:
        public DSAGraphVertex getPreviousVertex()
        {
            return previousVertex;
        }

        // Accessor toString:
        public String toString()
        {
            return label.toString();
        }

        // Mutator removeAdjacent:
        public void removeAdjacent(DSAGraphVertex vertexLabel)
        {
            links.removeMiddle(vertexLabel);
        }

        // Accessor compareTo:
        @Override
        public int compareTo(Double other)
        {
            return distance.compareTo(other);
        }
    }

    // Graph Edge
    private class DSAGraphEdge implements Serializable
    {
        // DSAGraphEdge Class Fields:
        private DSAGraphVertex from;
        private DSAGraphVertex to;
        private String label;
        private Double value;

        // Constructor:
        public DSAGraphEdge(DSAGraphVertex fromVertex, DSAGraphVertex toVertex, String inLabel, Double inValue)
        {
            from = fromVertex;
            to = toVertex;
            label = inLabel;
            value = inValue;
        }

        // Alternative Constructor:
        public DSAGraphEdge(DSAGraphVertex fromVertex, DSAGraphVertex toVertex, String inLabel)
        {
            from = fromVertex;
            to = toVertex;
            label = inLabel;
            value = 1.0;
        }

        // Accessor getLabel:
        public String getLabel()
        {
            return label;
        }

        // Accessor getValue:
        public Double getValue()
        {
            return value;
        }

        // Accessor getFrom:
        public DSAGraphVertex getFrom()
        {
            return from;
        }

        // Accessor getTo:
        public DSAGraphVertex getTo()
        {
            return to;
        }

        // Accessor isDirected:
        public boolean isDirected()
        {
            return true;
        } 
        
        // Accessor toString:
        public String toString()
        {
            return label.toString();
        }
    } 
    
    // Dijkstra's Stacks
    public class DijkstrasStacks
    {
        // DijkstrasStacks Class Fields:
        private DSAStack<String> finalStack;
        private DSAStack<Double> distanceStack;

        // Constructor:
        public DijkstrasStacks()
        {
            finalStack = new DSAStack<>();
            distanceStack = new DSAStack<>();
        }

        // Mutator setFinalStack:
        public void setFinalStack(DSAStack<String> finalStack)
        {
            this.finalStack = finalStack;
        }

        // Accessor getFinalStack:
        public DSAStack<String> getFinalStack()
        {
            return finalStack;
        }

        // Mutator setDistanceStack:
        public void setDistanceStack(DSAStack<Double> distanceStack)
        {
            this.distanceStack = distanceStack;
        }
        
        // Accessor getDistanceStack:
        public DSAStack<Double> getDistanceStack()
        {
            return distanceStack;
        }
    }

    //Class Fields:
    private DSALinkedList<DSAGraphVertex> vertices;
    private DSALinkedList<DSAGraphEdge> edges;
    private DSALinkedList<String> overallPath;
    private DijkstrasStacks dijkstras;

    // Constructor:
    public DSAGraph()
    {
        vertices = new DSALinkedList<>();
        edges = new DSALinkedList<>();
        overallPath = new DSALinkedList<>();
        dijkstras = null;
    }

    /*
     * Adds a vertex with label and value to the graph.
     * 
     * @param label: The label of the vertex to be added.
     * @param value: The value of the vertex to be added.
     * 
     * @return: void.
     * 
     * @throws IllegalArgumentException: Vertex already exists.
     */
    public void addVertex(String label, Double value) throws IllegalArgumentException
    {
        if(hasVertex(label))
        {
            throw new IllegalArgumentException("Vertex " + label + " already exists");
        }
        
        DSAGraphVertex vertex = new DSAGraphVertex(label);
        vertices.insertLast(vertex);
    }

    /*
     * Adds a vertex with label to the graph.
     * 
     * @param label: The label of the vertex to be added.
     * 
     * @return: void.
     *
     * @throws IllegalArgumentException: Vertex already exists.
     */
    public void addVertex(String label) throws IllegalArgumentException
    {
        if(hasVertex(label))
        {
            throw new IllegalArgumentException("Vertex " + label + " already exists");
        }
        
        else if(!(hasVertex(label)))
        {
            DSAGraphVertex vertex = new DSAGraphVertex(label);
            vertices.insertLast(vertex);
        }
    }

    /*
     * Removes a vertex with label from the graph.
     * 
     * @param label: The label of the vertex to be removed.
     * 
     * @return: void.
     *
     * @throws IllegalArgumentException: Vertex does not exists.
     */
    public void removeVertex(String label) throws IllegalArgumentException
    {
        if(!(hasVertex(label)))
        {
            throw new IllegalArgumentException("Vertex " + label + " does not exists");
        }
        
        else if(hasVertex(label))
        {
            DSAGraphVertex vertex = getVertex(label);
            
            for(DSAGraphEdge e : edges)
            {
                if(e.getFrom().equals(vertex) || e.getTo().equals(vertex))
                {
                    edges.removeMiddle(e);
                }

                if(e.getTo().equals(vertex))
                {
                    e.getFrom().removeAdjacent(vertex);
                }
            }

            vertices.removeMiddle(vertex);
        }
    }

    /*
     * Adds an edge with a value to the graph.
     * 
     * @param fromLabel: The label of the origin vertex.
     * @param toLabel: The label of the destination vertex.
     * @param edgeValue: The value of the edge to be added.
     * 
     * @return: void.
     * 
     * @throws IllegalArgumentException: Edge already exists.
     */
    public void addEdge(String fromLabel, String toLabel, Double edgeValue) throws IllegalArgumentException
    {
        if(hasEdge(fromLabel, toLabel))
        {
            throw new IllegalArgumentException("Edge from " + fromLabel + " to " + toLabel + " already exists");
        }

        else if(!(hasEdge(fromLabel, toLabel)))
        {
            String edgeLabel = fromLabel + "-" + toLabel;
            DSAGraphVertex origin = getVertex(fromLabel);
            DSAGraphVertex destination = getVertex(toLabel);
            DSAGraphEdge edge = new DSAGraphEdge(origin, destination, edgeLabel, edgeValue);
            edges.insertLast(edge);
            origin.addEdge(destination);
        }
    }
    
    /*
     * Adds an edge to the graph.
     * 
     * @param fromLabel: The label of the origin vertex.
     * @param toLabel: The label of the destination vertex.
     * 
     * @return: void.
     * 
     * @throws IllegalArgumentException: Edge already exists.
     */
    public void addEdge(String fromLabel, String toLabel) throws IllegalArgumentException
    {
        if(hasEdge(fromLabel, toLabel))
        {
            throw new IllegalArgumentException("Edge from " + fromLabel + " to " + toLabel + " already exists");
        }

        else if(!(hasEdge(fromLabel, toLabel)))
        {
            String edgeLabel = fromLabel + "-" + toLabel;
            DSAGraphVertex origin = getVertex(fromLabel);
            DSAGraphVertex destination = getVertex(toLabel);
            DSAGraphEdge edge = new DSAGraphEdge(origin, destination, edgeLabel);
            edges.insertLast(edge);
            origin.addEdge(destination);
        }
    }

    /*
     * Removes an edge from the graph
     * 
     * @param fromLabel: The label of the origin vertex.
     * @param toLabel: The label of the destination vertex.
     * 
     * return: void.
     * 
     * @throws IllegalArgumentException: Edge does not exists.
     */
    public void removeEdge(String fromLabel, String toLabel) throws IllegalArgumentException
    {
        if(!(hasEdge(fromLabel, toLabel)))
        {
            throw new IllegalArgumentException("Edge from " + fromLabel + " to " + toLabel + " does not exists");
        }

        else if(hasEdge(fromLabel, toLabel))
        {
            String edgeLabel = fromLabel + "-" + toLabel;
            System.out.println("Deleting edge: " + edgeLabel);
            edges.removeMiddle(getEdge(edgeLabel));
            getVertex(fromLabel).removeAdjacent(getVertex(toLabel));
        }
    }

    /*
     * Checks if a vertex with the given label exists in the graph.
     * 
     * @param label: The label of the vertex to be checked.
     * 
     * @return boolean: True if is the graph has the vertex.
     */
    public boolean hasVertex(String label)
    {
        boolean condition = false;

        for(DSAGraphVertex v : vertices)
        {
            if(v.getLabel().equals(label))
            {
                condition = true;
            }
        }
        
        return condition;
    }

    /*
     * Checks if an edge from one label to another label exists in the graph.
     * 
     * @param toLabel: The label of the origin vertex.
     * @param fromLabel: The label of the destination vertex.
     * 
     * @return boolean: True if the graph has the vertex.
     */
    public boolean hasEdge(String fromLabel, String toLabel)
    {
        boolean condition = false;
        DSAGraphVertex origin = getVertex(fromLabel);
        DSAGraphVertex destination = getVertex(toLabel);

        for(DSAGraphEdge e : edges)
        {
            if((e.getTo().equals(destination)) && (e.getFrom().equals(origin)))
            {
                condition = true;
            }
        }
        
        return condition;
    }

    /*
     * Gets the number of vertices in the graph.
     * 
     * @param: void.
     * 
     * @return int: Number of vertices.
     */
    public int getVertexCount()
    {
        return vertices.getCount();
    }

    /*
     * Gets the number of edges in the graph.
     * 
     * @param: void.
     * 
     * @return int: Number of edges.
     */
    public int getEdgeCount()
    {
        return edges.getCount();
    }
 
    /*
     * Gets the vertex with the given label.
     * 
     * @param label: The label of the vertex to be returned.
     * 
     * @return DSAGraphVertex: The vertex with the label provided.
     * 
     * @throws NoSuchElementException: Vertex does not exist.
     */
    public DSAGraphVertex getVertex(String label) throws NoSuchElementException
    {
        DSAGraphVertex vertex = null;
        
        for(DSAGraphVertex v : vertices)
        {
            if(v.getLabel().equals(label))
            {
                vertex = v;
            }
        }

        if(vertex == null)
        {
            throw new NoSuchElementException("Vertex is not in the graph.");
        }

        return vertex;
    }

    /*
     * Gets the edge with the given label.
     * 
     * @param label: The label of the edge to be returned.
     * 
     * @return DSAGraphEdge: The edge with the label provided.
     * 
     * @throws NoSuchElementException: Edge does not exist.
     */
    public DSAGraphEdge getEdge(String label) throws NoSuchElementException
    {
        DSAGraphEdge edge = null;

        for(DSAGraphEdge e : edges)
        {
            if((e.getLabel()).equals(label))
            {
                edge = e;
            }
        }

        if(edge == null)
        {
            throw new NoSuchElementException("Edge is not in the graph.");
        }

        return edge;
    }

    /*
     * Gets all the stacks in the DijkstrasStack class.
     * 
     * @param: void.
     * 
     * @return: DijkstrasStack.
     */
    public DijkstrasStacks getDijkstrasStacks()
    {
        return this.dijkstras;
    }
    
    /*
     * Sets the stacks in the DijkstrasStack class.
     * 
     * @param dijkstrasStack: instance of the DijkstrasStack class.      
     * 
     * @return: void.
     */
    public void setDijkstrasStacks(DijkstrasStacks dijkstrasStack)
    {
        this.dijkstras = dijkstrasStack;
    }

    /*
     * Returns the overall path.
     * 
     * @param: void.
     * 
     * @return: DASLinkedList<String>.
     */
    public DSALinkedList<String> getOverallPath()
    {
        return this.overallPath;
    } 

    /*
     * Gets the adjacent vertices of a vertex with the given label.
     * 
     * @param label: The label of the vertex.
     * 
     * @return: DSALinkedList<DSAGraphVertex>.
     */
    public DSALinkedList<DSAGraphVertex> getAdjacentVertex(String label) 
    {
        DSAGraphVertex vertex = getVertex(label);
        return vertex.getAdjacent();
    }

    /*
     * Checks if two vertices with a given label are adjacent.
     * 
     * @param label1: The label of the vertex 1.
     * @param label2: The label of the vertex 2.
     * 
     * @return boolean: True if the two vertices are adjacent.
     */
    public boolean isAdjacent(String label1, String label2) 
    {
        boolean adjacent = false;
        DSAGraphVertex vertex1 = getVertex(label1);
        DSAGraphVertex vertex2 = getVertex(label2);

        for(DSAGraphEdge e : edges)
        {
            if((e.getFrom().equals(vertex1)) && (e.getTo().equals(vertex2)))
            {
                adjacent = true;
            }
        }

        for(DSAGraphVertex v : vertices)
        {
            if(v.getLabel().equals(label1))
            {
                for(DSAGraphEdge e : edges)
                {
                    if(e.getFrom().equals(label1) && e.getTo().equals(label2))
                    {
                        adjacent = true;
                    }
                }
            }

            if(v.getLabel().equals(label2))
            {
                for(DSAGraphEdge e : edges)
                {
                    if(e.getFrom().equals(label2) && e.getTo().equals(label1))
                    {
                        adjacent = true;
                    }
                }
            }
        }

        return adjacent;
    }

    /*
     * Gets the vertices of the graph that have not been visted.
     * 
     * @param vertex: The vertex to that is not visted.
     * 
     * @return DSALinkedList<DSAGraphVertex>: Linkedlist of all the unvisited vertices.
     */
    private DSALinkedList<DSAGraphVertex> getNotVisited(DSAGraphVertex vertex)
    {
        DSALinkedList<DSAGraphVertex> notVisited = new DSALinkedList<>();
        
        for(DSAGraphVertex v: vertices)
        {
            if(!(v.getVisited()))
            {
                notVisited.insertLast(v);
            }
        }
        
        return notVisited;
    }

    /*
     * Displays the graph as a list.
     * 
     * @param: void.
     * 
     * @return: void.
     */
    public void displayAsList()
    {
        System.out.print("Displaying graph...\n");

        for(DSAGraphVertex v : vertices)
        {
            int i = 0;
            int count = v.getAdjacent().getCount() - 1;
            System.out.print(v.getLabel() + "\t-> [");

            for(DSAGraphVertex v2 : v.getAdjacent())
            {
                System.out.print(v2.getLabel());
                
                if(i < (count))
                {
                    System.out.print(", ");
                    i++;
                }
            }

            System.out.println("]");
        }
    }

    /*
     * Display the graph as a matrix.
     * 
     * @param: void.
     * 
     * @return: void.
     */
    public void displayAsMatrix()
    {
        System.out.print("\n");

        for(DSAGraphVertex v: vertices)
        {
            System.out.print("\t" + v.getLabel());
        }

        for(DSAGraphVertex v: vertices)
        {
            System.out.print("\n\n" + v.getLabel());
            
            for(DSAGraphVertex v2: vertices)
            {
                if(hasEdge(v2.getLabel(), v.getLabel()))
                {
                    System.out.print("\t1");
                }

                else
                {
                    System.out.print("\t0");
                }
            }
        }
    }

    /*
     * Displays the graphs info.
     * 
     * @param: void.
     * 
     * @return: void.
     */
    public void displayInfo()
    {
        System.out.println("Displaying graph information...");
        System.out.print("The number of Vertices = \t");
        System.out.println(getVertexCount());
        System.out.print("The number of Edges = \t");
        System.out.println(getEdgeCount()); 
        System.out.print("The number of Edges per Vertex = \t");
        System.out.println((float) (getEdgeCount())/(getVertexCount()));
    }

    /*
     * Performs a breath first search on the graph.
     * 
     * @param: void.
     * 
     * @return DSAQueue<DSAGraphVertex>: Path of breath first search.
     */
    public DSAQueue<DSAGraphVertex> BFS()
    {
        DSAQueue<DSAGraphVertex> notVisited = new DSAQueue<>();
        DSAQueue<DSAGraphVertex> visited = new DSAQueue<>();
        DSAGraphVertex vertex;

        for(DSAGraphVertex v : vertices)
        {
            v.clearVisited();
        }

        vertex = vertices.peekFirst();
        vertex.setVisited();
        notVisited.enqueue(vertex);
        visited.enqueue(vertex);

        do
        {
            vertex = notVisited.dequeue();

            for(DSAGraphVertex v : vertex.links)
            {
                if(!(v.getVisited()))
                {
                    visited.enqueue(v);
                    v.setVisited();
                    notVisited.enqueue(v);
                }
            }
        }while(!notVisited.isEmpty());

        return visited;
    }

    /*
     * Performs a depth first search on the graph.
     * 
     * @param: void.
     * 
     * @returnDSAQueue<DSAGraphVertex>: Path of depth first search.
     */
    public DSAQueue<DSAGraphVertex> DFS()
    {
        DSAStack<DSAGraphVertex> notVisited = new DSAStack<>();
        DSAQueue<DSAGraphVertex> visited = new DSAQueue<>();
        Iterator<DSAGraphVertex> itr;
        DSAGraphVertex vertex;
        DSAGraphVertex nextVertex;
        
        for(DSAGraphVertex v : vertices)
        {
            v.clearVisited();
        }
        
        vertex = vertices.peekFirst();
        vertex.setVisited();

        notVisited.push(vertex);
        visited.enqueue(vertex);

        do
        {
            vertex = notVisited.pop();
            
            itr = (vertex.links).iterator();
            
            
            while(itr.hasNext())
            {
                nextVertex = itr.next();

                if(!nextVertex.getVisited())
                {
                    visited.enqueue(nextVertex);
                    nextVertex.setVisited();
                    notVisited.push(nextVertex);
                    itr = (nextVertex.links).iterator();
                }
            }
        }while(!notVisited.isEmpty());

        
        return visited;
    }

    /*
     * Backtracks from the end vertex to find the start vertex.
     * 
     * @param startVertex: Starting vertex of Dijkstra’s.
     * @param endVertex: Ending vertex of Dijkstra’s.
     * 
     * @return: void.
     */
    private void tracking(DSAGraphVertex startVertex, DSAGraphVertex endVertex)
    {
        try 
        {
            this.dijkstras = new DijkstrasStacks();
            DSAStack<String> finalStack = new DSAStack<>();
            DSAStack<Double> distanceStack = new DSAStack<>();
            DSAGraphVertex vertex;
            vertex = endVertex;
            
            if(!(endVertex.equals(startVertex)))
            {
                finalStack.push(vertex.getLabel());
                distanceStack.push(vertex.getDistance());
                overallPath.insertFirst(vertex.getLabel());
                vertex = vertex.getPreviousVertex();
    
                
                while(!(vertex.equals(startVertex)))
                {
                    finalStack.push(vertex.getLabel());
                    distanceStack.push(vertex.getDistance());
                    overallPath.insertFirst(vertex.getLabel());
                    vertex = vertex.getPreviousVertex();
                }
    
                finalStack.push(startVertex.getLabel());
                distanceStack.push(startVertex.getDistance());
                overallPath.insertFirst(vertex.getLabel());
    
                dijkstras.setDistanceStack(distanceStack);
                dijkstras.setFinalStack(finalStack);
            }

            else if(endVertex.equals(startVertex))
            {
                finalStack.push(vertex.getLabel());
                distanceStack.push(0.0);

                dijkstras.setDistanceStack(distanceStack);
                dijkstras.setFinalStack(finalStack);
            }

        } 

        catch(NullPointerException e) 
        {
            System.out.println("vertex is null.");
        }
    }

    /*
     * Performs a Dijkstra’s Algorithm on the graph.
     * 
     * @param startLabel: label of the start vertex.
     * @param endLabel: label of the end vertex.
     * 
     * @return: void.
     *
     * @throws NoSuchElementException: Either vertex do not exist.
     */
    public void Dijkstras(String startLabel, String endLabel) throws NoSuchElementException
    {
        DSAGraphVertex startVertex, endVertex;
        DSAQueue<DSAGraphVertex> priorityQueue = new DSAQueue<>();
        String label;

        try
        {
            startVertex = getVertex(startLabel);
            endVertex = getVertex(endLabel);
    
            if(!(startVertex.equals(endVertex)))
            {
                for(DSAGraphVertex v : vertices)
                {
                    if(v.equals(startVertex))
                    {
                        v.setDistance(0);
                        v.setPreviousVertex(null);
                    }
        
                    else
                    {
                        v.setDistance(Double.POSITIVE_INFINITY);
                        v.setPreviousVertex(null);
                    }
                }
        
                for(DSAGraphVertex v : startVertex.getAdjacent())
                {
                    String edgeLabel = (startVertex.getLabel() + "-" + v.getLabel());
                    v.setDistance(startVertex.getDistance() + getEdge(edgeLabel).getValue());
                    v.setPreviousVertex(startVertex);
                    priorityQueue.enqueue(v);
                }
    
                while(!(priorityQueue.isEmpty()))
                {
                    DSAGraphVertex u = priorityQueue.dequeue();

                    if(!(u.equals(endVertex)))
                    {
                        for(DSAGraphVertex v : u.getAdjacent())
                        {
                            DSAGraphEdge edge = getEdge(u.getLabel() + "-" + v.getLabel());
                            Double tempDistance = u.getDistance() + edge.getValue();
                            
                            if(tempDistance < v.getDistance())
                            {
                                v.setPreviousVertex(u);
                                v.setDistance(tempDistance);
                                priorityQueue.enqueue(v);
                            }
                        }
                    }
                }

                tracking(startVertex, endVertex);
            }

            else if(startVertex.equals(endVertex))
            {
                tracking(startVertex, endVertex);
            }
        }

        catch (NoSuchElementException e)
        {
            throw new NoSuchElementException("Edge is not in the graph.");
        }
    }

    /*
     * Displays the Dijkstra's queue and the distance.
     * 
     * @param: void.
     * 
     * @return: void.
     * 
     * @throws NullPointerException: dijkstras is null.
     */
    public void displayFinal() throws NullPointerException
    {
        if(this.dijkstras == null)
        {
            throw new NullPointerException("dijkstras is null.");
        }

        else
        {
            DSAStack<String> FQ = dijkstras.getFinalStack();
            DSAStack<Double> DQ = dijkstras.getDistanceStack();
            int FQCount, DQCount;
            FQCount = FQ.getCount();
            DQCount = DQ.getCount();
    
            System.out.println("PATH:\n");
            
            for(int i = 0; i < FQCount; i++)
            {
                System.out.print(FQ.pop());

                if(!(FQ.isEmpty()))
                {
                    System.out.print("->");
                }
            }

            System.out.println("\tEND");
                        
            if(DQ.isEmpty())
            {
                System.out.println("\nDISTANCE:\t" + (DQ.getCount()));
            }
            
            else
            {
                System.out.println("\nDISTANCE:\t" + (DQ.getCount() - 1));
            }

            for(int i = 0; i < DQCount; i++)
            {
                System.out.print(DQ.pop());

                if(!(DQ.isEmpty()))
                {
                    System.out.print("->");
                }
            }

            System.out.println("\tEND\n");
        } 
    }
}