package main;
public class keyMeUp 
{
    public static void main(String[] args) throws Exception 
    {
        if(args.length == 1)
        {
            if(args[0].equals("-i"))
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
            }
        }
    }
}
