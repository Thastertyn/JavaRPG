package Managers.Searching;

import java.util.Random;
import java.util.Scanner;

import Classes.DataAndOtherStuff;
import Classes.Inventory;
import Colors.Colorize;
import Managers.BattleManager;

public class Lair {
	
	static Random rnd = new Random();
	static Scanner sc = new Scanner(System.in);

	public static void wasFound()
	{
		int addedItems;

		// Monsters
		System.out.println("\n! You met some enemies !");
		sc.nextLine();
		addedItems = rnd.nextInt(5);
		addedItems++;
		BattleManager.startBattle(addedItems, 69, 1);

		System.out.println(Colorize.UNDERLINE + Colorize.MAGENTA + "> Lair" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);

		System.out.println(DataAndOtherStuff.POI_MESSAGES[rnd.nextInt(DataAndOtherStuff.POI_MESSAGES.length)] + "Lair");

		System.out.println(Colorize.SEPARATOR_MEDIUM);
		
		System.out.println("You found:");
		// Wood, Iron, Leather
		addedItems = rnd.nextInt(15, 31);
		Inventory.add("wood", (Inventory.get("wood") + addedItems));
		System.out.println(addedItems + " Wood,");
		
		addedItems = rnd.nextInt(0, 6);
		Inventory.add("iron", (Inventory.get("iron") + addedItems));
		System.out.println(addedItems + " Iron,");

		addedItems = rnd.nextInt(20, 31);
		Inventory.add("leather", addedItems);
		System.out.println(addedItems + " Leather");

		System.out.println(Colorize.SEPARATOR_SMALL);

		// Potions and Gems
		addedItems = rnd.nextInt(5, 7);
		Inventory.add("potions", (Inventory.get("potions") + addedItems));
		System.out.println(addedItems + " Potions,");

		addedItems = rnd.nextInt(5, 11);
		Inventory.add("gems", (Inventory.get("gems") + addedItems));
		System.out.println(1 + " Gems,");
	}
}
