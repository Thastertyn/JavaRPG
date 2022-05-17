import java.util.Scanner;

import Colors.Colorize;
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
            args[i].replaceAll("-", "");

            switch(args[i])
            {

            }
        }

        Menu.mainMenu(false);
        
        sc.close();
    }
}