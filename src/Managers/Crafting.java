package Managers;

import java.util.Scanner;

import Classes.Inventory;
import Colors.Colorize;
import MenusAndUIs.ActionMenu;

public class Crafting {
	
	static Scanner sc = new Scanner(System.in);
	public static void craft()
	{
		System.out.print(Colorize.CLEAR + Colorize.RESET);
		System.out.println(Colorize.UNDERLINE + Colorize.YELLOW + ">>> ⁠Crafting" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);

		String weaponText = (Inventory.get("weapon") == 10) ? "[MAX]" : "[" +Inventory.get("weapon") + "/10 [Cost (Wood: " + getUpgradeCost("weapon")[0]  + ", Iron: " + getUpgradeCost("weapon")[1] + ")]]";
		String armorText = (Inventory.get("armor") == 10) ? "[MAX]" : "[" +Inventory.get("armor") + "/10 [Cost (Leather: " + getUpgradeCost("armor")[0]  + ", Iron: " + getUpgradeCost("armor")[1] + ")]]";

		System.out.println("Your tools:\n 1.> Weapon " + weaponText);
		System.out.println(" 2.> Armor " + armorText);
		System.out.println(" 3.> Go Back");

		/*switch(getUpgradableItems())
		{
			case 0:
				System.out.println("You can't upgrade anymore, all is at it's best");
				System.out.println(" 1.> Go Back");
				break;
			case 1:
				System.out.println("You can upgrade:\n 1.> Weapon " + Inventory.get("weapon") + "/10" + " (Wood: " + getUpgradeCost("weapon")[0]  + ", Iron: " + getUpgradeCost("weapon")[1] + ")");
				System.out.println(" 2.> Go Back");
				break;
			case 2:
				System.out.println("You can upgrade:\n 1.> Armor (Leather: " + getUpgradeCost("armor")[0]  + ", Iron: " + getUpgradeCost("weapon")[1] + ")");
				System.out.println(" 2.> Go Back");
				break;
			case 3:
				System.out.println("You can upgrade:\n 1.> Weapon " + Inventory.get("weapon") + "/10" + " [Cost (Wood: " + getUpgradeCost("weapon")[0]  + ", Iron: " + getUpgradeCost("weapon")[1] + ")]" + "\n 2.> Armor " + Inventory.get("armor") + "/10" + " [Cost (Leather: " + getUpgradeCost("armor")[0]  + ", Iron: " + getUpgradeCost("weapon")[1] + ")]");
				System.out.println(" 3.> Go Back");
				break;
		}*/

		System.out.println("");

		System.out.println("What do you want to upgrade?");
		System.out.print(Colorize.PROMPT);

		// upgrade cots 3/2 times more than the previous one + base price

		switch(sc.next().toLowerCase())
		{
			case "weapon":
			case "w":
			case "1":
				if(Inventory.get("weapon") == 10)
				{
					System.out.println("Your Weapon is at top tier already");
					sc.nextLine();
					craft();
				}else{
					upgrade("weapon");
				}
				break;
			case "armor":
			case "a":
			case "2":
				if(Inventory.get("armor") == 10)
				{
					System.out.println("Your Armor is at max level already");
					sc.nextLine();
					craft();
				}else{
					upgrade("armor");
				}
				break;
			case "back":
			case "b":
			case "3":
				ActionMenu.inventoryOpen(false);
				break;
			default:
				GameManager.missInput();
				craft();
				break;
		}
	}

	static void upgrade(String item)
	{
		switch(item)
		{
			case "weapon":
				if(Inventory.get("wood") < getUpgradeCost("weapon")[0] || Inventory.get("iron") < getUpgradeCost("weapon")[1])
				{
					System.err.println(Colorize.RED + "You don't have enough items yet" + Colorize.RESET);
				}else{
					Inventory.add("wood", Inventory.get("wood") - getUpgradeCost("weapon")[0]);
					Inventory.add("iron", Inventory.get("iron") - getUpgradeCost("weapon")[1]);
					Inventory.add("weapon", Inventory.get("weapon") + 1);
					System.out.println(Colorize.GREEN + "You Successfully upgraded your Weapon" + Colorize.RESET);
				}
				break;
			case "armor":
				if(Inventory.get("leather") < getUpgradeCost("armor")[0] || Inventory.get("iron") < getUpgradeCost("armor")[1])
				{
					System.err.println(Colorize.RED + "You don't have enough items yet" + Colorize.RESET);
				}else{
					Inventory.add("leather", Inventory.get("leather") - getUpgradeCost("armor")[0]);
					Inventory.add("iron", Inventory.get("iron") - getUpgradeCost("armor")[1]);
					Inventory.add("armor", Inventory.get("armor") + 1);
					System.out.println(Colorize.GREEN + "You Successfully upgraded your Weapon" + Colorize.RESET);
				}
				break;
		}

		// BRUH
		sc.nextLine();
		sc.nextLine();

		craft();
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

	static int[] getUpgradeCost(String item)
	{
		// Base price for weapon is
		// 50 Wood
		// 10 Iron

		// Armor
		// 20 Iron
		// 10 Leather

		int[] cost = {0, 0};

		if(item.equals("weapon"))
		{
			// Wood
			cost[0] = Inventory.get(item) * 3/2 * 50 + 50;
			// Iron
			cost[1] = Inventory.get(item) * 3/2 * 10 + 10;
		}else{
			// Leather
			cost[0] = Inventory.get(item) * 3/2 * 10 + 10;
			// Iron
			cost[1] = Inventory.get(item) * 3/2 * 20 + 20;
		}

		return cost;
	}
}
