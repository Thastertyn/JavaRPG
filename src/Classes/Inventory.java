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


	/**
	 * Set all the items as 0, mainly when you start out
	 */
	public static void init()
	{
		inventory.add(0, 0);
		inventory.add(1, 0);
		inventory.add(2, 0);
		inventory.add(3, 0);
		inventory.add(4, 0);
		inventory.add(5, 0);
		inventory.add(6, 0);
	}

	/**
	 * Return the current item count of items
	 * @param item Item name
	 * @return the value in inventory
	 */
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

	/**
	 * Get an item and add the given value to already existing items
	 * @param item Item name
	 * @param value Value to be added
	 */
	public static void add(String item, int value)
	{
		switch(item)
		{
			case "weapon":
				inventory.set(0, inventory.get(0) + value);
				break;
			case "armor":
				inventory.set(1, inventory.get(1) + value);
				break;
			case "wood":
				inventory.set(2, inventory.get(2) + value);
				break;
			case "iron":
				inventory.set(3, inventory.get(3) + value);
				break;
			case "leather":
				inventory.set(4, inventory.get(4) + value);
				break;
			case "potions":
				inventory.set(5, inventory.get(5) + value);
				break;
			case "gems":
				inventory.set(6, inventory.get(6) + value);
				break;
		}
	}

	/**
	 * Get an item and a value to set it to
	 * @param item Item name
	 * @param value Value to be set to
	 */
	public static void set(String item, int value)
	{
		switch(item)
		{
			case "weapon":
				inventory.set(0, value);
				break;
			case "armor":
				inventory.set(1, value);
				break;
			case "wood":
				inventory.set(2, value);
				break;
			case "iron":
				inventory.set(3, value);
				break;
			case "leather":
				inventory.set(4, value);
				break;
			case "potions":
				inventory.set(5, value);
				break;
			case "gems":
				inventory.set(6, value);
				break;
		}
	}
}
