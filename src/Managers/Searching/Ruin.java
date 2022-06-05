package Managers.Searching;

import java.util.Random;
import java.util.Scanner;

import Classes.DataAndOtherStuff;
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
		System.out.println("You found:");
		
		// Wood
		addedItems = rnd.nextInt(30 , 101);
		Poi.wood(addedItems);
		
		// Iron
		addedItems = rnd.nextInt(10, 101);
		Poi.iron(addedItems);

		// Leather
		addedItems = rnd.nextInt(20, 31);
		Poi.leather(addedItems);

		System.out.println(Colorize.SEPARATOR_SMALL);

		// Potions
		actuallyGotItems = rnd.nextInt(20);
		if(actuallyGotItems > 14)
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
			addedItems = rnd.nextInt(5, 11);
			Poi.gems(addedItems);
		}else{
			Poi.gems(false);
		}

		// Monsters
		actuallyGotItems = rnd.nextInt(5);
		if(actuallyGotItems < 4)
		{
			System.out.println(Colorize.RED + "\n! You also met some Enemies !" + Colorize.RESET);
			sc.nextLine();
			addedItems = rnd.nextInt(1, 6);
			addedItems++;
			BattleManager.startBattle(addedItems, 4, 0);
		}else{
			System.out.println(Colorize.GREEN + "\nYou didn't meet any Enemies" + Colorize.RESET);
		}
	}
}
