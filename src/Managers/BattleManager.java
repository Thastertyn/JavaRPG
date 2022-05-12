package Managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import MenusAndUIs.ActionMenu;
import MenusAndUIs.BattleMenu;
import Classes.DataAndOtherStuff;
import Classes.Enemy;

public class BattleManager {

	static Scanner sc = new Scanner(System.in);

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

		BattleMenu.battleMenu(false);
		System.out.print("\n");

		System.out.println("You fought some enemies");

		sc.nextLine();
	}

	static void getEnemyCount()
	{
		for(Enemy e : enemies)
		{
			switch(e.enemyString.toLowerCase())
			{
				case "slime":
					enemyCounts[0]++;
					System.out.println("found a " + e.enemyString + " giving a total of " + enemyCounts[0]);
					break;
				case "hog":
					enemyCounts[1]++;
					System.out.println("found a " + e.enemyString + " giving a total of " + enemyCounts[1]);
					break;
				case "bear":
					enemyCounts[2]++;
					System.out.println("found a " + e.enemyString + " giving a total of " + enemyCounts[2]);
					break;
				case "goblin":
					enemyCounts[3]++;
					System.out.println("found a " + e.enemyString + " giving a total of " + enemyCounts[3]);
					break;
				case "zombie":
					enemyCounts[4]++;
					System.out.println("found a " + e.enemyString + " giving a total of " + enemyCounts[4]);
					break;
				case "skeleton":
					enemyCounts[5]++;
					System.out.println("found a " + e.enemyString + " giving a total of " + enemyCounts[5]);
					break;
				case "ogre":
					enemyCounts[6]++;
					System.out.println("found a " + e.enemyString + " giving a total of " + enemyCounts[6]);
					break;
				case "witch":
					enemyCounts[7]++;
					System.out.println("found a " + e.enemyString + " giving a total of " + enemyCounts[7]);
					break;
				case "mage":
					enemyCounts[8]++;
					System.out.println("found a " + e.enemyString + " giving a total of " + enemyCounts[8]);
					break;
				case "centaur":
					enemyCounts[9]++;
					System.out.println("found a " + e.enemyString + " giving a total of " + enemyCounts[9]);
					break;
				case "noone":
					enemyCounts[10]++;
					System.out.println("found a " + e.enemyString + " giving a total of " + enemyCounts[10]);
					break;
			}
		}

		// Todo dont forget to reset the enemycounts on battle end
	}
}
