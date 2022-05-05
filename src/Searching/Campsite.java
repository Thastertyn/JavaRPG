package Searching;

public class Campsite {
	
	public static void wasFound()
	{
		int addedItems;
		int actuallyGotItems;
		System.out.println("You stumbled upon a campsite and found the following:");
		// Wood and Stone
		addedItems = rnd.nextInt(10, 21);
		Player.inventory.add(2, (Player.inventory.get(2) + addedItems));
		System.out.println(addedItems + " Wood,");
		
		addedItems = rnd.nextInt(5, 11);
		Player.inventory.add(3, (Player.inventory.get(2) + addedItems));
		System.out.println(addedItems + " Stone,");

		// Potions and Gems
		actuallyGotItems = rnd.nextInt(20);
		if(actuallyGotItems == 19)
		{
			addedItems = rnd.nextInt(3);
			Player.inventory.add(4, (Player.inventory.get(4) + addedItems));
			System.out.println(addedItems + " Potions,");
		}

		actuallyGotItems = rnd.nextInt(20);
		if(actuallyGotItems == 19)
		{
			Player.inventory.add(5, (Player.inventory.get(4) + addedItems));
			System.out.println(1 + " Potion,");
		}

		// Monsters
		actuallyGotItems = rnd.nextInt(5);
		if(actuallyGotItems == 4)
		{
			System.out.println("\n! You met some enemies !");
			addedItems = rnd.nextInt(3);
			addedItems++;
			BattleManager.startBattle(addedItems, 1);
		}

	}
}
