package Managers;

import java.util.Scanner;

import Colors.Colorize;
import MenusAndUIs.Menu;

public class GameManager {

	static Scanner sc = new Scanner(System.in);

	public static int failedTimes = 0;

	public static void playerDied()
	{
		System.out.println(Colorize.RAPID_BLINK + Colorize.RED + "You died on your jounreys!" + Colorize.RESET);
		System.out.println("You may be reincarnated as another player, or leave with the shame of a loss, the choise is yours");
		System.out.println(" 1.> Continue");
		System.out.println(" 2.> End");

		System.out.print(Colorize.PROMPT);
		String input = sc.next();
		input.toLowerCase();

		switch(input)
		{
			case "continue":
			case "c":
			case "1":
				System.out.println("You need to choose a class, to play as");
				sc.nextLine();
				Menu.classChoose(false);
				break;
			case "end":
			case "e":
			case "2":
				System.exit(0);
				break;
			default:

				break;
		}


	}

	public static void missInput()
	{
		failedTimes++;
		System.err.println(Colorize.RED + "Incorrect input, try again.\nFailed " + failedTimes  + " times" + Colorize.RESET + "\n");
		sc.nextLine();
	}

	public static void PlayerWon()
	{
		System.exit(69);
	}

	// TODO use this somewhere, like maybe at the boss battle
	// System.out.println("It was a miss input\nMISSINPUT\nCALM DOWN\nYOU CALM THE FUCK DOWN\nTHERE WAS A MISSINPUT");
}
