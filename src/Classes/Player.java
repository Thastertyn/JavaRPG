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

	public static int maxArmor;
	public static int maxWeapon;

	public static int xp = 0;
	public static int level = 0;
	public static int coins = 0;
	public static int enemyKills = 0;

	public static String playerClass;
	public static String classColor;

	static Random rnd = new Random();

	static boolean isDefending = false;

	public static boolean isUsingSpecialFlags = false;

	/**
	 * Apply health and strength and any other values according to user choosing via {@code classString}
	 * @param classString The class user wants
	 */
	public static void init(String classString)
	{
		switch(classString)
		{
			case "wizard":
				maxHP = DataAndOtherStuff.WIZARD_HP;
				maxArmor = DataAndOtherStuff.WIZARD_MAX_ARMOR;
				maxWeapon = DataAndOtherStuff.WIZARD_MAX_WEAPON;
				strength = DataAndOtherStuff.WIZARD_STRENGTH;
				classColor = Colorize.MAGENTA;
				playerClass = "wizard";
				break;
			case "dwarf":
				maxHP = DataAndOtherStuff.DWARF_HP;
				maxArmor = DataAndOtherStuff.DWARF_MAX_ARMOR;
				maxWeapon = DataAndOtherStuff.DWARF_MAX_WEAPON;
				strength = DataAndOtherStuff.DWARF_STRENGTH;
				classColor = Colorize.CYAN;
				playerClass = "dwarf";
				Inventory.add("armor", 2);
				Inventory.add("weapon", 2);
				break;
			case "elf":
				maxHP = DataAndOtherStuff.ELF_HP;
				maxArmor = DataAndOtherStuff.ELF_MAX_ARMOR;
				maxWeapon = DataAndOtherStuff.ELF_MAX_WEAPON;
				strength = DataAndOtherStuff.ELF_STRENGTH;
				classColor = Colorize.WHITE;
				playerClass = "elf";
				break;
			case "human":
				maxHP = DataAndOtherStuff.HUMAN_HP;
				maxArmor = DataAndOtherStuff.HUMAN_MAX_ARMOR;
				maxWeapon = DataAndOtherStuff.HUMAN_MAX_WEAPON;
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

	/**
	 * Called from BattleManager, adds some xp and increases level accordingly
	 * Each level takes {@code 500 *  Current Level}
	 * @param amount Xp amount to be added
	 */
	public static void addXP(int amount)
	{
		xp += amount;

		if(xp >= level * 500)
		{
			xp -= level * 500;
			level++;
			System.out.println(Colorize.CYAN + "! You leveled up to level " + level + " !" + Colorize.RESET);
		}
		System.out.println("XP required for next level: " + Colorize.BLUE + ((500 * level) - xp) + " XP" + Colorize.RESET);
		System.out.println("");
	}

	/**
	 * Return some info about the player mainly for battle (includes only potions from inventory)
	 * @return The info inside a string
	 */
	public static String playerInfoString()
	{
		return Colorize.UNDERLINE + classColor + "Player" + Colorize.RESET + ":" + "\n > " + Colorize.RED + "HP" +  Colorize.RESET + ": " + hp  + "/" + maxHP + "\n > " + Colorize.YELLOW + "Strength" + Colorize.RESET + ": " + strength + "\n" + Colorize.SEPARATOR_SMALL + "\n > " + Colorize.MAGENTA + "Potions" + Colorize.RESET +": " + Inventory.get("potions");
	}
}
