package Help;

import java.util.Scanner;

import Colors.Colorize;
import MenusAndUIs.Menu;

public class Help {
    
    static Scanner sc = new Scanner(System.in);

    public static void fullHelp(boolean shouldReturn)
    {
        System.out.println("JavaRPG - The best game of all time");
        System.out.println("You are in role of a player, wandering around an RPG-like world");
        System.out.println("Your goal is to get as far as you possibly can");
        System.out.println("");
        System.out.println("!! When it seems like nothing is happening, you most likely need to press enter !!");
        System.out.println("");
        System.out.println("The classes give you different ammounts of hp and strength, and even armor");
        System.out.println("The enemies are ranked by \"tier\", aka their strength and hp");
        System.out.println("Player actions are pretty simple, allowing you to do 3 things,\nexplore (not as fancy as it sounds)\nhunt for enemies\nand craft (upgrade) items");
        System.out.println("");
        System.out.println("Exploring is easy, you just find a random location, get some loot and maybe fight some enemies");
        System.out.println("Hunting is just explicitely looking for trouble, you get 100% chance to meet enemies,");
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
        System.out.println("Options: \n\t-h or --help\n\t-bh or --bigger-help\n\t-i or --invincible\n\t-s or --super-strength\n\t-sd or --save-data");
        System.exit(0);
    }
}
