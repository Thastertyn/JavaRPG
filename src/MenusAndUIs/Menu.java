package MenusAndUIs;

import java.util.Scanner;

import Colors.Colorize;
import Help.Help;
import Managers.GameManager;

public class Menu {

	// Each menu will have its own method

	/*
		Main menu
		Class choose
	*/

	static int failedTimes = 0;

	static Scanner sc = new Scanner(System.in);

	// Boolean for retrying - if the input was invalid, give true, to change the text
	// Sort of like my own try/catch
	public static void mainMenu()
	{

		System.out.print(Colorize.RESET + Colorize.CLEAR);
		System.out.println(Colorize.UNDERLINE + Colorize.MAGENTA + "> ⁠Main ⁠Menu ⁠<" + Colorize.RESET);
		System.out.println("----------------------------------");
		System.out.println("Welcome to the RPG game " + Colorize.capitalize(System.getProperty("user.name")));
		System.out.println("If you want help, run this program again with a \"--help\" flag (without the quotes)");

		System.out.println(" 1.> " + Colorize.GREEN + "Start" + Colorize.RESET);
		System.out.println(" 2.> " + Colorize.YELLOW + "Help" + Colorize.RESET);
		System.out.println(" 3.> " + Colorize.MAGENTA + "Quit" + Colorize.RESET);

		System.out.print(Colorize.PROMPT);
		String choice = sc.next();
		choice.toLowerCase();

		switch(choice)
		{
			// Start cases
			case "s":
			case "start":
			case "1":
				classChoose();
				break;
			case "help":
			case "h":
			case "2":
				Help.fullHelp(true);
				break;
			// Quit cases
			case "q":
			case "quit":
			case "3":
				System.out.println("Exiting...");
				System.exit(0);
				break;
			default:
				GameManager.missInput();
				mainMenu();
				break;
		}
	}

	public static void classChoose()
	{
		System.out.print(Colorize.CLEAR + Colorize.RESET);
		System.out.println(Colorize.UNDERLINE + Colorize.CYAN + "> ⁠Choose ⁠your ⁠class" + Colorize.RESET);
		System.out.println("----------------------------------");

		System.out.println("Choose your class. \nYou can choose from " + 
		"\n 1.> " + Colorize.MAGENTA + "Wizard" + Colorize.RESET + 
		"\n 2.> " + Colorize.CYAN + "Dwarf" + Colorize.RESET +
		"\n 3.> " + Colorize.WHITE + "Elf " + Colorize.RESET +
		"\n 4.> " + Colorize.YELLOW + "Human" + Colorize.RESET
		);
		//System.out.println("\n If you are unsure type \"help [classname]\" (eg. help wizard), or \"info\" for specifics about the class");

		System.out.print(Colorize.PROMPT);
		String classInput = sc.next();
		classInput.toLowerCase();

		// A flag wanna-be
		switch(classInput)
		{
			case "w":
			case "wizard":
			case "1":
				ClassChoose.chooseWizard();
				break;
			case "d":
			case "dwarf":
			case "2":
				ClassChoose.chooseDwarf();
				break;
			case "e":
			case "elf":
			case "3":
				ClassChoose.chooseElf();
				break;
			case "h":
			case "human":
			case "4":
				ClassChoose.chooseHuman();
				break;
			default:
				GameManager.missInput();
				classChoose();
				break;
		}
	}
}
