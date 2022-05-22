package Managers;

import java.util.Scanner;

import Classes.Inventory;
import Classes.Player;
import Colors.Colorize;
import MenusAndUIs.ActionMenu;

public class Crafting {
	
	static Scanner sc = new Scanner(System.in);
	public static void craft()
	{
		System.out.print(Colorize.CLEAR + Colorize.RESET);
		System.out.println(Colorize.UNDERLINE + Colorize.YELLOW + ">>> ⁠Crafting" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);

		String weaponText = (Inventory.get("weapon") == 10) ? "[MAX]" : ("[" +Inventory.get("weapon") + "/10 [Cost (Wood: " + getUpgradeCost("weapon")[0])  + (", Iron: " + getUpgradeCost("weapon")[1]) + ", Gems: " + getUpgradeCost("weapon")[2] + "" + ")]]";

		String armorText = (Inventory.get("armor") == 10) ? "[MAX]" : ("[" +Inventory.get("armor") + "/10 [Cost (Leather: " + getUpgradeCost("armor")[0])  + (", Iron: " + getUpgradeCost("armor")[1]) + ", Gems: " + getUpgradeCost("armor")[2] + ")]]";

		System.out.println("Your tools:\n 1.> Weapon " + weaponText);
		System.out.println(" 2.> Armor " + armorText);
		System.out.println(" 3.> Go Back");

		System.out.println("");

		System.out.println("What do you want to upgrade?");
		System.out.print(Colorize.PROMPT);

		// upgrade cots 3/2 times more than the previous one + base price

		switch(sc.next().toLowerCase())
		{
			case "weapon":
			case "w":
			case "1":
				if(Inventory.get("weapon") >= 10)
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
				if(Inventory.get("armor") >= 10)
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
				if(Inventory.get("wood") < getUpgradeCost("weapon")[0] || Inventory.get("iron") < getUpgradeCost("weapon")[1] || Inventory.get("gems") < getUpgradeCost("weapon")[2])
				{
					System.err.println(Colorize.RED + "You don't have enough items yet" + Colorize.RESET);
				}else{
					Inventory.add("wood", Inventory.get("wood") - getUpgradeCost("weapon")[0]);
					Inventory.add("iron", Inventory.get("iron") - getUpgradeCost("weapon")[1]);
					Inventory.add("gems", Inventory.get("gems") - getUpgradeCost("weapon")[2]);

					Inventory.add("weapon", Inventory.get("weapon") + 1);
					Player.strength += (Player.strength / 10) * 15;
					Player.tier = (int) Math.ceil((Inventory.get("weapon") + Inventory.get("armor")) / 2); 

					System.out.println(Colorize.GREEN + "You Successfully upgraded your Weapon" + Colorize.RESET);
				}
				break;
			case "armor":
				if(Inventory.get("leather") < getUpgradeCost("armor")[0] || Inventory.get("iron") < getUpgradeCost("armor")[1] || Inventory.get("gems") < getUpgradeCost("armor")[2])
				{
					System.err.println(Colorize.RED + "You don't have enough items yet" + Colorize.RESET);
				}else{
					Inventory.add("leather", Inventory.get("leather") - getUpgradeCost("armor")[0]);
					Inventory.add("iron", Inventory.get("iron") - getUpgradeCost("armor")[1]);
					Inventory.add("gems", Inventory.get("gems") - getUpgradeCost("armor")[2]);

					Inventory.add("armor", Inventory.get("armor") + 1);
					Player.hp += (Player.hp / 10) * 15;
					Player.tier = (int) Math.ceil((Inventory.get("weapon") + Inventory.get("armor")) / 2); 

					System.out.println(Colorize.GREEN + "You Successfully upgraded your Weapon" + Colorize.RESET);
				}
				break;
		}

		// BRUH
		sc.nextLine();
		sc.nextLine();

		craft();
	}

	static int[] getUpgradeCost(String item)
	{
		// Base price for weapon is
		// 50 Wood
		// 10 Iron

		// Armor
		// 20 Iron
		// 10 Leather

		// Plus gem per level

		int[] cost = {0, 0, 0};

		if(item.equals("weapon"))
		{
			// Wood
			cost[0] = Inventory.get(item) * 3/2 * 50 + 50;
			// Iron
			cost[1] = Inventory.get(item) * 3/2 * 10 + 10;
			// Gems
			cost[2] = Inventory.get(item) + 1;
		}else{
			// Leather
			cost[0] = Inventory.get(item) * 3/2 * 10 + 10;
			// Iron
			cost[1] = Inventory.get(item) * 3/2 * 20 + 20;
			// Gems
			cost[2] = Inventory.get(item) + 1;
		}

		return cost;
	}
}
