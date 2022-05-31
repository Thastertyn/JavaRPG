package Managers;

import java.util.Scanner;

import Classes.Player;
import Colors.Colorize;
import MenusAndUIs.ActionMenu;
import MenusAndUIs.Menu;

public class GameManager {

	static Scanner sc = new Scanner(System.in);

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
				Menu.classChoose();
				break;
			case "end":
			case "e":
			case "2":
				System.exit(0);
				break;
			default:
				GameManager.missInput();
				BattleManager.enemies.clear();
				playerDied();
				break;
		}
	}

	public static void missInput()
	{
		System.err.println(Colorize.RED + "Incorrect input, try again.\n" + Colorize.UNDERLINE + "Press Enter to retry" + Colorize.RESET);
		System.out.print(Colorize.PROMPT);
		sc.nextLine();
	}

	public static void PlayerWon()
	{
		System.out.println(Colorize.HIGH_INTENSITY + "Congratulations!");
		System.out.println("You won the best game to ever exist");
		System.out.println("And got 100 000 coins as your reward");
		Player.xp += 10000;
		Player.coins += 100000;

		System.out.println("You may exit, or get your level reset and play more");
		System.out.println("");
		System.out.println(" 1.> Continue");
		System.out.println(" 2.> Exit");

		System.out.print(Colorize.PROMPT);
		String input = sc.next();
		input = Colorize.scannerize(input);

		switch(input)
		{
			case "1":
			case "c":
			case "continue":
				Player.level = 0;
				Player.xp = 0;
				ActionMenu.mainMenu();
				break;
			case "e":
			case "exit":
			case "2":
				System.out.println("It was a miss input\nMISSINPUT\nCALM DOWN\nYOU CALM THE FUCK DOWN\nTHERE WAS A MISSINPUT");
				System.exit(69);
				break;
			default:
				missInput();
				sc.nextLine();
				PlayerWon();
		}
	}
}
