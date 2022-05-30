package Managers;

import java.util.ArrayList;
import java.util.Collections;

import Classes.DataAndOtherStuff;
import Classes.Enemy;
import Colors.Colorize;

public class EnemyManager {

	// Index is the position where was the enemy written, value is the enemyID as in the menu
	// 1.(Index) > Slime (Enemy Id in BattleManager)
	public static ArrayList<String> writtenPositions = new ArrayList<>(Collections.nCopies(DataAndOtherStuff.ENEMY_IDS.length, ""));

	/**
	 * @param input String input of player choosing an enemy, or just enemy name
	 * @return An Id of an enemy relative the DataAndOtherStuff.ENEMY_IDS
	 * <p>
	 * Just turns their enemyText into their index inside all the enemies array
	 * </p>
	 */
	public static int getEnemyId(String input)
	{
		switch(input)
		{
			case "slime":
			case "sl":
			case "1":
				return 0;
			case "hog":
			case "h":
			case "2":
				return 1;
			case "bear":
			case "b":
			case "3":
				return 2;
			case "goblin":
			case "g":
			case "4":
				return 3;
			case "zombie":
			case "z":
			case "5":
				return 4;
			case "skeleton":
			case "sk":
			case "6":
				return 5;
			case "ogre":
			case "o":
			case "7":
				return 6;
			case "witch":
			case "w":
			case "8":
				return 7;
			case "mage":
			case "m":
			case "9":
				return 8;
			case "centaur":
			case "c":
			case "10":
				return 9;
			case "noone":
			case "n":
			case "11":
				return 10;
			case "duck":
			case "d":
			case "12":
				return 11;
			default:
				return -1;
		}
	}

	/**
	 * @param input User input given from scanner
	 * @return A valid enemy index inside the BattleManager.enemies ArrayList
	 * <p>
	 * Unlike getEnemyId, this turns input into enemy position inside the ArrayList in BattleManager
	 * </p>
	 */
	public static int getEnemyIndex(String input)
	{
		if(input.matches("[0-9]+") )
		{
			if(Integer.parseInt(input) <= BattleManager.enemiesThatExist.size())
			{
				int indexGiven = getEnemyId(BattleManager.enemiesThatExist.get(Integer.parseInt(input) - 1));
				for(Enemy e : BattleManager.enemies)
				{
					if(getEnemyId(e.enemyString) == indexGiven)
					{
						return BattleManager.enemies.indexOf(e);
					}
				}
			}else{
				return -1;
			}
		}else{
			int indexGiven = getEnemyId(input);
			
			if(indexGiven != -1)
			{
				for(Enemy e : BattleManager.enemies)
				{
					if(getEnemyId(e.enemyString) == indexGiven)
					{
						return BattleManager.enemies.indexOf(e);
					}
				}
			}
		}

		return -1;
	}

	public static void writeEnemies(String howToWrite)
	{
		switch(howToWrite)
		{
			case "short":
			// Gets just the total amount of the specific enemies
				for(int i = 0; i < BattleManager.enemyCounts.length; i++)
				{
					if(BattleManager.enemyCounts[i] != 0)
					{
						if(BattleManager.enemyCounts[i] == 1)
						{
							System.out.println(" > " + BattleManager.enemyCounts[i] + " " + Colorize.capitalize(DataAndOtherStuff.ENEMY_IDS[i]));
						}else{
							String plural = (DataAndOtherStuff.ENEMY_IDS[i].equals("witch")) ? "es" : "s";
							System.out.println(" > " + BattleManager.enemyCounts[i] + " " + Colorize.capitalize(DataAndOtherStuff.ENEMY_IDS[i]) + plural);
						}
					}
				}
				break;
			case "long":
				// Also adds the enemy counting, to be able to choose
				int enemyPos = 1;

				for(int i = 0; i < BattleManager.enemyCounts.length; i++)
				{
					if(BattleManager.enemyCounts[i] != 0)
					{
						if(BattleManager.enemyCounts[i] == 1)
						{
							System.out.println(" " + enemyPos + ".> " + BattleManager.enemyCounts[i] + " " + Colorize.capitalize(DataAndOtherStuff.ENEMY_IDS[i]));
						}else{
							String plural = (DataAndOtherStuff.ENEMY_IDS[i].equals("witch")) ? "es" : "s";
							System.out.println(" " + enemyPos + ".> " + BattleManager.enemyCounts[i] + " " + Colorize.capitalize(DataAndOtherStuff.ENEMY_IDS[i]) + plural);
						}
						enemyPos++;
					}
				}
				break;
		}
	}

	public static int getTotalEnemyCount()
	{
		int count = 0;

		for(int i = 0; i < BattleManager.enemyCounts.length; i++)
		{
			count += BattleManager.enemyCounts[i];
		}
		return count;
	}
}
