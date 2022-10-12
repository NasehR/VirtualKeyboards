/*
 * Filename: keyMeUp.java
 * Purpose: Main class for the KeyMeUp program
 *
 * @author   : Naseh Rizvi
 * StudentNo : 20167671
 * Unit      : DSA
 * Date      : 08/10/22
 */

public class keyMeUp 
{
    public static void main(String[] args) throws Exception 
    {
        if(args.length == 1)
        {
            if(args[0].equals("-i"))
            {
                System.out.println("\033[H\033[2J");
                modes.interactiveMenu();
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
                System.out.println("\033[H\033[2J");
                modes.silentMenu(args[1], args[2], args[3]);
            }

            else
            {
                System.out.println("Invalid option, the only option is -s");
            }
        }
        
        else
        {
            System.out.println("Invalid number of arguments");
        }
    }
}
