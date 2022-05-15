package Managers.Searching;

import java.util.Random;
import java.util.Scanner;

import Colors.Colorize;
import MenusAndUIs.ActionMenu;

public class SearchManager {

	static Random rnd = new Random();
	static Scanner sc = new Scanner(System.in);

	public static void search()
	{
		System.out.print(Colorize.RESET + Colorize.CLEAR);
		System.out.println("----------------------------------");

		int chanceOfPlace = rnd.nextInt(10);

		// If a player finds a POI, they will get a couple guaranteed items
		// If not, then just low chances for something, but no enemies
		if(chanceOfPlace > 0)
		{
			// campsite has 50% chance
			// cottage 20%
			// cave 12.5%
			// ruin 7.5%
			// castle 6.5%
			
			// TODO Add boss
			// Bathroom 2.5%
			

			int poi = rnd.nextInt(999);
			poi++;

			// switch is too long
			if(poi >= 1 && poi <= 500)
			{
				Campsite.wasFound();
			}
			else if(poi > 500 && poi <= 700)
			{
				Cottage.wasFound();
			}
			else if(poi > 700 && poi <= 825)
			{
				Cave.wasFound();
			}
			else if(poi > 825 && poi <= 900)
			{
				System.out.println("You stumbled upon a ruin");
			}
			else if(poi > 900 && poi <= 975)
			{
				System.out.println("You stumbled upon a castle");
			}
			else if(poi > 975 && poi <= 990)
			{
				System.out.println("You stumbled upon a lair");
			}else{

			}
		}else{
			NoPlace.wasFound();
		}

		sc.nextLine();
		
		ActionMenu.mainMenu(false);
	}
}
