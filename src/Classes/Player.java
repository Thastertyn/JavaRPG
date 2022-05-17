package Classes;

import java.util.Random;

import Colors.Colorize;

public class Player {
	
	public static boolean isInvincible = false;
	public static boolean isSuperStrong = false;

	// can be buffed by crafting a 
	public static int maxHP;
	public static int hp;

	// 8 Levels of weapons
	public static int strength;

	// 6 Tiers or armor
	public static int armor;

	public static int tier = 1;
	public static String playerClass;

	static Random rnd = new Random();

	public static void attack(Enemy enemy)
	{
		int hitOrMiss = rnd.nextInt(99);

		if(hitOrMiss < 5)
		{
			System.out.println("You missed");
		}else{
			enemy.hp -= strength;
		}

	}

	static boolean isDefending = false;

	public static void defend(boolean usePotion)
	{
		int hitOrMiss = rnd.nextInt(99);

		if(hitOrMiss >= 5)
		{
			isDefending = true;
		}else{
			isDefending = false;
		}

	}

	static void wasHit(Enemy e)
	{
		if(!isDefending)
		{
			hp -= e.strength;
		}
	}

	// toString can't be static, which it has to be if there is only one player, therefore everything else is being static
	public static String playerInfoString()
	{
		return " > Player:" + "\n > HP:" + hp + "\n > Strength:" + strength + "\n" + Colorize.SEPARATOR_SMALL + "\n > Potions: " + Inventory.get("potions");
	}
}
