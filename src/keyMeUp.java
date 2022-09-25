/*
 * Filename: keyMeUp.java
 * Purpose: Main class for the KeyMeUp program
 *
 * @author   : Naseh Rizvi
 * StudentNo : 20167671
 * Unit      : DSA
 * Date      : 25/09/22
 */

import java.io.*;
import java.util.*;
import dependencies.*;

public class keyMeUp 
{
    public static void main(String[] args) throws Exception 
    {
        if(args.length == 1)
        {
            if(args[0].equals("-i"))
            {
                do
                {
                    interactiveMode();

                    int input = UserInputs.userInput(1, 9);

                    try
                    {
                        switch(input)
                        {
                            case 1:
                                System.out.println("Load keyboard file");
                                break;

                            case 2:
                                System.out.println("Node operations");
                                break;

                            case 3:
                                System.out.println("Edge operations");
                                break;

                            case 4:
                                System.out.println("Display graph");
                                break;

                            case 5:
                                System.out.println("Display graph information");
                                break;

                            case 6:
                                System.out.println("Enter string for finding path");
                                break;

                            case 7:
                                System.out.println("Generate paths");
                                break;

                            case 8:
                                System.out.println("Display path(s) (ranked, option to save)");
                                break;

                            case 9:
                                System.out.println("Save keyboard");
                                break;
                        }
                    }

                    // catch(FileNotFoundException ex)
                    // {
                    //     System.out.println("Unable to find file");
                    //     System.out.println("Enter a filename: ");
                    // }
        
                    // catch(IOException e)
                    // {
                    //     System.out.println(e.getMessage());
                    // }
                    
                    catch(IllegalArgumentException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }while(true);
            }

            else
            {
                System.out.println("Invalid option, the only option is -i");
            }

        }
    
        else if(args.length == 4)
        {
            if(args[0].equals("-s"))
            {
                System.out.println("Silent mode");
                
                try 
                {
                    String keyFile, strFile, pathFile;
                    keyFile = args[1];
                    strFile = args[2];
                    pathFile = args[3];
                    System.out.println("keyFile: " + keyFile);
                    System.out.println("strFile: " + strFile);
                    System.out.println("pathFile: " + pathFile);
                }

                catch(IllegalArgumentException e)
                {
                    System.out.println(e.getMessage());
                }

                // catch(FileNotFoundException ex)
                // {
                //     System.out.println("Unable to find file");
                //     System.out.println("Enter a filename: ");
                // }
    
                // catch(IOException e)
                // {
                //     System.out.println(e.getMessage());
                // }
            }

            else
            {
                System.out.println("Invalid option, the only option is -s");
            }
        }
    }

    private static void interactiveMode()
    {
        System.out.println("Interactive mode");
        System.out.println(
                            "Options: \n\t" +
                            "(1) Load keyboard file\n\t" +
                            "(2) Node operations\n\t" +
                            "(3) Edge operations\n\t" +
                            "(4) Display graph\n\t" +
                            "(5) Display graph information\n\t" +
                            "(6) Enter string for finding path\n\t" +
                            "(7) Generate paths\n\t" +
                            "(8) Display path(s) (ranked, option to save)\n\t" +
                            "(9) Save keyboard\n\t"
                            );
    }
}
