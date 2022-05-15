package Managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import MenusAndUIs.ActionMenu;
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

	public static void startBattle(int enemyCount, int enemyRarity)
	{
		Arrays.fill(enemyCounts, 0);

		for(int i = 0; i < enemyCount; i++)
		{
			enemies.add(new Enemy(enemyRarity));
		}

		getEnemyCount();

		System.out.print(Colorize.RESET + Colorize.CLEAR);
		System.out.println(Colorize.RED + "! You were attacked by " + EnemyManager.getTotalEnemyCount() + " enemies !" + Colorize.RESET);

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
				System.out.println(Colorize.capitalize(e.enemyString) + " managed to land a hit dealing " + e.strength + " damage");
				Player.hp -= e.strength;

				if(Player.hp <= 0)
				{
					GameManager.playerDied();
				}
			}else{
				System.out.println(Colorize.capitalize(e.enemyString) + " completely missed you");
			}
		}

		sc.nextLine();
		BattleMenu.battleMenu(false);
	}


	/**
	 * 
	 * @param writtenIndex Index of the enemy to attack
	 * <p>
	 * Get an enemy and deal according damage
	 * </p>
	 */
	public static void playerAttack(int writtenIndex)
	{
		int hitOrMiss = rnd.nextInt(19);

		if(hitOrMiss == 0)
		{
			System.out.println("You missed you attack");
			enemyAttack();
		}else{
			// get first enemy, whose enemyID is equal to the one from written positions
			//System.out.println(enemies.get(EnemyManager.writtenPositions.get(writtenIndex)).toString()); 
			enemies.get(EnemyManager.writtenPositions.get(writtenIndex)).hp -= Player.strength;
			enemies.get(EnemyManager.writtenPositions.get(writtenIndex)).wasAttacked = true;

			if(enemies.get(EnemyManager.writtenPositions.get(writtenIndex)).hp <= 0)
			{
				enemyDied(enemies.get((EnemyManager.writtenPositions.get(writtenIndex))));
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
			System.out.println("Congratulations, you won");
			sc.nextLine();
			endBattle();
			ActionMenu.mainMenu(false);
		}else{
			enemyAttack();
		}
	}

	static void enemyDied(Enemy e)
	{
		System.out.println("You killed him, the " + Colorize.capitalize(e.enemyString) + " is dead!");
		enemyCounts[EnemyManager.getEnemyIndex(e.enemyString)]--;
		enemies.remove(e);
	}

	static void getEnemyCount()
	{
		for(Enemy e : enemies)
		{
			int index = EnemyManager.getEnemyIndex(e.enemyString);
			enemyCounts[index]++;
		}
	}
}
