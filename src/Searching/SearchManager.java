package Searching;

import java.util.Random;

import Classes.Player;
import Managers.BattleManager;

public class SearchManager {
	
	static Random rnd = new Random();

	public void search()
	{
		int chanceOfPlace = rnd.nextInt(3);

		// If a player finds a POI, they will get a couple guaranteed items
		// If not, then just low chances for something, but no enemies
		if(chanceOfPlace == 3)
		{
			// campsite has 50% chance
			// cottage 20%
			// cave 12.5%
			// ruin 7.5%
			// castle 7.5%
			// lair 2.5%

			int poi = rnd.nextInt(999);
			poi++;

			// switch is too long
			if(poi >= 1 && poi <= 500)
			{
				Campsite.wasFound();
			}
			else if(poi > 500 && poi <= 700)
			{
				System.out.println("You stumbled upon a cottage");
			}
			else if(poi > 700 && poi <= 825)
			{

			}
			else if(poi > 825 && poi <= 900)
			{

			}
			else if(poi > 900 && poi <= 975)
			{

			}
			else if(poi > 975 && poi <= 1000)
			{

			}
		}else{
			System.out.println("You didn't find any interesting place");

			int foundItems = rnd.nextInt(9);
			foundItems++;

			if(foundItems > 2)
			{
				int addedItem = 0;
			}
		}
	}
}
