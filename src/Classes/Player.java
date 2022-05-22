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

	public static int armor;

	public static int tier = 1;
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
				playerClass = "elf";
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

	public static void defend(boolean usePotion)
	{
		int hitOrMiss = rnd.nextInt(99);

		if(hitOrMiss >= 5)
		{
			isDefending = true;
		}else{
			isDefending = false;
		}

		if(usePotion && Inventory.get("potion") > 0)
		{
			hp += maxHP / 2;
		}
	}

	// toString can't be static, which it has to be if there is only one player, therefore everything else is being static
	public static String playerInfoString()
	{
		return Colorize.UNDERLINE + classColor + "Player" + Colorize.RESET + ":" + "\n > HP:" + hp + "/" + maxHP + "\n > Strength:" + strength + "\n" + Colorize.SEPARATOR_SMALL + "\n > Potions: " + Inventory.get("potions");
	}
}
