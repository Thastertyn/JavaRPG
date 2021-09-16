package Main.src;

import java.util.Random;
import java.util.Scanner;

public class App {

    // For Brackeys
    public static Random rng = new Random();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.print("\033[H\033[2J");
        System.out.println("Hello, World!");
        System.out.println("Welcome to the RPG game \n > Start\n > Exit");

        String mainMenuButton = sc.nextLine();
        mainMenuButton.toLowerCase();

        // Main Menu of some sort
        switch(mainMenuButton)
        {
            case "exit":
                System.out.println("Exiting...");
                break;
            case "start":      
                GameManager.ChooseClass();
                break;
            default:
                System.out.println("Incorrect input, exiting...");
                break;
        }
    }
}