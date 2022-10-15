/*
 * Filename: modes.java
 * Purpose: Different menu option depending on user input at runtime
 *
 * @author   : Naseh Rizvi
 * StudentNo : 20167671
 * Unit      : DSA
 * Date      : 13/10/22
 */

import java.io.*;
import java.util.*;

public class Modes 
{
    /*
     * A menu for the user to interact with the modes.
     * 
     * @param: void
     * 
     * @return: void
     */
    public static void interactiveMenu()
    {
        DSAGraph<String> graph = new DSAGraph<>();
        DSALinkedList<String> OP = new DSALinkedList<>();
        DSAQueue<String> word = new DSAQueue<>();
        DSAQueue<String> path = new DSAQueue<>();
        DSAQueue<Double> distance = new DSAQueue<>();
        String fileName, vertex, fromVertex, toVertex, startVertex, endVertex;
        String string = "";
        char[] arr = new char[1];
        int optionNode, optionEdge, optionFile, optionSave, input;

        do
        {
            interactiveMode();
            input = UserInputs.userInput(0, 9);

            try
            {
                switch(input)
                {
                    case 1:
                        optionFile();
                        optionFile = UserInputs.userInput(1,2);

                        switch(optionFile)
                        {
                            case 1:
                                System.out.print("Name of the keyboard file: ");
                                fileName = UserInputs.userInput();
                                System.out.println("Loading " + fileName + " ...\n");
                                graph = FileIO.fileToGraph(fileName);
                                break;

                            case 2:
                                System.out.print("Name of the keyboard file: ");
                                fileName = UserInputs.userInput();
                                System.out.println("Loading " + fileName + " ...\n");
                                graph = FileIO.load(fileName);
                                break;
                        }
                        break;

                    case 2:
                        do
                        {
                            nodeOperation();
                            optionNode = UserInputs.userInput(0, 3);

                            switch(optionNode)
                            {
                                case 1:
                                    String newVertex;
                                    System.out.print("Enter a vertex: ");
                                    newVertex = UserInputs.userInput();
                                    graph.addVertex(newVertex);
                                    System.out.println("Adding " + newVertex + " ...");
                                    System.out.println("Vertex " + newVertex + " has been added.");
                                    break;

                                case 2:
                                    String deletedVertex;
                                    System.out.print("Enter a vertex: ");
                                    deletedVertex = UserInputs.userInput();
                                    
                                    if(graph.hasVertex(deletedVertex))
                                    {
                                        graph.removeVertex(deletedVertex);
                                        System.out.println("Deleting edges to and from " + deletedVertex + "...");
                                        System.out.println("Deleting Vertex " + deletedVertex + " ...");
                                        System.out.println("Vertex " + deletedVertex + " has been deleted.");
                                    }

                                    else
                                    {
                                        System.out.println("Vertex " + deletedVertex + " is not in the graph.");
                                    }
                                    break;

                                case 3:
                                    System.out.print("Enter vertex: ");
                                    vertex = UserInputs.userInput();
                                    System.out.println("Finding vertex " + vertex + " ...");
                                    
                                    if(graph.hasVertex(vertex))
                                    {
                                        System.out.println("Vertex " + vertex + " is in the graph.");
                                    }

                                    else
                                    {
                                        System.out.println("Vertex " + vertex + " is not in the graph.");
                                    }
                                    break;
                            }
                        }while(optionNode != 0);
                        break;

                    case 3:
                        do
                        {
                            edgeOperation();
                            optionEdge = UserInputs.userInput(0, 3);

                            switch(optionEdge)
                            {
                                case 1:
                                    System.out.print("Enter origin vertex: ");
                                    fromVertex = UserInputs.userInput();
                                    System.out.print("Enter destination vertex: ");
                                    toVertex = UserInputs.userInput();
                                    graph.addEdge(fromVertex, toVertex);
                                    System.out.println("Adding edge " + fromVertex + "-" + toVertex + "...");
                                    System.out.println("Edge " + fromVertex + "-" + toVertex + " has been added.");
                                    break;

                                case 2:
                                    System.out.print("Enter origin vertex: ");
                                    fromVertex = UserInputs.userInput();
                                    System.out.print("Enter destination vertex: ");
                                    toVertex = UserInputs.userInput();
                                    
                                    if(graph.hasEdge(fromVertex, toVertex))
                                    {
                                        graph.removeEdge(fromVertex, toVertex);
                                        System.out.println("Deleting edge " + fromVertex + "-" + toVertex + "...");
                                        System.out.println("Edge " + fromVertex + "-" + toVertex + " has been deleted.");
                                    }

                                    else
                                    {
                                        System.out.println("Edge " + fromVertex + "-" + toVertex + " does not exist.");
                                    }
                                    break;
                                    
                                case 3:
                                    System.out.print("Enter origin vertex: ");
                                    fromVertex = UserInputs.userInput();
                                    System.out.print("Enter destination vertex: ");
                                    toVertex = UserInputs.userInput();

                                    if(graph.hasEdge(fromVertex, toVertex))
                                    {
                                        System.out.println("Finding edge " + fromVertex + "-" + toVertex + "...");
                                        System.out.println("Edge " + fromVertex + "-" + toVertex + " is in the graph.");
                                    }

                                    else
                                    {
                                        System.out.println("Edge " + fromVertex + "-" + toVertex + " does not exist.");
                                    }
                                    break;
                            }
                        }while(optionEdge != 0);
                        break;

                    case 4:
                        graph.displayAsList();
                        break;

                    case 5:
                        graph.displayInfo(); 
                        break;

                    case 6:
                        System.out.println("Enter string for finding path");
                        string = UserInputs.userInput();
                        System.out.println("You entered: " + string);
                        arr = string.toCharArray();
                        break;

                    case 7:
                        System.out.println("Generating path...");

                        for(int i = 0; i < arr.length; i++)
                        {
                            if(graph.hasVertex(Character.toString(arr[i])))
                            {
                                word.enqueue(Character.toString(arr[i]));
                            }

                            else if(graph.hasVertex((Character.toString(arr[i])).toLowerCase()))
                            {
                                word.enqueue((Character.toString(arr[i])).toLowerCase());
                            }

                            if(arr[i] == ' ')
                            {
                                if(graph.hasVertex("space"))
                                {
                                    word.enqueue("space");
                                }
                            }
                        }
                        break;

                    case 8:
                        System.out.println("Displaying path...");
                        
                        System.out.println(
                            "\nOptions: \n\t" +
                            "(1) Save the paths (output.csv)\n\t" +
                            "(0) Do not save\n\t"
                            );

                        int length = word.getCount();
                        optionSave = UserInputs.userInput(0, 1);

                        switch(optionSave)
                        {
                            case 1:
                                double cost, currentCost;
                                cost = 0;

                                for(int i = 0; i < (length - 1); i++)
                                {
                                    startVertex = word.dequeue();
                                    endVertex = word.peek();
                                    System.out.print("Start: " + startVertex + " End: " + endVertex +"\n");
                                    graph.Dijkstras(startVertex, endVertex);
                                    System.out.println();
                                    graph.displayFinal();
                                    OP = graph.getOverallPath();
                                    
                                    if(graph.getOverallPath().getCount() > 0)
                                    {
                                        currentCost =  (double) (graph.getOverallPath().getCount() - 1);
                                    }

                                    else
                                    {
                                        currentCost =  (double) (graph.getOverallPath().getCount());
                                    }
                                    
                                    cost = cost + currentCost;
                                    FileIO.writeCSV("output.csv", startVertex, endVertex, OP, cost);

                                    if(i == length - 2)
                                    {
                                        word.dequeue();
                                    }
                                }
                                break;
                            
                            case 0:
                                for(int i = 0; i < (length + 1); i++)
                                {
                                    startVertex = word.dequeue();
                                    endVertex = word.peek();
                                    System.out.print("Start: " + startVertex + " End: " + endVertex +"\n");
                                    graph.Dijkstras(startVertex, endVertex);
                                    System.out.println();
                                    graph.displayFinal();
                                }
                                break;
                        }
                        break;

                    case 9:
                        System.out.print("Name of the keyboard file: ");
                        fileName = UserInputs.userInput();
                        FileIO.graphToFile(fileName, graph);
                        break;
                }
            }

            catch(FileNotFoundException e)
            {
                System.out.println("Unable to find file");
                System.out.println("Enter a valid filename: ");
            }

            catch(IOException e2)
            {
                System.out.println(e2.getMessage());
            }

            catch(IllegalArgumentException e3)
            {
                System.out.println(e3.getMessage());
            }

            catch(NullPointerException e4)
            {
                System.out.println(e4.getMessage());
            }

            catch(NoSuchElementException e5)
            {
                System.out.println();
            }
        }while(input != 0);
    }

    /*
     * A menu for the user to find paths on the keyboard of choice and save it.
     * 
     * @param keyFile: The name of the file containing the keyboard.
     * @param strFile: The name of the file containing the string.
     * @param pathFile: The name of the file in which the path will be saved.
     * 
     * @return: void
     */
    public static void silentMenu(String keyFile, String strFile, String pathFile)
    {
        try 
        {
            DSAGraph<String> graph = new DSAGraph<>();
            DSALinkedList<String> OP = new DSALinkedList<>();
            DSAQueue<String> lines = new DSAQueue<>();
            DSAQueue<String> word = new DSAQueue<>();
            String startVertex, endVertex, line;
            int wordLength, lineLength;
            double cost, currentCost;
            
            graph = FileIO.fileToGraph(keyFile);            
            FileIO.readFile(strFile, lines);
            
            lineLength = lines.getCount();
            while(!(lines.isEmpty()))
            {
                cost = 0;
                line = lines.dequeue();
                char[] arr = line.toCharArray();
                for(int i = 0; i < arr.length; i++)
                {
                    if(graph.hasVertex(Character.toString(arr[i])))
                    {   
                        word.enqueue(Character.toString(arr[i]));
                    }
                    
                    else if(graph.hasVertex((Character.toString(arr[i])).toLowerCase()))
                    {
                        word.enqueue((Character.toString(arr[i])).toLowerCase());
                    }

                    if(arr[i] == ' ')
                    {
                        if(graph.hasVertex("space"))
                        {
                            word.enqueue("space");
                        }
                    }
                }
                
                wordLength = word.getCount();

                for(int i = 0; i < (wordLength - 1); i++)
                {
                    startVertex = word.dequeue();
                    endVertex = word.peek();
                    graph.Dijkstras(startVertex, endVertex);
                    OP = graph.getOverallPath();
                    if(graph.getOverallPath().getCount() > 0)
                    {
                        currentCost =  (double) (graph.getOverallPath().getCount() - 1);
                    }
                    else
                    {
                        currentCost =  (double) (graph.getOverallPath().getCount());
                    }
                    cost = cost + currentCost;
                    FileIO.writeCSV(pathFile, startVertex, endVertex, OP, cost);

                    if(i == wordLength - 2)
                    {
                        word.dequeue();
                    }
                }
            }
        }

        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }

        catch(FileNotFoundException e2)
        {
            System.out.println("Unable to find file");
            System.out.println("Enter a filename: ");
        }

        catch(IOException e3)
        {
            System.out.println(e3.getMessage());
        }

        catch(NoSuchElementException e4)
        {
            System.out.println();
        }
    }

    /*
     * Displays the menu to the user.
     * 
     * @param: void
     * 
     * @return: void
     */
    private static void interactiveMode()
    {
        System.out.println("Interactive mode");
        System.out.println(
                            "\nOptions: \n\t" +
                            "(1) Load keyboard file\n\t" +
                            "(2) Node operations\n\t" +
                            "(3) Edge operations\n\t" +
                            "(4) Display graph\n\t" +
                            "(5) Display graph information\n\t" +
                            "(6) Enter string for finding path\n\t" +
                            "(7) Generate path\n\t" +
                            "(8) Display path\n\t" +
                            "(9) Save keyboard\n\t" +
                            "(0) Exit\n"
                            );
    }

    /*
     * Displays the different ways to read the file to the user.
     * 
     * @param: void
     * 
     * @return: void
     */
    private static void optionFile()
    {
        System.out.println(
                            "\nOptions: \n\t" +
                            "(1) Read a File\n\t" +
                            "(2) Read a SerialIzed File\n\t"
                            );
    }

    /*
     * Displays the different operations to perform on nodes.
     * 
     * @param: void
     * 
     * @return: void
     */
    private static void nodeOperation()
    {
        System.out.println(
                            "\nOptions: \n\t" +
                            "(1) Add A Node\n\t" +
                            "(2) Delete A Node\n\t" +
                            "(3) Find A Node\n\t" +
                            "(0) Exit\n\t"
                            );
    }

    /*
     * Displays the different operations to perform on edges.
     * 
     * @param: void
     * 
     * @return: void
     */
    private static void edgeOperation()
    {
        System.out.println(
                            "\nOptions: \n\t" +
                            "(1) Add An Edge\n\t" +
                            "(2) Delete An Edge\n\t" +
                            "(3) Find An Edge\n\t" +
                            "(0) Exit\n\t"
                            );
    }
}
