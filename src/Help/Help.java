package Help;

import java.util.Scanner;

import Colors.Colorize;
import MenusAndUIs.Menu;
import Classes.ASCII;
import Classes.DataAndOtherStuff;

public class Help {
    
    static Scanner sc = new Scanner(System.in);

    public static void getHelp(String classToBeHelpedWith)
    {
        if(classToBeHelpedWith.isEmpty())
        {
            fullHelp(true);
        }else{
            classHelp(classToBeHelpedWith);
        }
        System.out.println("Some useful help with " + classToBeHelpedWith);
        
        sc.next();
        
        Menu.classChoose();
    }

    public static void fullHelp(boolean shouldReturn)
    {
        System.out.println("JavaRPG - The best game of all time");
        System.out.println("You are in role of a player, wandering around an RPG-like world");
        System.out.println("Your goal is to get as far as you possibly can");
        System.out.print("\n");
        System.out.println("!! When it seems like nothing is happening, you most likely need to press enter !!");
        System.out.print("\n");
        System.out.println("The classes give you different ammounts of hp and strength, maybe even armor (not as of right now)");
        System.out.println("The enemies are ranked by \"tier\", aka their strength and hp");
        System.out.println("Player actions are pretty simple, allowing you to do 3 things,\nexplore (not as fancy as it sounds)\nhunt for enemies\nand craft (upgrade) items");
        System.out.print("\n");
        System.out.println("Exploring is easy, you just find a random location, get some loot and maybe fight some enemies");
        System.out.println("Hunting is just explicitely looking for trouble, you get 100% chance to meet enemies,\n");
        System.out.println("Crafting, though still WIP, will allow you to upgrade your gear, giving you more strength or hp");
        System.out.println("Thats pretty much it to this game");
        sc.nextLine();

        if(shouldReturn)
        {
            Menu.mainMenu();
        }
    }

    public static void flagHelp()
    {
        System.out.println("JavaRPG - The best game of all time");
        System.out.print("\n");
        System.out.println("Usage: \n\tjavarpg [" + Colorize.UNDERLINE + "FLAGS" + Colorize.RESET + "]");
        System.out.println("Options: \n\t-h or --help\n\t-bh or --bigger-help\n\t-i or --invincible\n\t-s or --super-strength");
    }

    public static void classHelp(String classString)
    {
        switch (classString) {
            case "wizard":
                System.out.print(Colorize.CLEAR);
                System.out.println(ASCII.WIZARD);
                System.out.println("Wizard has \nHP of " + DataAndOtherStuff.WIZARD_HP + ",\nDamage of " + DataAndOtherStuff.WIZARD_STRENGTH + "");
                sc.nextLine();
                break;
            case "dwarf":
                System.out.print("\033[H\033[2J");
                System.out.println("Dwarf is slow, strong and medium on hp. \n Press enter to continue");
                sc.next();
                break;
            case "info elf":
                System.out.print("\033[H\033[2J");
                System.out.println("Elf is fast, medium on hp and medium damage, \n but is ranged giving him couple of rounds of headstart before enemy gets close enough to him \n Press enter to continue");
                sc.next();
                //GetClass();
                break;
            case "human":
                System.out.print("\033[H\033[2J");
                System.out.println("Best of all worlds, he is medium in everything. \n Press enter to continue");
                sc.next();
                //GetClass();
                break;
        }

        Menu.classChoose();
    }
}
