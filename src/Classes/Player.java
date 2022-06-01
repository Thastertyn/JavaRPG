package Classes;

import java.util.Random;

import Colors.Colorize;

public class Player {
	
	public static boolean isInvincible = false;
	public static boolean isSuperStrong = false;

	// can be buffed by crafting a 
	public static int maxHP;
	public static int hp;

	// 10 Levels of weapons and tiers or armor
	public static int strength;

	public static int xp = 0;
	public static int level = 0;
	public static int coins = 0;
	public static int enemyKills = 0;

	public static String playerClass;
	public static String classColor;

	static Random rnd = new Random();

	static boolean isDefending = false;

	public static boolean isUsingSpecialFlags = false;

	// used to spread the code around a bit, because of the 200 line limit
	public static void init(String classString)
	{
		switch(classString)
		{
			case "wizard":
				maxHP = DataAndOtherStuff.WIZARD_HP;
				strength = DataAndOtherStuff.WIZARD_STRENGTH;
				classColor = Colorize.MAGENTA;
				playerClass = "wizard";
				break;
			case "dwarf":
				maxHP = DataAndOtherStuff.DWARF_HP;
				strength = DataAndOtherStuff.DWARF_STRENGTH;
				classColor = Colorize.CYAN;
				playerClass = "dwarf";
				Inventory.add("armor", 2);
				Inventory.add("weapon", 2);
				break;
			case "elf":
				maxHP = DataAndOtherStuff.ELF_HP;
				strength = DataAndOtherStuff.ELF_STRENGTH;
				classColor = Colorize.WHITE;
				playerClass = "elf";
				break;
			case "human":
				maxHP = DataAndOtherStuff.HUMAN_HP;
				strength = DataAndOtherStuff.HUMAN_STRENGTH;
				classColor = Colorize.YELLOW;
				playerClass = "human";
				Inventory.add("wood", 200);
				Inventory.add("iron", 50);
				Inventory.add("leather", 50);
				Inventory.add("potions", 5);
				Inventory.add("gems", 3);
				break;
		}

		if(isInvincible)
		{
			maxHP = DataAndOtherStuff.STUPID_LARGE_HP;
			Inventory.add("armor", Integer.MAX_VALUE);
			isUsingSpecialFlags = true;
		}
		
		if(isSuperStrong)
		{
			strength = DataAndOtherStuff.STUPID_LARGE_STRENGTH;
			Inventory.add("weapon", Integer.MAX_VALUE);
			isUsingSpecialFlags = true;
		}

		hp = Player.maxHP;
	}

	public static void addXP(int amount)
	{
		xp += amount;

		if(xp >= level * 500)
		{
			xp -= level * 500;
			level++;
			System.out.println(Colorize.CYAN + "! You leveled up to level " + level + " !" + Colorize.RESET);
		}
		System.out.println("XP required for next level: " + Colorize.BLUE + ((500 * level) - xp) + " XP");
	}

	// toString can't be static, which it has to be if there is only one player, therefore everything else is being static
	public static String playerInfoString()
	{
		return Colorize.UNDERLINE + classColor + "Player" + Colorize.RESET + ":" + "\n > HP:" + hp + "/" + maxHP + "\n > Strength:" + strength + "\n" + Colorize.SEPARATOR_SMALL + "\n > Potions: " + Inventory.get("potions");
	}
}
