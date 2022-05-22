package MenusAndUIs;

import java.util.Random;
import java.util.Scanner;

import Classes.Player;
import Colors.Colorize;
import Managers.BattleManager;
import Managers.EnemyManager;
import Managers.GameManager;

public class BattleMenu {

	static Scanner sc = new Scanner(System.in);
	static Random rnd = new Random();

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

		System.out.println("You were attacked by:");
		EnemyManager.writeEnemies("short");

		System.out.println(Colorize.SEPARATOR_MEDIUM);
		System.out.println(Player.playerInfoString());
		System.out.println(Colorize.SEPARATOR_MEDIUM);
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
				chooseEnemy();
				break;
			case "d":
			case "defend":
			case "2":
				defend();
				break;
			case "f":
			case "flee":
			case "3":
				escape();
				break;
			default:
				battleMenu(true);
				break;
		}
	}

	public static void chooseEnemy()
	{
		System.out.print(Colorize.RESET + Colorize.CLEAR);
		System.out.println(Colorize.RED + ">> BATTLE <<" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);
		System.out.println("You can choose from:");
		
		EnemyManager.writeEnemies("long");

		System.out.print(Colorize.PROMPT);
		String enemyInput = sc.next();
		enemyInput.toLowerCase();

		int enemyIndex = EnemyManager.getEnemyIndex(enemyInput);

		//int enemyIndex = EnemyManager.writtenPositions.get(Integer.parseInt(enemyInput));
		//int enemyIndex = EnemyManager.getEnemy(enemyInput);
		System.out.println(enemyIndex);

		if(enemyIndex == -1)
		{
			GameManager.missInput();
			chooseEnemy();
		}else{
			BattleManager.playerAttack(enemyIndex);
		}
	}

	public static void defend()
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

		BattleManager.enemyAttack();
	}

	public static void escape()
	{
		int escaped = rnd.nextInt(1);

		if(escaped == 0)
		{
			System.out.println("You successfully escaped");
			sc.nextLine();
			ActionMenu.mainMenu(false);
		}else{
			System.out.println("You tried escaping, but failed");
			BattleManager.enemyAttack();
		}
	}
}
