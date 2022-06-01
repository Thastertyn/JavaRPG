package Managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import MenusAndUIs.ActionMenu;
import MenusAndUIs.BattleMenu;
import Classes.DataAndOtherStuff;
import Classes.Enemy;
import Classes.Inventory;
import Classes.Player;
import Colors.Colorize;

public class BattleManager {

	static Scanner sc = new Scanner(System.in);
	static Random rnd = new Random();

	public static ArrayList<Enemy> enemies = new ArrayList<>();
	public static int[] enemyCounts = new int[DataAndOtherStuff.ENEMY_IDS.length];

	// Kinda a combination of the two above, its just for the enemy choosing
	public static ArrayList<String> enemiesThatExist = new ArrayList<>();

	static int xpGained = 0;

	// Special location tells whether the player found either a lair or a bathroom
	public static void startBattle(int enemyCount, int enemyRarity, int specialLocation)
	{
		Arrays.fill(enemyCounts, 0);
		xpGained = 0;

		for(int i = 0; i < enemyCount; i++)
		{
			enemies.add(new Enemy(enemyRarity, specialLocation));
		}
		
		for(Enemy e : enemies)
		{
			int index = EnemyManager.getEnemyId(e.enemyString);
			enemyCounts[index]++;
		}

		for(int i = 0; i < enemyCounts.length; i++)
		{
			if(enemyCounts[i] != 0)
			{
				enemiesThatExist.add(DataAndOtherStuff.ENEMY_IDS[i]);
			}
		}

		System.out.println(Colorize.RED + Colorize.UNDERLINE + "! ⁠BATTLE ⁠!" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);

		BattleMenu.battleMenu();
	}

	/**
	 * <p> Every enemy there currently is will attack the player </p>
	 */
	public static void enemyAttack()
	{
		for(Enemy e : enemies)
		{
			int hitOrMiss = rnd.nextInt(2);

			if(hitOrMiss == 0)
			{
				System.out.println(Colorize.RED + Colorize.capitalize(e.enemyString) + " managed to land a hit dealing " + e.strength + " damage" + Colorize.RESET);
				Player.hp -= e.strength;

				if(Player.hp <= 0)
				{
					GameManager.playerDied();
				}
			}else{
				System.out.println(Colorize.GREEN + Colorize.capitalize(e.enemyString) + " completely missed you" + Colorize.RESET);
			}
		}

		sc.nextLine();
		BattleMenu.battleMenu();
	}

	/**
	 * 
	 * @param index Index of the enemy to attack
	 * <p> Get an enemy and deal according damage </p>
	 */
	public static void playerAttack(int index)
	{
		System.out.println(Colorize.BLUE + "You Attacked " + enemies.get(index).enemyString + Colorize.RESET);
		int hitOrMiss = rnd.nextInt(19);

		if(hitOrMiss == 0)
		{
			System.out.println(Colorize.RED + "You missed your attack" + Colorize.RESET);
			System.out.println("");
		}else{
			enemies.get(index).hp -= Player.strength;
			
			if(enemies.get(index).hp <= 0)
			{
				System.out.println(Colorize.YELLOW + Colorize.HIGH_INTENSITY + "You killed him, the " + Colorize.capitalize(enemies.get(index).enemyString) + " is dead!" + Colorize.RESET);
				enemyDied(enemies.get(index));
			}else{
				System.out.println(Colorize.GREEN + "You Dealt " + Player.strength + " to " + enemies.get(index).enemyString);
			}
		}

		isPlayable();
	}

	public static void endBattle()
	{
		enemies.clear();

		System.out.println(Colorize.GREEN + Colorize.HIGH_INTENSITY + "Congratulations, you won" + Colorize.RESET);

		System.out.println("You also gained " + Colorize.BLUE + xpGained + " XP " + Colorize.RESET +"from enemies");

		Player.addXP(xpGained);
		sc.nextLine();

		ActionMenu.mainMenu();
	}

	static void isPlayable()
	{
		System.out.println("");

		if(enemies.isEmpty())
		{
			endBattle();
		}else{
			enemyAttack();
		}
	}

	static void enemyDied(Enemy e)
	{
		// Each enemy gives 50 * their relative id
		xpGained += (EnemyManager.getEnemyId(e.enemyString) + 1) * rnd.nextInt(30, 61);

		enemyCounts[EnemyManager.getEnemyId(e.enemyString)]--;
		enemies.remove(e);

		// Remove the enemy from enemiesThatExist, if none of their kind exist anymore
		if(BattleManager.enemyCounts[EnemyManager.getEnemyId(e.enemyString)] == 0)
		{
			BattleManager.enemiesThatExist.remove(BattleManager.enemiesThatExist.indexOf(e.enemyString));
		}

		Player.enemyKills++;

		Player.coins += EnemyManager.getEnemyId(e.enemyString) * rnd.nextInt(10, 21);
	}

	public static void defend(boolean usePotion)
	{
		int hitOrMiss = rnd.nextInt(2);

		if(usePotion)
		{
			if(Inventory.get("potions") <= 0)
			{
				System.out.println("You can't use a potion, you don't have any");
			}else{
				Player.hp += Player.maxHP / 2;
		
				if(Player.hp > Player.maxHP)
					Player.hp = Player.maxHP;
		
				System.out.println("You used a potion and healed to [" + Player.hp + "/" + Player.maxHP + " HP]");	
			}
		}

		sc.nextLine();
		
		if(hitOrMiss == 1)
		{
			BattleMenu.battleMenu();
		}else{
			BattleManager.enemyAttack();
		}
	}

	public static void escape()
	{
		int escaped = rnd.nextInt(3);
		
		if(escaped == 0)
		{
			System.out.println(Colorize.GREEN + "You successfully escaped" + Colorize.RESET);
			sc.nextLine();
			ActionMenu.mainMenu();
		}else{
			System.out.println(Colorize.RED + "You tried escaping, but failed" + Colorize.RESET);
			BattleManager.enemyAttack();
		}

		sc.nextLine();
	}
}