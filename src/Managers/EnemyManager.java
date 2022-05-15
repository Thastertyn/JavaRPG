package Managers;

import java.util.ArrayList;
import java.util.Collections;

import Classes.DataAndOtherStuff;
import Colors.Colorize;

public class EnemyManager {

	// Index is the position of the written enemy, value is the enemyID as in the menu
	public static ArrayList<Integer> writtenPositions = new ArrayList<>(Collections.nCopies(DataAndOtherStuff.ENEMY_IDS.length, 0)); 

	/**
	 * 
	 * @param input String input of player choosing an enemy, or just enemy name
	 * @return converted string to an enemy ID
	 */
	public static int getEnemyIndex(String input)
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

	public static void writeEnemies(boolean isPlayerChoosing)
	{
		int enemyPos = 1; 
		String choosingNumber;

		for(int i = 0; i < BattleManager.enemyCounts.length; i++)
		{
			// Add a number to the text if the player is currently supposed to choose an enemy
			if(isPlayerChoosing)
			{
				choosingNumber = " " + enemyPos + ".> ";
			}else{
				choosingNumber = " > ";
			}

			// Index is the position of the written enemy, value is the enemyID as in the menu
			writtenPositions.set(enemyPos, i);

			// Write only existing enemies (non 0)
			if(BattleManager.enemyCounts[i] != 0)
			{
				if(BattleManager.enemyCounts[i] == 1)
				{
					System.out.println(choosingNumber + BattleManager.enemyCounts[i] + " " + Colorize.capitalize(DataAndOtherStuff.ENEMY_IDS[i]));
				}else{
					String plural = (DataAndOtherStuff.ENEMY_IDS[i].equals("witch")) ? "es" : "s";
					System.out.println(choosingNumber + BattleManager.enemyCounts[i] + " " + Colorize.capitalize(DataAndOtherStuff.ENEMY_IDS[i]) + plural);
				}
				enemyPos++;
			}
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
