package Managers.Searching;

import java.util.Random;
import java.util.Scanner;

import Classes.DataAndOtherStuff;
import Colors.Colorize;
import Managers.BattleManager;

public class Cave {
	
	static Random rnd = new Random();
	static Scanner sc = new Scanner(System.in);

	public static void wasFound()
	{
		int addedItems;
		int actuallyGotItems;

		System.out.println(Colorize.BLACK + Colorize.UNDERLINE + Colorize.BACKGROUND_WHITE + ">> Cave" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);

		System.out.println(DataAndOtherStuff.POI_MESSAGES[rnd.nextInt(DataAndOtherStuff.POI_MESSAGES.length)] + "Cave");

		System.out.println(Colorize.SEPARATOR_SMALL);
		System.out.println("You found:");
		
		// Wood, Iron, No Leather
		addedItems = rnd.nextInt(45, 61);
		Poi.wood(addedItems);

		addedItems = rnd.nextInt(30, 51);
		Poi.iron(addedItems);

		System.out.println(Colorize.SEPARATOR_SMALL);

		// Potions and Gems
		actuallyGotItems = rnd.nextInt(4);
		if(actuallyGotItems == 3 )
		{
			addedItems = rnd.nextInt(1, 3);
			Poi.potions(addedItems);
		}else{
			Poi.potions(false);
		}

		addedItems = rnd.nextInt(5, 11);
		Poi.gems(addedItems);

		// Monsters
		actuallyGotItems = rnd.nextInt(4);
		if(actuallyGotItems == 3)
		{
			System.out.println(Colorize.RED + "\n! You also met some Enemies !" + Colorize.RESET);
			sc.nextLine();
			addedItems = rnd.nextInt(1, 5);
			addedItems++;
			BattleManager.startBattle(addedItems, 3, 0);
		}else{
			System.out.println(Colorize.GREEN + "\nYou didn't meet any Enemies" + Colorize.RESET);
		}
	}
}