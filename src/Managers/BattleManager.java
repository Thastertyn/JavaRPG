package Managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import MenusAndUIs.BattleMenu;
import Classes.DataAndOtherStuff;
import Classes.Enemy;
import Classes.Player;
import Colors.Colorize;

public class BattleManager {

	static Scanner sc = new Scanner(System.in);
	static Random rnd = new Random();

	public static ArrayList<Enemy> enemies = new ArrayList<>();
	public static int[] enemyCounts = new int[DataAndOtherStuff.ENEMY_IDS.length];

	// Kinda a combination of the two above, its just for the enemy choosing
	public static ArrayList<String> enemiesThatExist = new ArrayList<>();

	public static void startBattle(int enemyCount, int enemyRarity)
	{
		Arrays.fill(enemyCounts, 0);

		for(int i = 0; i < enemyCount; i++)
		{
			enemies.add(new Enemy(enemyRarity));
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

		BattleMenu.battleMenu(false);
	}

	/**
	 * <p>
	 * Every enemy there currently is will attack the player
	 * </p>
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
		BattleMenu.battleMenu(false);
	}


	/**
	 * 
	 * @param index Index of the enemy to attack
	 * <p>
	 * Get an enemy and deal according damage
	 * </p>
	 */
	public static void playerAttack(int index)
	{
		System.out.println(Colorize.BLUE + "You Attacked " + enemies.get(index).enemyString + Colorize.RESET);
		int hitOrMiss = rnd.nextInt(19);

		if(hitOrMiss == 0)
		{
			System.out.println(Colorize.RED + "You missed your attack" + Colorize.RESET);
			System.out.println("");
			isPlayable();
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
	}

	static void isPlayable()
	{
		if(enemies.isEmpty())
		{
			System.out.println("");
			System.out.println(Colorize.GREEN + Colorize.HIGH_INTENSITY + "Congratulations, you won" + Colorize.RESET);
			endBattle();
			sc.nextLine();
		}else{
			enemyAttack();
		}
	}

	static void enemyDied(Enemy e)
	{
		enemyCounts[EnemyManager.getEnemyId(e.enemyString)]--;
		enemies.remove(e);
	}
}
