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

	public static void battleMenu()
	{
		System.out.print(Colorize.CLEAR);
		System.out.println(Colorize.UNDERLINE + Colorize.RED + ">> BATTLE <<" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);
		System.out.println("You were attacked by:");
		EnemyManager.writeEnemies("short");

		System.out.println(Colorize.SEPARATOR_MEDIUM + Colorize.SEPARATOR_SMALL);
		System.out.println(Player.playerInfoString());
		
		System.out.println(Colorize.SEPARATOR_MEDIUM + Colorize.SEPARATOR_SMALL);
		System.out.println("You can now do the following:");
		System.out.println(" 1.> " + Colorize.RED + "Attack" + Colorize.RESET);
		System.out.println(" 2.> " + Colorize.YELLOW + "Defend" + Colorize.RESET + Colorize.ITALIC + " (allows taking a potion item)" + Colorize.RESET);
		System.out.println(" 3.> " + Colorize.BLUE + "Escape" + Colorize.RESET);

		System.out.print(Colorize.PROMPT);

		switch(Colorize.scannerize(sc.next()))
		{
			case "a":
			case "attack":
			case "1":
				chooseEnemy();
				break;
			case "d":
			case "defend":
			case "2":
				defendMenu();
				break;
			case "e":
			case "escape":
			case "3":
				BattleManager.escape();
				break;
			default:
				GameManager.missInput();
				battleMenu();
				break;
		}
	}

	public static void chooseEnemy()
	{
		System.out.print(Colorize.RESET + Colorize.CLEAR);
		System.out.println(Colorize.UNDERLINE + Colorize.RED + ">> BATTLE <<" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);
		System.out.println("You can choose from:");
		
		EnemyManager.writeEnemies("long");

		System.out.print(Colorize.PROMPT);
		String enemyInput = sc.next();
		enemyInput.toLowerCase();

		int enemyIndex = EnemyManager.getEnemyIndex(enemyInput);

		System.out.println("");

		if(enemyIndex == -1)
		{
			GameManager.missInput();
			chooseEnemy();
		}else{
			BattleManager.playerAttack(enemyIndex);
		}
	}

	public static void defendMenu()
	{
		System.out.println("");
		System.out.println("Do you want to use a " + Colorize.RED +"Potion?" + Colorize.RESET);
		System.out.println(" 1.> " + Colorize.GREEN + "Yes" + Colorize.RESET);
		System.out.println(" 2.> " + Colorize.RED + "No" + Colorize.RESET);

		System.out.print(Colorize.PROMPT);

		switch(Colorize.scannerize(sc.next()))
		{
			case "y":
			case "yes":
			case "1":
				BattleManager.defend(true);
				break;
			case "n":
			case "no":
			case "2":
				BattleManager.defend(false);
				break;
		}
	}
}
