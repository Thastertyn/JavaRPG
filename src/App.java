import java.util.Scanner;

import Classes.Player;
import Colors.Colorize;
import Help.Help;
import MenusAndUIs.Menu;

public class App {

    // For Brackeys
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println(Colorize.CLEAR);
        
        System.out.println(Colorize.MAGENTA +  "Hello, World!" + Colorize.RESET);

        for (int i = 0; i < args.length; i++)
        {
            args[i].toLowerCase();

            switch(args[i])
            {
                case "-h":
                case "--help":
                    Help.flagHelp();
                    break;
                case "-bh":
                case "--bigger-help":
                    Help.fullHelp(false);
                    break;
                case "-i":
                case "--invincible":
                    Player.isInvincible = true;
                    break;
                case "-s":
                case "--super-strength":
                    Player.isSuperStrong = true;
                    break;
            }
        }

        Menu.mainMenu();
        
        sc.close();
    }
}