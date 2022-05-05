package Help;

import java.util.Scanner;

import Colors.Colorize;
import MenusAndUIs.Menu;
import Classes.ASCII;

public class Help {
    
    static Scanner sc = new Scanner(System.in);

    public static void getHelp(String classToBeHelpedWith)
    {
        if(classToBeHelpedWith.isEmpty())
        {
            fullHelp();
        }else{
            classHelp(classToBeHelpedWith);
        }
        System.out.println("Some useful help with " + classToBeHelpedWith);
        
        sc.next();
        
        Menu.classChoose(false);
    }

    public static void fullHelp()
    {
		System.out.println("----------------------------------");
        System.out.println("JavaRPG - The best game of all time");
        System.out.print("\n");
        System.out.println("Usage: \n\tjavarpg [" + Colorize.UNDERLINE + "FLAGS" + Colorize.RESET + "]");
        System.out.println("Options: \n\t-h or --help\n\t-g or --god\n\t-c or --color");
    }

    public static void classHelp(String classString)
    {
        switch (classString) {
            case "wizard":
                System.out.print(Colorize.CLEAR);
                System.out.println(ASCII.WIZARD);
                System.out.println("Wizard is low hp, high damage and medium speed. \n Press enter to continue");
                sc.next();
                //GetClass();
                break;
            case "dwarf":
                System.out.print("\033[H\033[2J");
                System.out.println("Dwarf is slow, strong and medium on hp. \n Press enter to continue");
                sc.next();
                //GetClass();
                break;
            case "info elf":
                System.out.print("\033[H\033[2J");
                System.out.println("Elf is fast, medium on hp and medium damage, \n but is ranged giving him couple of rounds of headstart before enemy gets close enough to him \n Press enter to continue");
                sc.next();
                //GetClass();
                break;
            case "info human":
                System.out.print("\033[H\033[2J");
                System.out.println("Best of all worlds, he is medium in everything. \n Press enter to continue");
                sc.next();
                //GetClass();
                break;
        }
    }
}
