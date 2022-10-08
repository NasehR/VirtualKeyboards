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

package dependencies;

import java.util.*;

public class DSAGraph<L>
{
    private class DSAGraphVertex implements Comparable<Double>
    {
        // Class Fields:
        private L label;
        private Double distance;
        private DSALinkedList<DSAGraphVertex> links;
        private boolean visited;
		private DSAGraphVertex previousVertex;

        // Constructor:
        public DSAGraphVertex(L inLabel)
        {
            label = inLabel;
            distance = Double.POSITIVE_INFINITY;
            links = new DSALinkedList<>();
            previousVertex = null;
        }
       
        // Accessor getLabel:
        public L getLabel()
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

        //Setter addEdge:
        public void addEdge(DSAGraphVertex vertex)
        {
            links.insertLast(vertex);
        }

        // Setter setVisited:
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

		public void setDistance(double newDistance)
		{
			distance = newDistance;
		}

        public void setPreviousVertex(DSAGraphVertex vertex)
        {
            previousVertex = vertex;
        }

        public DSAGraphVertex getPreviousVertex()
        {
            return previousVertex;
        }

        // Accessor toString:
        public String toString()
        {
            return label.toString();
        }

        @Override
        public int compareTo(Double other)
        {
            return distance.compareTo(other);
        }
    }

    private class DSAGraphEdge
    {
        // Class Fields:
        private DSAGraphVertex from;
        private DSAGraphVertex to;
        private L label;
        private Double value;

        // Constructor:
        public DSAGraphEdge(DSAGraphVertex fromVertex, DSAGraphVertex toVertex, L inLabel, Double inValue)
        {
            from = fromVertex;
            to = toVertex;
            label = inLabel;
            value = inValue;
        }

        // Alternative Constructor:
        public DSAGraphEdge(DSAGraphVertex fromVertex, DSAGraphVertex toVertex, L inLabel)
        {
            from = fromVertex;
            to = toVertex;
            label = inLabel;
            value = 1.0;
        }

        // Accessor getLabel:
        public L getLabel()
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
    
    //Class Fields:
    private DSALinkedList<DSAGraphVertex> vertices;
    private DSALinkedList<DSAGraphEdge> edges;

    //Constructor:
    public DSAGraph()
    {
        vertices = new DSALinkedList<>();
        edges = new DSALinkedList<>();
    }

    /*
     * Adds a vertex with label and value to the graph.
     * 
     * @param label: The label of the vertex to be added.
     * @param value: The value of the vertex to be added.
     * 
     * @return: void.
     */
    public void addVertex(L label, Double value)
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
     */
    public void addVertex(L label)
    {
        if(hasVertex(label))
        {
            throw new IllegalArgumentException("Vertex " + label + " already exists");
        }
        
        DSAGraphVertex vertex = new DSAGraphVertex(label);
        vertices.insertLast(vertex);
    }

    /*
     * Adds an edge with a value to the graph.
     * 
     * @param fromLabel: The label of the origin vertex.
     * @param toLabel: The label of the destination vertex.
     * @param value: The value of the edge to be added.
     * 
     * @return: void.
     * 
     * @throws: IllegalArgumentException if the edge already exist.
     */
    @SuppressWarnings("unchecked")
    public void addEdge(L fromLabel, L toLabel, Double edgeValue) throws IllegalArgumentException
    {
        if(hasEdge(fromLabel, toLabel))
        {
            throw new IllegalArgumentException("Edge from" + fromLabel + "to " + toLabel + " already exists");
        }

        else if(!(hasEdge(fromLabel, toLabel)))
        {
            L edgeLabel = (L) (fromLabel + "-" + toLabel);
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
     * @throws: IllegalArgumentException if the edge already exist.
     */
    @SuppressWarnings("unchecked")
    public void addEdge(L fromLabel, L toLabel) throws IllegalArgumentException
    {
        if(hasEdge(fromLabel, toLabel))
        {
            throw new IllegalArgumentException("Edge from" + fromLabel + "to " + toLabel + " already exists");
        }

        else if(!(hasEdge(fromLabel, toLabel)))
        {
            L edgeLabel = (L) (fromLabel + "-" + toLabel);
            DSAGraphVertex origin = getVertex(fromLabel);
            DSAGraphVertex destination = getVertex(toLabel);
            DSAGraphEdge edge = new DSAGraphEdge(origin, destination, edgeLabel);
            edges.insertLast(edge);
            origin.addEdge(destination);
        }
    }

    /*
     * Checks if a vertex with the given label exists in the graph.
     * 
     * @param label: The label of the vertex to be checked.
     * 
     * @return: boolean.
     */
    public boolean hasVertex(L label)
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
     * @return: boolean.
     */
    public boolean hasEdge(L fromLabel, L toLabel)
    {
        boolean condition = false;

        for(DSAGraphEdge e : edges)
        {
            if((e.getTo().equals(toLabel)) && (e.getFrom().equals(fromLabel)))
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
     * @return: int.
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
     * @return: int.
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
     * @return: DSAGraphVertex.
     */
    public DSAGraphVertex getVertex(L label) 
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
     * @return: DSAGraphEdge.
     */
    public DSAGraphEdge getEdge(L label)
    {
        DSAGraphEdge edge = null;

        for(DSAGraphEdge e : edges)
        {
            if((e.getLabel()).equals(label))
            {
                edge = e;
            }
        }

        return edge;
    }

    /*
     * Gets the adjacent vertices of a vertex with the given label.
     * 
     * @param label: The label of the vertex.
     * 
     * @return: DSALinkedList<DSAGraphVertex>.
     */
    public DSALinkedList<DSAGraphVertex> getAdjacentVertex(L label) 
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
     * @return: boolean.
     */
    public boolean isAdjacent(L label1, L label2) 
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
     * @return: DSALinkedList<DSAGraphVertex>.
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
        System.out.print("\n");

        for(DSAGraphVertex v : vertices)
        {
            int i = 1;
            System.out.print(v.getLabel() + " -> [");

            for(DSAGraphVertex v2 : v.getAdjacent())
            {
                System.out.print(v2.getLabel());
                
                if(i < (v.getAdjacent()).getCount())
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
     * Performs a breath first search on the graph.
     * 
     * @param: void.
     * 
     * @return: DSAQueue<DSAGraphVertex>.
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
     * @return: DSAQueue<DSAGraphVertex>.
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
}