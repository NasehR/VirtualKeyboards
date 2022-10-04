package dependencies;

import java.io.*;
import java.util.*;

public class FileIO
{
    public static DSAGraph<String, Object> readFile(String fileName) throws FileNotFoundException
    {
        String line;
        DSAGraph<String, Object> graph = new DSAGraph<>();

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

    private static void lineToGraph(String line, DSAGraph<String, Object> graph) 
    {
        String[] lineElements = line.split(" ");
    
        try
        {
            if(lineElements.length == 2)
            {
                for(int i = 0; i < lineElements.length; i++)
                {
                    if(!(graph.hasVertex(lineElements[i])))
                    {
                        graph.addVertex(lineElements[i]);
                    }
                }
                graph.addEdge(lineElements[0], lineElements[1]);
            }       
            
            if(lineElements.length == 3)
            {
                for(int i = 0; i < (lineElements.length - 1); i++)
                {
                    if(!(graph.hasVertex(lineElements[i])))
                    {
                        graph.addVertex(lineElements[i]);
                    }
                }
                graph.addEdge(lineElements[0], lineElements[1], lineElements[2]);
            }
        }

        catch(IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Invalid format for the file.");
        }
    
    }   
}