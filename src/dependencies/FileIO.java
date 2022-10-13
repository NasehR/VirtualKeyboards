/*
 * Filename: FileIO.java
 * Purpose: Contains the DSAStack class
 *
 * @author   : Naseh Rizvi
 * StudentNo : 20167671
 * Unit      : DSA
 * Date      : 04/10/22
 * Practical : 06
 */

package dependencies;

import java.io.*;
import java.util.*;

import dependencies.DSAGraph.DijkstrasStacks;

public class FileIO
{
    /*
     * Read a file and converts it to a graph
     * 
     * @param: fileName.
     * 
     * @return: DSAGraph<String>.
     * 
     * @FileNotFoundException: File could not be found.
     */
    public static DSAGraph fileToGraph(String fileName) throws FileNotFoundException
    {
        String line;
        DSAGraph graph = new DSAGraph();

        try
        {
            Scanner sc = new Scanner(new File(fileName));

            do
            {
                line = sc.nextLine();
                lineToGraph(line, graph);

            }while(sc.hasNextLine());

            sc.close();

        }
        
        catch(FileNotFoundException ex)
        {
            throw new FileNotFoundException("File can not be found.");
        }

        return graph;
    }

    /*
     * Reads the line of a file to a graph.
     * 
     * @param: line.
     * @param: DSAGraph<String>.
     * 
     * @return: void.
     */
    private static void lineToGraph(String line, DSAGraph graph) 
    {
        String[] lineElements = line.split(" ");
            
        try
        {
            for(int i = 0; i < lineElements.length; i++)
            {
                if(!(graph.hasVertex(lineElements[i])))
                {
                    graph.addVertex(lineElements[i]);
                }
            }
            for(int i = 1; i < lineElements.length; i++)
            {
                graph.addEdge(lineElements[0], lineElements[i]);
            }
            
        }

        catch(IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Invalid format for the file.");
        }
    
    }   

    /*
     * Saves the graph to a file Serialized.
     * 
     * @param: DSAGraph<String>.
     * @param: fileName.
     * 
     * @return: void.
     * 
     * @IOException: Could not write file.
     */
    public static void graphToFile(String fileName, DSAGraph graph) throws IOException
    {
        FileOutputStream fileStream = null;
        ObjectOutputStream objStream = null;

        try
        {
            fileStream = new FileOutputStream(fileName);
            objStream = new ObjectOutputStream(fileStream);
            objStream.writeObject(graph);
            objStream.close();
            System.out.println("Serializing...");
            System.out.println("Serialization complete.");
        }

        catch(IOException e)
        {
            if(fileStream != null)
            {
                try
                {
                    fileStream.close();
                }
				
                catch(IOException e2)
                {
                    throw new IOException(e2.getMessage());
                }
            }

            throw new IOException(e.getMessage());
        }
    }

    /*
     * Reads a file and splits the string into character array.
     * 
     * @param: fileName.
     * 
     * @return: void.
     * 
     * @IOException: Could not read file.
     */
    public static void readFile(String fileName) throws IOException
    {
        FileInputStream fileStream = null;
        InputStreamReader rdr;
        BufferedReader buffRdr;
        int lineNum;
        String line;
        char[] arr;

        try
        {
            fileStream = new FileInputStream(fileName);
            rdr = new InputStreamReader(fileStream);
            buffRdr = new BufferedReader(rdr);
        
            lineNum = 0;
            line = buffRdr.readLine();
            while(line != null)
            {
                lineNum++;
                arr = stringToCharArray(line);
                line = buffRdr.readLine();
            }

            fileStream.close();
        }

        catch(IOException e)
        {
            if(fileStream != null)
            {
                try
                {
                    fileStream.close();
                }

                catch(IOException e2)
                {
                    throw new IOException("Error reading file");
                }
            }

            System.out.println("Error in file Processing: " + e.getMessage() + "\n");

        }
    
        catch(IllegalArgumentException e3)
        {
            System.out.println(e3.getMessage());
        }
    }

    /*
     * Converts a string into a character array.
     * 
     * @param: string.
     * 
     * @return: char[].
     */
    private static char[] stringToCharArray(String string)
    {
        char[] arr = string.toCharArray();

        // for(int i = 0; i < string.length(); i++)
        // {
        //     System.out.println(arr[i]);
        // }

        return arr;
    }  

    /*
     * Loads a graph from a serialized file.
     * 
     * @param: fileName.
     * 
     * @return: DSAGraph<String>.
     * 
     * @IOException: Incorrect input.
     */
    public static DSAGraph load(String fileName) throws IOException
    {
        FileInputStream fileStream = null;
        ObjectInputStream objStream = null;
        DSAGraph graph = new DSAGraph();
        
        try
        {        
            fileStream = new FileInputStream(fileName);
            objStream = new ObjectInputStream(fileStream);
            graph = (DSAGraph) objStream.readObject();
            objStream.close();
            System.out.println("Deserialization complete.");
        }

        catch(ClassNotFoundException e)
        {
            System.out.println("Class DSALinkedList not found" + e.getMessage());
        }

        catch(IOException e)
        {
            if(fileStream != null)
            {
                try
                {
                    fileStream.close();
                }
                catch(IOException e2)
                {
                    throw new IOException(e2.getMessage());
                }
            }

            throw new IOException(e.getMessage());        
        }

        return graph;
    }

    /*
     * Writes a csv file containing the shortest path and the overall cost.
     * 
     * @param filename: file where the output is stored.
     * @param startVertex: label of the starting vertex.
     * @param endVertex: label of the ending vertex.
     * @param overallPath: Linkedlist of all vertices in the path.
     * @param cost: cost of the path.
     */
    public static void writeCSV(String filename, String startVertex, String endVertex, DSALinkedList<String> overallPath, double cost) throws FileNotFoundException
    {
        BufferedWriter bw = null;
        FileWriter fileWriter = null;

        try
        {
            fileWriter = new FileWriter(filename, true);
            bw = new BufferedWriter(fileWriter);

            bw.write("SHORTEST PATH FROM " + startVertex + " TO " + endVertex + ":" + "\r\n");
            int c = overallPath.getCount();

            
            for(int i = 0; i < c; i++)
            {
                bw.write(overallPath.removeFirst());

                if(i < (c - 1))
                {
                    bw.write("->");
                }
            }

            bw.write("\nDistance: " + (c - 1) + "\n");
            bw.write("\nOverall Distance: " + cost + "\n\n");

            bw.close();
            
        }

        catch(FileNotFoundException e)
        {
            throw new FileNotFoundException("Error writing to file " + filename);
        }

        catch (IOException e) 
        {
            System.out.println("exception occurred" + e);
        }
    }
}