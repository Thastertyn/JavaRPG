package Managers.Searching;

import Classes.Inventory;
import Colors.Colorize;

public class Poi {
	
	// Print out the items player got instead of printing them out in each of poi

	/*public static void wasFound(String location)
	{
		switch(location)
		{
			case "campsite":
				break;
			case "cottage":
				break;
			case "cave":
				break;
			case "ruin":
				break;
			case "castle":
				break;
			case "lair":
				break;
			case "bathroom":
				break;
		}
	}*/

	public static void wood(int amout)
	{
		Inventory.add("wood", amout);
		System.out.println(" > " + amout + Colorize.YELLOW + " Wood" + Colorize.RESET + ",");
	}

	public static void iron(int amount)
	{
		Inventory.add("iron", amount);
		System.out.println(" > " + amount + " " + Colorize.BACKGROUND_WHITE + Colorize.BLACK + "Iron" + Colorize.RESET + ",");
	}

	public static void leather(int amount)
	{
		Inventory.add("leather", amount);
		System.out.println(" > " + amount + Colorize.YELLOW + " Leather" + Colorize.RESET + ",");
	}

	public static void potions(int amount)
	{
		Inventory.add("potions", amount);
		System.out.println(" > " + amount + Colorize.RED + " Potions" + Colorize.RESET + ",");
	}

	public static void potions(boolean gotItems)
	{
		System.out.println(" > No " + Colorize.RED + "Potions" + Colorize.RESET + ",");
	}

	public static void gems(int amount)
	{
		Inventory.add("gems", amount);
		System.out.println(" > 1 " + Colorize.GREEN + " Gems" + Colorize.RESET + ",");
	}

	public static void gems(boolean gotItems)
	{
		System.out.println(" > No " + Colorize.GREEN + "Gems" + Colorize.RESET + ",");
	}
}
