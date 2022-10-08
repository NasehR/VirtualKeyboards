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

public class FileIO
{
    /*
     * Read a file and converts it to a graph
     * 
     * @param: fileName.
     * 
     * @return: DSAGraph<String>.
     */
    public static DSAGraph<String> fileToGraph(String fileName) throws FileNotFoundException
    {
        String line;
        DSAGraph<String> graph = new DSAGraph<>();

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
    private static void lineToGraph(String line, DSAGraph<String> graph) 
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
     * Reads a file and splits the string into character array.
     * 
     * @param: fileName.
     * 
     * @return: void.
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

        for(int i = 0; i < string.length(); i++)
        {
            System.out.println(arr[i]);
        }

        return arr;
    }  
}