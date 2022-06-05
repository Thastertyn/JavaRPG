// The 200 line limit is dumb
package MenusAndUIs;

import Colors.Colorize;
import Managers.BattleManager;
import Managers.Crafting;
import Managers.GameManager;
import Managers.Searching.SearchManager;
import Classes.Inventory;
import Classes.Player;

import java.util.Random;
import java.util.Scanner;

public class ActionMenu {

	static Scanner sc = new Scanner(System.in);
	static Random rnd = new Random();

	public static void mainMenu()
	{
		System.out.print(Colorize.RESET + Colorize.CLEAR);
		System.out.println(Colorize.UNDERLINE + Colorize.GREEN + "> ⁠Choose ⁠Your ⁠Action" + Colorize.RESET);
		System.out.println("----------------------------------");
		System.out.println("You can now do the following:");
		System.out.println(" 1.> " + Colorize.GREEN + "Explore" + Colorize.RESET);
		System.out.println(" 2.> " + Colorize.MAGENTA + "Hunt" + Colorize.RESET);
		System.out.println(" 3.> " + Colorize.BLUE + "Inventory" + Colorize.RESET);

		System.out.print(Colorize.PROMPT);

		switch(Colorize.scannerize(sc.next()))
		{
			case "e":
			case "explore":
			case "1":
				System.out.println("You went to search for something");
				SearchManager.search();
				break;
			case "h":
			case "hunt":
			case "2":
				System.out.println("You went hunting something");
				BattleManager.startBattle(rnd.nextInt(1, 5), 1, 0);
				break;
			case "i":
			case "inventory":
			case "3":
				System.out.println("You opened your inventory");
				inventory();
				break;
			default:
				GameManager.missInput();
				mainMenu();
				break;
		}

		sc.nextLine();
	}

	public static void inventory()
	{
		System.out.print(Colorize.RESET + Colorize.CLEAR);
		System.out.println(Colorize.BLUE + Colorize.UNDERLINE + ">> ⁠" /*Punctuation space U+2008, cuz it's the only which would be underlined*/ + "Inventory" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);
		
		// Items
		System.out.println(" > " + Colorize.MAGENTA + "Weapon Tier" + Colorize.RESET + ": " + Inventory.get("weapon") + "/" + Player.maxWeapon);
		System.out.println(" > " + Colorize.BLUE + "Armor Level" + Colorize.RESET +": " + Inventory.get("armor") + "/" + Player.maxArmor);
		System.out.println(Colorize.SEPARATOR_SMALL);
		System.out.println(" > " + Colorize.YELLOW + "Wood" + Colorize.RESET + ": " + Inventory.get("wood"));
		System.out.println(" > " + Colorize.BACKGROUND_WHITE + Colorize.BLACK + "Iron" + Colorize.RESET + ": " + Inventory.get("iron"));
		System.out.println(" > " + Colorize.YELLOW + "Leather" + Colorize.RESET + ": " + Inventory.get("leather"));
		System.out.println(" > " + Colorize.RED  + "Potions" + Colorize.RESET + ": " + Inventory.get("potions"));
		System.out.println(" > " + Colorize.GREEN + "Gems" + Colorize.RESET + ": " + Inventory.get("gems"));

		System.out.println(Colorize.SEPARATOR_MEDIUM);

		// Crafting
		System.out.println(" 1.> " + Colorize.GREEN + "Crafting Menu" + Colorize.RESET);
		System.out.println(" 2.> " + Colorize.MAGENTA + "Statistics" + Colorize.RESET);
		System.out.println(" 3.> " + Colorize.YELLOW + "Back" + Colorize.RESET);

		System.out.print(Colorize.PROMPT);

		switch(Colorize.scannerize(sc.next()))
		{
			case "c":
			case "crafting":
			case "1":
				Crafting.craft();
				break;
			case "s":
			case "statistics":
			case "2":
				statistics();
				break;
			case "b":
			case "back":
			case "3":
				mainMenu();
				break;
			default:
				GameManager.missInput();
				inventory();
				break;
		}
	}

	public static void statistics()
	{
		System.out.print(Colorize.CLEAR + Colorize.RESET);
		System.out.println(Colorize.UNDERLINE + Colorize.CYAN + ">>> Statistics" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);

		System.out.println("Class: " + Player.classColor + Colorize.capitalize(Player.playerClass) + Colorize.RESET);
		System.out.println(Colorize.RED + "HP" + Colorize.RESET + ": " + Player.hp + "/" + Player.maxHP);
		System.out.println(Colorize.YELLOW + "Strength" + Colorize.RESET + ": " + Player.strength);
		System.out.println(Colorize.SEPARATOR_MEDIUM);
		System.out.println(Colorize.BLUE + "Level" + Colorize.RESET + ": " + Player.level);
		System.out.println(Colorize.MAGENTA + "XP" + Colorize.RESET + ": " + Player.xp);
		System.out.println(Colorize.RED + "Kills" + Colorize.RESET + ": " + Player.enemyKills);
		System.out.println(Colorize.YELLOW + "Coins" + Colorize.RESET + ": " + Player.coins);
		
		
		if(Player.isUsingSpecialFlags)
		{
			System.out.println(Colorize.CYAN + "Cheats" + Colorize.RESET + ":" + "true");
		}

		System.out.println("");

		System.out.println(" 1.> " + Colorize.YELLOW + "Back" + Colorize.RESET);

		System.out.print(Colorize.PROMPT);
		String input = sc.next();

		switch(Colorize.scannerize(input))
		{
			case "b":
			case "back":
			case "1":
				ActionMenu.inventory();
				break;
			default:
				GameManager.missInput();
				statistics();
		}
	}
}