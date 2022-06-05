package Managers.Searching;

import java.util.Random;
import java.util.Scanner;

import Classes.Player;
import Colors.Colorize;
import MenusAndUIs.ActionMenu;

public class SearchManager {

	static Random rnd = new Random();
	static Scanner sc = new Scanner(System.in);

	public static void search()
	{
		System.out.print(Colorize.CLEAR);

		int chanceOfPlace = rnd.nextInt(10);

		// If a player finds a POI, they will get a couple guaranteed items
		// If not, then just low chances for something, but no enemies
		if(chanceOfPlace > 0)
		{	
			int chanceOfPOI = (Player.level > 10) ? 10 : Player.level;

			int poi = rnd.nextInt(chanceOfPOI + 1);

			switch(poi)
			{
				case 0:
					Campsite.wasFound();
					break;
				case 1:
					Cottage.wasFound();
					break;
				case 2:
				case 3:
					Cave.wasFound();
					break;
				case 4:
				case 5:
					Ruin.wasFound();
					break;
				case 6:
				case 7:
					Castle.wasFound();
					break;
				case 8:
				case 9: 
					Lair.wasFound();
					break;
				case 10:
					Bathroom.wasFound();
					break;
			}
		}else{
			NoPlace.wasFound();
		}
		sc.nextLine();
		
		ActionMenu.mainMenu();
	}
}
