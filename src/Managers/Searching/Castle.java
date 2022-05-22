package Managers.Searching;

import java.util.Random;

import Classes.DataAndOtherStuff;
import Classes.Inventory;
import Colors.Colorize;
import Managers.BattleManager;

public class Castle {
	
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
		
		System.out.println(Colorize.BLUE + Colorize.UNDERLINE + "> Castle" + Colorize.RESET);

		System.out.println(DataAndOtherStuff.POI_MESSAGES[rnd.nextInt(DataAndOtherStuff.POI_MESSAGES.length)] + "Castle");

		// Wood and Iron and Leather
		addedItems = rnd.nextInt(25, 51);
		Inventory.add("wood", (Inventory.get("wood") + addedItems));
		System.out.println(addedItems + " Wood,");
		
		addedItems = rnd.nextInt(3, 6);
		Inventory.add("iron", (Inventory.get("iron") + addedItems));
		System.out.println(addedItems + " Iron,");

		addedItems = rnd.nextInt(2, 9);
		Inventory.add("leather", (Inventory.get("leather") + addedItems));
		System.out.println(addedItems + " Leather,");

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
			addedItems = rnd.nextInt(1, 2);
			Inventory.add("gems", (Inventory.get("gems") + addedItems));
			System.out.println(1 + " Gems,");
		}else{
			System.out.println("No Gems,");
		}
		
		System.out.println(Colorize.SEPARATOR_SMALL);

	}
}
