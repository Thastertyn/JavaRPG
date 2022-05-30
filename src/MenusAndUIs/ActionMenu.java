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

	static int failedTimes = 0;

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

		String actionInput = sc.next();
		actionInput.toLowerCase();

		System.out.println(Colorize.PROMPT);

		switch(actionInput)
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
				BattleManager.startBattle(rnd.nextInt(1, 5), 2, 0);
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
		System.out.println(" > Weapon Tier: " + Colorize.MAGENTA + Inventory.get("weapon") + Colorize.RESET);
		System.out.println(" > Armor Level: " + Colorize.BLUE + Inventory.get("armor") + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_SMALL);
		System.out.println(" > Wood: " + Colorize.YELLOW + Inventory.get("wood") + Colorize.RESET);
		System.out.println(" > Iron: " + Colorize.BACKGROUND_WHITE + Colorize.BLACK + Inventory.get("iron") + Colorize.RESET);
		System.out.println(" > Leather: " + Colorize.YELLOW + Inventory.get("leather") + Colorize.RESET);
		System.out.println(" > Potions: " + Colorize.RED + Inventory.get("potions") + Colorize.RESET);
		System.out.println(" > Gems: " + Colorize.GREEN + Inventory.get("gems") + Colorize.RESET);

		System.out.println(Colorize.SEPARATOR_SMALL);

		// Crafting
		System.out.println(" 1.> " + Colorize.GREEN + "Crafting Menu" + Colorize.RESET);
		System.out.println(" 2.> " + Colorize.MAGENTA + "Statistics" + Colorize.RESET);
		System.out.println(" 3.> " + Colorize.YELLOW + "Back" + Colorize.RESET);

		System.out.print(Colorize.PROMPT);

		String actionInput = sc.next();
		actionInput.toLowerCase();


		System.out.println(Player.playerInfoString());

		switch(actionInput)
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
		System.out.println("HP: " + Colorize.RED + Player.hp + "/" + Player.maxHP + Colorize.RESET);
		System.out.println("Strength: " + Colorize.GREEN + Player.strength + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_MEDIUM);
		System.out.println("Level:" + Colorize.BLUE + Player.level + Colorize.RESET);
		System.out.println("XP: " + Colorize.MAGENTA +Player.xp + Colorize.RESET);

		System.out.println("Coins:" + Colorize.YELLOW + Player.coins + Colorize.RESET);
		
		
		if(Player.isUsingSpecialFlags)
		{
			System.out.println("Cheats:" + Colorize.CYAN + "true" + Colorize.RESET);
		}

		System.out.println("");

		System.out.println(" 1.> " + Colorize.YELLOW + "Back" + Colorize.RESET);

		System.out.print(Colorize.PROMPT);
		String input = sc.next();

		switch(input)
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