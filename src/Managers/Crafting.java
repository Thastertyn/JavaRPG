package Managers;

import java.util.Scanner;

import Classes.Inventory;

public class Crafting {
	
	static Scanner sc = new Scanner(System.in);
	public static void craft()
	{
		switch(getUpgradableItems())
		{
			case 0:
				System.out.println("You can't upgrade anymore, all is at it's best");
				break;
			case 1:
				System.out.println("You can upgrade:\n > Weapon");
				break;
			case 2:
				System.out.println("You can upgrade:\n > Armor");
				break;
			case 3:
				System.out.println("You can upgrade:\n > Weapon\n > Armor");
				break;
		}

		System.out.println("What do you want to upgrade?");
	}

	static int getUpgradableItems()
	{
		int items = 0;
		
		// Kinda like binary
		// 0 - nothing can be upgraded
		// 1 - only weapon can be upgraded
		// 2 - only armor can be upgraded
		// 3 - both can be upgraded
		items += (Inventory.get("weapon") < 10) ? 1 : 0;
		items += (Inventory.get("armor") < 10) ? 2 : 0;

		return items;
	}

	static int getUpgradeCost(String item)
	{
		Inventory.get(item);
	}
}
