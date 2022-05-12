package MenusAndUIs;

import java.util.Scanner;

import Classes.DataAndOtherStuff;
import Classes.Player;
import Colors.Colorize;
import Managers.BattleManager;
import MenusAndUIs.Menu;

public class BattleMenu {

	static Scanner sc = new Scanner(System.in);

	static int failedTimes = 0;

	public static void battleMenu(boolean retry)
	{
		if(retry)
		{
			failedTimes++;
			System.err.println(Colorize.RED + "Incorrect input, try again.\nFailed " + failedTimes  + " times" + Colorize.RESET + "\n");
		}else{
			failedTimes = 0;
		}

		System.out.println(Colorize.RED + "! You were attacked !" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);
		System.out.println("You can now do the following:");
		System.out.println(" 1.> Attack");
		System.out.println(" 2.> Defend (allows taking a potion item)");
		System.out.println(" 3.> Flee");

		System.out.print(Colorize.PROMPT);

		String input = sc.next();
		input.toLowerCase();

		switch(input)
		{
			case "a":
			case "attack":
			case "1":
				chooseEnemy(false);
				break;
			case "d":
			case "defend":
			case "2":
				Menu.mainMenu(false);
				break;
			case "f":
			case "flee":
			case "3":
				Player.escape();
				break;
			default:
				battleMenu(true);
				break;
		}
	}

	public static void chooseEnemy(boolean retry)
	{
		System.out.println("You can choose from:");
		
		int enemyPos = 1;
		for(int i = 0; i < BattleManager.enemyCounts.length; i++)
		{
			if(BattleManager.enemyCounts[i] != 0)
			{
				if(BattleManager.enemyCounts[i] == 1)
				{
					System.out.println(" " + enemyPos + ".> " + BattleManager.enemyCounts[i] + " " + DataAndOtherStuff.ENEMY_IDS[i]);
				}else{
					String plural = (DataAndOtherStuff.ENEMY_IDS[i].equals("witch")) ? "es" : "s";
					System.out.println(" " + enemyPos + ".> " + BattleManager.enemyCounts[i] + " " + DataAndOtherStuff.ENEMY_IDS[i] + plural);
				}
				enemyPos++;
			}
		}
	}

	public static void usePotion()
	{
		System.out.println("Do you want to use a potion?");
		System.out.println(" 1.> Yes");
		System.out.println(" 2.> No");

		System.out.print(Colorize.PROMPT);

		String input = sc.next();
		input.toLowerCase();

		switch(input)
		{
			case "y":
			case "yes":
			case "1":
				Player.defend(true);
				break;
			case "n":
			case "no":
			case "2":
				Player.defend(false);
				break;
		}
	}
}
