package Managers.Searching;

import java.util.Random;
import java.util.Scanner;

import Classes.DataAndOtherStuff;
import Colors.Colorize;
import Managers.BattleManager;

public class Lair {
	
	static Random rnd = new Random();
	static Scanner sc = new Scanner(System.in);

	public static void wasFound()
	{
		int addedItems;
		int actuallyGotItems;

		System.out.println(Colorize.UNDERLINE + Colorize.MAGENTA + ">> Lair" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);

		System.out.println(DataAndOtherStuff.POI_MESSAGES[rnd.nextInt(DataAndOtherStuff.POI_MESSAGES.length)] + "Lair");

		System.out.println(Colorize.SEPARATOR_SMALL);
		System.out.println("You found:");

		// Wood
		addedItems = rnd.nextInt(100, 121);
		Poi.wood(addedItems);
		
		// Iron
		addedItems = rnd.nextInt(20, 51);
		Poi.iron(addedItems);

		// Leather
		addedItems = rnd.nextInt(40, 101);
		Poi.leather(addedItems);

		// Potions
		actuallyGotItems = rnd.nextInt(4);
		if(actuallyGotItems > 0)
		{
			addedItems = rnd.nextInt(3, 7);
			Poi.potions(addedItems);
		}else{
			Poi.potions(false);
		}

		// Gems
		actuallyGotItems = rnd.nextInt(2);
		if(actuallyGotItems == 0)
		{
			Poi.gems(2);
		}else{
			Poi.gems(false);
		}

		// Monsters
		System.out.println(Colorize.RED + "\n! You also met some Enemies !" + Colorize.RESET);
		sc.nextLine();
		addedItems = rnd.nextInt(5);
		addedItems++;
		BattleManager.startBattle(addedItems, 69, 1);
	}
}
