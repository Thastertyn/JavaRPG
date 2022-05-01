import java.util.Scanner;

import Colors.Colorize;

public class Help {
    
    Scanner sc = new Scanner(System.in);

    public void mainHelp()
    {
        System.out.println("JavaRPG - The best game of all time");
        System.out.println("\n");
        System.out.println("Usage: \n    javarpg [" + Colorize.UNDERLINE + "FLAGS" + Colorize.RESET + "]");
        System.out.println("\n\n");
        System.out.println("Options: \n    -h or --help\n    -g or --god\n    -c or --color");
    }

    public void classHelp(String classString)
    {
        switch (classString) {
            case "wizard":
                System.out.print(Colorize.CLEAR);
                System.out.println(Classes.ASCII.WIZARD);
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
