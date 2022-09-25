/*
 * Filename: UserInputs.java
 * Purpose: Contains the UserInputs class
 *
 * @author   : Naseh Rizvi
 * StudentNo : 20167671
 * Unit      : DSA
 * Date      : 25/09/22
 */

package dependencies;

import java.util.*;
import java.io.*;

public class UserInputs
{
    public static int userInputInt(int min, int max)
    {
        int value = min - 1;
        Scanner scan = new Scanner(System.in);

        while(!(value >= min && value <= max))
        {
            try
            {
                value = scan.nextInt();

                if(!(value >= min && value <= max))
                {
                    throw new IllegalArgumentException();
                }
            }
            
            catch(InputMismatchException e)
            {
                System.out.println("Invalid input, must be an integer.\n");
            }

            catch(IllegalArgumentException ex)
            {
                System.out.println("int");
                System.out.println("Invalid input, must be in bounds. Between " + String.valueOf(min) + " and " + String.valueOf(max) + "\n");
            }
            
            // Clears the buffer
            scan.nextLine();

        }
        
        return value;
    }

    public static int userInput(int min, int max)
    {
        int value = min - 1;
        Scanner scan = new Scanner(System.in);

        do
        {
            try
            {
                value = scan.nextInt();

                if(!(value >= min && value <= max))
                {
                    throw new IllegalArgumentException();
                }
            }
            
            catch(InputMismatchException e)
            {
                System.out.println("Invalid input, must be an integer.\n");
            }

            catch(IllegalArgumentException ex)
            {
                System.out.println("int");
                System.out.println("Invalid input, must be in bounds. Between " + min + " and " + max + "\n");
            }
            
            // Clears the buffer
            scan.nextLine();

        }while(!(value >= min && value <= max));
        
        return value;
    }
    
    public static double userInput(double min, double max)
    {
        double value = min - 1;
        Scanner scan = new Scanner(System.in);

        do
        {
            try
            {
                value = scan.nextDouble();
                
                if(!(value >= min && value <= max))
                {
                    throw new IllegalArgumentException();
                }
            }
            
            catch(InputMismatchException e)
            {
                System.out.println("Invalid input, must be a double.\n");
            }

            catch(IllegalArgumentException ex)
            {
                System.out.println("double");
                System.out.println("Invalid input, must be in bounds. Between " + min  + " and " + max + "\n");
            }
            
            // Clears the buffer
            scan.nextLine();

        }while(!(value >= min && value <= max));
        
        return value;
    }
    
    public static long userInput(long min, long max)
    {
        long value = min - 1;
        Scanner scan = new Scanner(System.in);

        do
        {
            try
            {
                value = scan.nextLong();

                if(!(value >= min && value <= max))
                {
                    throw new IllegalArgumentException();
                }
            }
            
            catch(InputMismatchException e)
            {
                System.out.println("Invalid input, must be a long.\n");
            }

            catch(IllegalArgumentException ex)
            {
                System.out.println("long");
                System.out.println("Invalid input, must be in bounds. Between " + min + " and " + max + "\n");
            }
            
            // Clears the buffer
            scan.nextLine();

        }while(!(value >= min && value <= max));
        
        return value;
    }

    public static float userInput(float min, float max)
    {
        float value = min - 1;
        Scanner scan = new Scanner(System.in);

        do
        {
            try
            {
                value = scan.nextFloat();

                if(!(value >= min && value <= max))
                {
                    throw new IllegalArgumentException();
                }
            }
            
            catch(InputMismatchException e)
            {
                System.out.println("Invalid input, must be a float.\n");
            }

            catch(IllegalArgumentException ex)
            {
                System.out.println("float");
                System.out.println("Invalid input, must be in bounds. Between " + min + " and " + max + "\n");
            }
            
            // Clears the buffer
            scan.nextLine();

        }while(!(value >= min && value <= max));
        
        return value;
    }

    public static char userInput(char min, char max)
    {
        String buffer;
        char value = min;
        Scanner scan = new Scanner(System.in);

        do
        {
            try
            {
                buffer = scan.nextLine();
                
                if(buffer.length() == 1)
                {
                    throw new InputMismatchException();
                }

                value = buffer.charAt(0);

                if(!(value >= min && value <= max))
                {
                    throw new IllegalArgumentException();
                }
            }
            
            catch(InputMismatchException e)
            {
                System.out.println("Invalid input, must be a character.\n");
            }
            
            catch(IllegalArgumentException ex)
            {
                System.out.println("char");
                System.out.println("Invalid input, must be in bounds. Between " + min + " and " + max + "\n");
            }

        }while(!(value >= min && value <= max));
        
        return value;
    }

    public static String userInput()
    {
        String string = null;
        Scanner scan = new Scanner(System.in);

        do
        {
            try
            {
                string = scan.nextLine();

                if(string == null || string.length() == 0)
                {
                    throw new IllegalArgumentException();
                }
            }

            catch(IllegalArgumentException ex)
            {
                System.out.println("Please enter a valid String.\n");
            }

        }while(string == null || string.length() == 0);

        return string;
    }
}

    