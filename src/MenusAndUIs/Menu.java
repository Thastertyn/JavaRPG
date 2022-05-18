package MenusAndUIs;

import Colors.Colorize;
import Help.Help;

import java.util.Scanner;

import Classes.DataAndOtherStuff;
import Classes.Inventory;
import Classes.Player;

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
	public static void mainMenu(boolean retry)
	{

		System.out.print(Colorize.RESET + Colorize.CLEAR);
		System.out.println(Colorize.UNDERLINE + Colorize.MAGENTA + "> ⁠Main ⁠Menu ⁠<" + Colorize.RESET);
		System.out.println("----------------------------------");

		if(retry)
		{
			failedTimes++;
			System.err.println(Colorize.RED + "Incorrect input, try again.\nFailed " + failedTimes  + " times" + Colorize.RESET + "\n");
		}else
		{
			System.out.println("Welcome to the RPG game " + Colorize.capitalize(System.getProperty("user.name")));
			System.out.println("If you want help, run this program again with a \"--help\" flag (without the quotes)");
			failedTimes = 0;
		}

		System.out.println(Colorize.GREEN + " 1.> Start" + Colorize.RESET);
		System.out.println(Colorize.YELLOW + " 2.> Help" + Colorize.RESET);
		System.out.println(Colorize.MAGENTA + " 3.> Quit" + Colorize.RESET);

		System.out.print(Colorize.PROMPT);
		String choice = sc.next();
		choice.toLowerCase();

		switch(choice)
		{
			// Start cases
			case "s":
			case "start":
			case "1":
				classChoose(false);
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
				mainMenu(true);
				break;
		}
	}

	public static void classChoose(boolean retry)
	{
		System.out.print(Colorize.CLEAR + Colorize.RESET);
		System.out.println(Colorize.UNDERLINE + Colorize.CYAN + "> ⁠Choose ⁠your ⁠class" + Colorize.RESET);
		System.out.println("----------------------------------");

		if(retry)
		{
			failedTimes++;
			System.err.println(Colorize.RED + "Incorrect input, try again.\nFailed " + failedTimes  + " times" + Colorize.RESET + "\n");
		}else{
			failedTimes = 0;
		}

		System.out.println("Choose your class. \nYou can choose from " + 
		"\n 1.> " + Colorize.MAGENTA + "Wizard" + Colorize.RESET + 
		"\n 2.> " + Colorize.CYAN + "Dwarf" + Colorize.RESET +
		"\n 3.> " + Colorize.WHITE + "Elf " + Colorize.RESET +
		"\n 4.> " + Colorize.YELLOW + "Human" + Colorize.RESET
		);
		System.out.println("\n If you are unsure type \"help [classname]\" (eg. help wizard), or \"info\" for specifics about the class");

		// https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
		// NextLine() uses the previous prompt of scanner that was used, or so I understand, so when a nextInt() or something has been used
		// before nextLine(), it will use the nextInt()'s prompt, not making a new one, only after the second one the prompt is made
		// (dumb)
		if(!retry)
		{
			sc.nextLine(); // WTF
		}
		
		/*
		int option = input.nextInt();
		input.nextLine();  // Consume newline left-over
		String str1 = input.nextLine();
		*/

		System.out.print(Colorize.PROMPT);
		String classInput = sc.nextLine();
		classInput.toLowerCase();

		// A flag wanna-be
		switch(classInput)
		{
			case "w":
			case "wizard":
			case "1":
				failedTimes = 0;
				Player.hp = DataAndOtherStuff.WIZARD_HP;
				Player.maxHP = DataAndOtherStuff.WIZARD_HP;
				Player.strength = DataAndOtherStuff.WIZARD_STRENGTH;
				Player.playerClass = "wizard";
				break;
			case "d":
			case "dwarf":
			case "2":
				failedTimes = 0;
				Player.hp = DataAndOtherStuff.DWARF_HP;
				Player.maxHP = DataAndOtherStuff.DWARF_HP;
				Player.strength = DataAndOtherStuff.DWARF_STRENGTH;
				Player.playerClass = "dwarf";
				break;
			case "e":
			case "elf":
			case "3":
				failedTimes = 0;
				Player.hp = DataAndOtherStuff.ELF_HP;
				Player.maxHP = DataAndOtherStuff.ELF_HP;
				Player.strength = DataAndOtherStuff.ELF_STRENGTH;
				Player.playerClass = "elf";
				break;
			case "h":
			case "human":
			case "4":
				failedTimes = 0;
				Player.hp = DataAndOtherStuff.HUMAN_HP;
				Player.maxHP = DataAndOtherStuff.HUMAN_HP;
				Player.strength = DataAndOtherStuff.HUMAN_STRENGTH;
				Player.playerClass = "human";
				break;
			default:
				String trimmedOfSpaces = classInput.replaceAll("\s", "");

				// https://howtodoinjava.com/java/string/get-first-4-characters/
				// check if the string more than 4 characters in length, since the term after breaks if it isn't
				// since there won't be any indexes for remaining characters (smort)
				if(trimmedOfSpaces.length() > 4 && trimmedOfSpaces.substring(0, 4).equals("help"))
				{
					Help.getHelp(trimmedOfSpaces.substring(4, trimmedOfSpaces.length()));
				}else{
					classChoose(true);
				}

				break;
		}
		
		Inventory.init();
		System.out.println(Player.playerInfoString());
		ActionMenu.mainMenu(false);
	}
}
