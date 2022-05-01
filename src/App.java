import java.util.Scanner;

import Colors.Colorize;

public class App {

    // For Brackeys
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println(Colorize.CLEAR);
        
        System.out.println(Colorize.MAGENTA +  "Hello, World!" + Colorize.RESET);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Menu menu = new Menu();

        menu.mainMenu(false);

        sc.close();
    }
}