import java.io.*;
import java.util.*;
import dependencies.*;

public class modes 
{
    public static void interactiveMenu()
    {
        DSAGraph graph = new DSAGraph();
        DSAQueue<String> userInput = new DSAQueue<>();
        DSAQueue<String> path = new DSAQueue<>();
        DSAQueue<Double> distance = new DSAQueue<>();
        String fileName, vertex, fromVertex, toVertex, startVertex, endVertex;
        String string = "";
        char[] arr = new char[1];
        int optionNode, optionEdge, optionFile, input;

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
                        // System.out.println(string.length());

                        for(int i = 0; i < arr.length; i++)
                        {
                            if(graph.hasVertex(Character.toString(arr[i])))
                            {
                                userInput.enqueue(Character.toString(arr[i]));
                            }
                        }
                        break;

                    case 8:
                        System.out.println("Displaying path...");

                        int length = userInput.getCount();
                        
                        for(int i = 0; i < (length); i++)
                        {
                            startVertex = userInput.dequeue();
                            endVertex = userInput.peek();
                            System.out.print("Start: " + startVertex + " End: " + endVertex +"\n");
                            graph.Dijkstras(startVertex, endVertex);
                            System.out.println();
                            graph.displayFinal();
                            length = userInput.getCount();
                        }
                        
                        // NEED TO DISPLAY Dijkstra HERE
                        // PLUS AN OPTION TO SAVE

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
        }while(input != 0);
    }

    public static void silentMenu(String keyFile, String strFile, String pathFile)
    {
        try 
        {
            DSAGraph graph = new DSAGraph();
            System.out.println("keyFile: " + keyFile);
            System.out.println("strFile: " + strFile);
            System.out.println("pathFile: " + pathFile);

            graph = FileIO.fileToGraph(keyFile);
            graph.displayAsList();
            
            FileIO.readFile(strFile);
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
    }

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
                            "(7) Generate paths\n\t" +
                            "(8) Display path\n\t" +
                            "(9) Save keyboard\n\t" +
                            "(0) Exit\n"
                            );
    }

    private static void optionFile()
    {
        System.out.println(
                            "\nOptions: \n\t" +
                            "(1) Read a File\n\t" +
                            "(2) Read a SerialIzed File\n\t"
                            );
    }

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
