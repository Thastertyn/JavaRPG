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

		System.out.println(DataAndOtherStuff.POI_MESSAGES[rnd.nextInt(DataAndOtherStuff.POI_MESSAGES.length)] + "Cottage");

		System.out.println(Colorize.SEPARATOR_SMALL);
		System.out.println("You found:");

		// Wood
		addedItems = rnd.nextInt(25, 51);
		Inventory.add("wood", addedItems);
		Poi.wood(addedItems);
		
		// Iron
		addedItems = rnd.nextInt(3, 6);
		Poi.iron(addedItems);

		// Leather
		addedItems = rnd.nextInt(2, 9);
		Poi.leather(addedItems);


		System.out.println(Colorize.SEPARATOR_SMALL);

		// Potions
		actuallyGotItems = rnd.nextInt(5);
		if(actuallyGotItems == 4)
		{
			addedItems = rnd.nextInt(1, 3);
			Poi.potions(addedItems);
		}else{
			Poi.potions(false);
		}

		// Gems
		actuallyGotItems = rnd.nextInt(20);
		if(actuallyGotItems == 19)
		{
			Poi.gems(1);
		}else{
			Poi.gems(false);
		}

		// Monsters
		actuallyGotItems = rnd.nextInt(9);
		if(actuallyGotItems == 8)
		{
			System.out.println(Colorize.RED + "\n! You also met some Enemies !" + Colorize.RESET);
			sc.nextLine();
			addedItems = rnd.nextInt(1, 3);
			addedItems++;
			BattleManager.startBattle(addedItems, 2, 0);
		}else{
			System.out.println(Colorize.GREEN + "\nYou didn't meet any Enemies" + Colorize.RESET);
		}
	}
}
