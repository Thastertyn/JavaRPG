package Managers.Searching;

import java.util.Random;
import java.util.Scanner;

import Classes.DataAndOtherStuff;
import Classes.Inventory;
import Colors.Colorize;
import Managers.BattleManager;

public class Ruin {
	
	static Random rnd = new Random();
	static Scanner sc = new Scanner(System.in);

	public static void wasFound()
	{
		int addedItems;
		int actuallyGotItems;

		System.out.println(Colorize.MAGENTA + ">> Ruin" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);

		System.out.println(DataAndOtherStuff.POI_MESSAGES[rnd.nextInt(DataAndOtherStuff.POI_MESSAGES.length)] + "Ruin");

		System.out.println(Colorize.SEPARATOR_SMALL);
		
		// Wood, Iron and Leather
		addedItems = rnd.nextInt(30 , 101);
		Inventory.add("wood", (Inventory.get("wood") + addedItems));
		System.out.println(addedItems + " Wood,");
		
		addedItems = rnd.nextInt(10, 101);
		Inventory.add("iron", (Inventory.get("iron") + addedItems));
		System.out.println(addedItems + " Iron,");
		
		addedItems = rnd.nextInt(20, 31);
		Inventory.add("iron", Inventory.get("iron") + addedItems);

		System.out.println(Colorize.SEPARATOR_SMALL);

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

		// Monsters
		actuallyGotItems = rnd.nextInt(5);
		if(actuallyGotItems == 4)
		{
			System.out.println("\n! You met some enemies !");
			sc.nextLine();
			addedItems = rnd.nextInt(3);
			addedItems++;
			BattleManager.startBattle(addedItems, 1, 0);
		}else{
			System.out.println("No Enemies");
		}
	}
}
