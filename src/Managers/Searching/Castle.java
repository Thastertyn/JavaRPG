package Managers.Searching;

import java.util.Random;
import java.util.Scanner;

import Classes.DataAndOtherStuff;
import Colors.Colorize;
import Managers.BattleManager;

public class Castle {
	
	static Random rnd = new Random();
	static Scanner sc = new Scanner(System.in);

	public static void wasFound()
	{
		int addedItems;
		int actuallyGotItems;

		System.out.println(Colorize.BLUE + Colorize.UNDERLINE + ">> Castle" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);

		System.out.println(DataAndOtherStuff.POI_MESSAGES[rnd.nextInt(DataAndOtherStuff.POI_MESSAGES.length)] + "Castle");

		System.out.println(Colorize.SEPARATOR_SMALL);
		System.out.println("You found:");

		// Wood
		addedItems = rnd.nextInt(25, 51);
		Poi.wood(addedItems);
		
		// Iron
		addedItems = rnd.nextInt(25, 36);
		Poi.iron(addedItems);

		// Leather
		addedItems = rnd.nextInt(35, 61);
		Poi.leather(addedItems);

		// Potions
		addedItems = rnd.nextInt(5, 11);
		Poi.potions(addedItems);

		// Gems
		addedItems = rnd.nextInt(1, 4);
		Poi.gems(addedItems);
		
		// Monsters
		actuallyGotItems = rnd.nextInt(4);
		if(actuallyGotItems > 0)
		{
			System.out.println(Colorize.RED + "\n! You also met some Enemies !" + Colorize.RESET);
			sc.nextLine();
			BattleManager.startBattle(4, 5, 0);
		}else{
			System.out.println(Colorize.GREEN + "\nYou didn't meet any Enemies" + Colorize.RESET);
		}

	}
}
