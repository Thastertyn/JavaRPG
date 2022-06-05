package Managers.Searching;

import java.util.Random;
import java.util.Scanner;

import Classes.DataAndOtherStuff;
import Colors.Colorize;
import Managers.BattleManager;

public class Campsite {
	
	static Random rnd = new Random();
	static Scanner sc = new Scanner(System.in);

	public static void wasFound()
	{
		int addedItems;
		int actuallyGotItems;

		System.out.println(Colorize.UNDERLINE + Colorize.YELLOW + ">> Campsite" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);

		System.out.println(DataAndOtherStuff.POI_MESSAGES[rnd.nextInt(DataAndOtherStuff.POI_MESSAGES.length)] + "Campsite");

		System.out.println(Colorize.SEPARATOR_SMALL);
		System.out.println("You found:");

		// Wood
		addedItems = rnd.nextInt(10, 21);
		Poi.wood(addedItems);

		// Iron
		addedItems = rnd.nextInt(1, 5);
		Poi.iron(addedItems);

		// No Leather

		// Potions
		actuallyGotItems = rnd.nextInt(20);
		if(actuallyGotItems == 19)
		{
			addedItems = rnd.nextInt(1, 4);
			Poi.potions(addedItems);
		}else{
			Poi.potions(false);
		}

		// No Gems

		// Monsters
		actuallyGotItems = rnd.nextInt(5);
		if(actuallyGotItems == 4)
		{
			System.out.println(Colorize.RED + "\n! You also met some Enemies !" + Colorize.RESET);
			sc.nextLine();
			addedItems = rnd.nextInt(1, 4);
			addedItems++;
			BattleManager.startBattle(addedItems, 1, 0);
		}else{
			System.out.println(Colorize.GREEN + "\nYou didn't meet any Enemies" + Colorize.RESET);
		}
	}
}
