package Managers;

import java.util.Scanner;

import Colors.Colorize;
import MenusAndUIs.Menu;

public class GameManager {

	static Scanner sc = new Scanner(System.in);

	public static void playerDied()
	{
		System.out.println("You died on your jounreys!");
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

	public static void PlayerWon()
	{

	}

	// TODO use this somewhere, like maybe at the boss battle
	// System.out.println("It was a miss input\nMISSINPUT\nCALM DOWN\nYOU CALM THE FUCK DOWN\nTHERE WAS A MISSINPUT");
}
