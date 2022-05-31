package Managers.Searching;

import java.util.Random;
import java.util.Scanner;

import Classes.DataAndOtherStuff;
import Classes.Inventory;
import Colors.Colorize;
import Managers.BattleManager;

public class SamplePOI {
	
	static Random rnd = new Random();
	static Scanner sc = new Scanner(System.in);

	public static void wasFound()
	{
		int addedItems;
		int actuallyGotItems;

		System.out.println(Colorize.UNDERLINE + Colorize.YELLOW + "> POI" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);

		System.out.println(DataAndOtherStuff.POI_MESSAGES[rnd.nextInt(DataAndOtherStuff.POI_MESSAGES.length)] + "poi");

		System.out.println(Colorize.SEPARATOR_SMALL);
		System.out.println("You found:");

		// Wood and Iron, no Leather
		addedItems = rnd.nextInt(10, 21);
		Inventory.add("wood", (Inventory.get("wood") + addedItems));
		System.out.println(" " + addedItems + " Wood,");
		
		addedItems = rnd.nextInt(1, 2);
		Inventory.add("iron", (Inventory.get("iron") + addedItems));
		System.out.println(" " + addedItems + " Iron,");

		// Potions, no Gems
		actuallyGotItems = rnd.nextInt(20);
		if(actuallyGotItems == 19)
		{
			addedItems = rnd.nextInt(3);
			Inventory.add("potions", (Inventory.get("potions") + addedItems));
			System.out.println(" " + addedItems + " Potions,");
		}else{
			System.out.println(" No Potions,");
		}

		// Monsters
		actuallyGotItems = rnd.nextInt(5);
		if(actuallyGotItems == 4)
		{
			System.out.println(Colorize.RED + "\n! You also met some Enemies !" + Colorize.RESET);
			sc.nextLine();
			addedItems = rnd.nextInt(3);
			addedItems++;
			BattleManager.startBattle(addedItems, 1, 0);
		}else{
			System.out.println(Colorize.GREEN + "\nYou didn't meet any Enemies" + Colorize.RESET);
		}
	}
}