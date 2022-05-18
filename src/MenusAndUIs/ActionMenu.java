// The 200 line limit is dumb
package MenusAndUIs;

import Colors.Colorize;
import Managers.BattleManager;
import Managers.Crafting;
import Managers.Searching.SearchManager;
import Classes.Inventory;
import Classes.Player;

import java.util.Random;
import java.util.Scanner;

public class ActionMenu {

	static Scanner sc = new Scanner(System.in);
	static Random rnd = new Random();

	static int failedTimes = 0;

	public static void mainMenu(boolean retry)
	{
		System.out.print(Colorize.RESET + Colorize.CLEAR);

		if(retry)
        {
            failedTimes++;
            System.err.println(Colorize.RED + "Incorrect input, try again.\nFailed " + failedTimes  + " times" + Colorize.RESET + "\n");
        }else{
            failedTimes = 0;
        }

		System.out.println(Colorize.UNDERLINE + Colorize.GREEN + "> ⁠Choose ⁠Your ⁠Action" + Colorize.RESET);
		System.out.println("----------------------------------");
		System.out.println("You can now do the following:\n 1.> Explore\n 2.> Hunt (Enemies)\n 3.> Open your inventory");

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
				BattleManager.startBattle(rnd.nextInt(1, 5), Player.tier);
				break;
			case "i":
			case "inventory":
			case "3":
				System.out.println("You opened your inventory");
				inventoryOpen(false);
				break;
			default:
				mainMenu(true);
				break;
		}

		sc.nextLine();
	}

	public static void inventoryOpen(boolean retry)
	{
		System.out.print(Colorize.RESET + Colorize.CLEAR);
		System.out.println(Colorize.BLUE + Colorize.UNDERLINE + ">> ⁠" /*Punctuation space U+2008, cuz it's the only which would be underlined*/ + "Inventory" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);

		if(retry)
		{
			failedTimes++;
			System.err.println(Colorize.RED + "Incorrect input, try again.\nFailed " + failedTimes  + " times" + Colorize.RESET + "\n");
		}else{
			failedTimes = 0;
		}
		
		// Items
		System.out.println("Contents of your inventory");
		System.out.println(" > Weapon Tier: " + Inventory.get("weapon"));
		System.out.println(" > Armor Level: " + Inventory.get("armor"));
		System.out.println(Colorize.SEPARATOR_SMALL);
		System.out.println(" > Wood: " + Inventory.get("wood"));
		System.out.println(" > Iron: " + Inventory.get("iron"));
		System.out.println(" > Leather: " + Inventory.get("leather"));
		System.out.println(" > Potions: " + Inventory.get("potions"));
		System.out.println(" > Gems: " + Inventory.get("gems"));

		System.out.println(Colorize.SEPARATOR_SMALL);

		// Crafting
		System.out.println(" 1.> Crafting Menu");
		System.out.println(" 2.> Back");

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
			case "b":
			case "back":
			case "2":
				System.out.println("No");
				sc.nextLine();
				mainMenu(false);
				break;
			default:
				failedTimes++;
				inventoryOpen(true);
				break;
		}
	}
}