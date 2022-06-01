package Managers.Searching;

import java.util.Random;
import java.util.Scanner;

import Classes.DataAndOtherStuff;
import Classes.Inventory;
import Colors.Colorize;
import Managers.BattleManager;

public class Cottage {

	static Random rnd = new Random();
	static Scanner sc = new Scanner(System.in);

	public static void wasFound()
	{
		int addedItems;
		int actuallyGotItems;
		
		System.out.println(Colorize.BLUE + ">> Cottage" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);

		System.out.println(DataAndOtherStuff.POI_MESSAGES[rnd.nextInt(DataAndOtherStuff.POI_MESSAGES.length)] + "cottage");

		System.out.println(Colorize.SEPARATOR_SMALL);

		// Wood and Iron and Leather
		addedItems = rnd.nextInt(25, 51);
		Inventory.add("wood", addedItems);
		System.out.println(" > " + addedItems + " Wood,");
		
		addedItems = rnd.nextInt(3, 6);
		Inventory.add("iron", addedItems);
		System.out.println(" > " + addedItems + " Iron,");

		addedItems = rnd.nextInt(2, 9);
		Inventory.add("leather", addedItems);
		System.out.println(" > " + addedItems + " Leather,");

		System.out.println(Colorize.SEPARATOR_SMALL);

		// Potions and Gems
		actuallyGotItems = rnd.nextInt(5);
		if(actuallyGotItems == 4)
		{
			addedItems = rnd.nextInt(1, 3);
			Inventory.add("potions", addedItems);
			System.out.println(" > " + addedItems + " Potions,");
		}else{
			System.out.println(" > No Potions");
		}

		actuallyGotItems = rnd.nextInt(20);
		if(actuallyGotItems == 19)
		{
			Inventory.add("gems", 1);
			System.out.println(" > 1 Gem,");
		}else{
			System.out.println(" > No Gems,");
		}

		// Monsters
		actuallyGotItems = rnd.nextInt(9);
		if(actuallyGotItems == 8)
		{
			System.out.println(Colorize.RED + "\n! You also met some Enemies !" + Colorize.RESET);
			sc.nextLine();
			addedItems = rnd.nextInt(1, 3);
			addedItems++;
			BattleManager.startBattle(addedItems, 1, 0);
		}else{
			System.out.println(Colorize.GREEN + "\nYou didn't meet any Enemies" + Colorize.RESET);
		}
		
		System.out.println(Colorize.SEPARATOR_SMALL);
	}
}
