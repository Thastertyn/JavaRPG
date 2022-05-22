package Managers.Searching;

import java.util.Random;

import Classes.DataAndOtherStuff;
import Classes.Inventory;
import Colors.Colorize;
import Managers.BattleManager;

public class Cave {
	
	static Random rnd = new Random();

	public static void wasFound()
	{
		int addedItems;
		int actuallyGotItems;

		// Monsters
		actuallyGotItems = rnd.nextInt(5);
		if(actuallyGotItems == 4)
		{
			System.out.println("\n! You met some enemies !");
			addedItems = rnd.nextInt(3);
			addedItems++;
			BattleManager.startBattle(addedItems, 1);
		}else{
			System.out.println("No Enemies");
		}

		System.out.println(Colorize.BLACK + Colorize.UNDERLINE + Colorize.BACKGROUND_WHITE + "> Cave" + Colorize.RESET);

		System.out.println(DataAndOtherStuff.POI_MESSAGES[rnd.nextInt(DataAndOtherStuff.POI_MESSAGES.length)] + "Cave");
		
		// Wood, Iron, No Leather
		addedItems = rnd.nextInt(45, 61);
		Inventory.add("wood", (Inventory.get("wood") + addedItems));
		System.out.println(addedItems + " Wood,");
		
		addedItems = rnd.nextInt(30, 51);
		Inventory.add("iron", (Inventory.get("iron") + addedItems));
		System.out.println(addedItems + " Iron,");

		System.out.println("----");

		// Potions and Gems
		actuallyGotItems = rnd.nextInt(20);
		if(actuallyGotItems > 14)
		{
			addedItems = rnd.nextInt(1, 3);
			Inventory.add("potions", (Inventory.get("potions") + addedItems));
			System.out.println(addedItems + " Potions,");
		}else{
			System.out.println("No Potions");
		}

		actuallyGotItems = rnd.nextInt(20);
		if(actuallyGotItems == 19)
		{
			addedItems = rnd.nextInt(5, 11);
			Inventory.add("gems", (Inventory.get("gems") + addedItems));
			System.out.println(1 + " Gems,");
		}else{
			System.out.println("No Gems");
		}
	}
}
