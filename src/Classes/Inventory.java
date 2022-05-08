package Classes;

import java.util.ArrayList;

public class Inventory {
	// Item Positions
	// 0. Weapon
	// 1. Armor
	// 2. Wood
	// 3. Iron
	// 4. Leather
	// 5. Potions
	// 6. Gems
	// There won't be any size limit, at least for now
	static ArrayList<Integer> inventory = new ArrayList<>();

	// Don't want to use objects
	public static void init()
	{
		// Set the all items to zero
		inventory.add(0, 0);
		inventory.add(1, 0);
		inventory.add(2, 0);
		inventory.add(3, 0);
		inventory.add(4, 0);
		inventory.add(5, 0);
		inventory.add(6, 0);
	}
	public static int get(String item)
	{
		int value = 0;
		switch(item)
		{
			case "weapon":
				value = inventory.get(0);
				break;
			case "armor":
				value = inventory.get(1);
				break;
			case "wood":
				value = inventory.get(2);
				break;
			case "iron":
				value = inventory.get(3);
				break;
			case "leather":
				value = inventory.get(4);
				break;
			case "potions":
				value = inventory.get(5);
				break;
			case "gems":
				value = inventory.get(6);
				break;
		}

		return value;
	}

	public static void add(String item, int value)
	{
		switch(item)
		{
			case "weapon":
				value = inventory.set(0, value);
				break;
			case "armor":
				value = inventory.set(1, value);
				break;
			case "wood":
				value = inventory.set(2, value);
				break;
			case "iron":
				value = inventory.set(3, value);
				break;
			case "leather":
				value = inventory.set(4, value);
				break;
			case "potions":
				value = inventory.set(5, value);
				break;
			case "gems":
				value = inventory.set(6, value);
				break;
		}
	}
}
