package Managers.Searching;

import java.util.Random;

import Classes.Inventory;
import Managers.BattleManager;

public class Campsite {
	
	static Random rnd = new Random();

	public static void wasFound()
	{
		int addedItems;
		int actuallyGotItems;
		System.out.println("You stumbled upon a campsite and found the following:");

		// Wood and Iron, no Leather
		addedItems = rnd.nextInt(10, 21);
		Inventory.add("wood", (Inventory.get("wood") + addedItems));
		System.out.println(addedItems + " Wood,");
		
		addedItems = rnd.nextInt(1, 2);
		Inventory.add("iron", (Inventory.get("iron") + addedItems));
		System.out.println(addedItems + " Iron,");

		// Potions, no Gems
		actuallyGotItems = rnd.nextInt(20);
		if(actuallyGotItems == 19)
		{
			addedItems = rnd.nextInt(3);
			Inventory.add("potions", (Inventory.get("potions") + addedItems));
			System.out.println(addedItems + " Potions,");
		}else{
			System.out.println("No Potions,");
		}
		
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
	}
}
