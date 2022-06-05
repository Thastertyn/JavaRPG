package Classes;

import java.util.Random;

import Managers.EnemyManager;

public class Enemy {
	
	Random rnd = new Random();

	public int hp;
	public int strength;
	public String enemyString;
	public String shortEnemyString;
	public String enemyColor;

	public Enemy(int rarity, int specialLocation)
	{
		// Random enemy inbetween the lowest and highest given rarity
		int enemyRarity = rnd.nextInt(rarity);
		int enemyId;
		enemyRarity++;

		switch(specialLocation)
		{
			case 0:
				switch(enemyRarity)
				{
					case 1:
						enemyId = rnd.nextInt(2);
						enemyString = DataAndOtherStuff.TIER1IDS[enemyId];
						break;
					case 2:
						enemyId = rnd.nextInt(3);
						enemyString = DataAndOtherStuff.TIER2IDS[enemyId];
						break;
					case 3:
						enemyId = rnd.nextInt(2);
						enemyString = DataAndOtherStuff.TIER3IDS[enemyId];
						break;
					case 4:
						enemyId = rnd.nextInt(2);
						enemyString = DataAndOtherStuff.TIER4IDS[enemyId];
						break;
					case 5:
						enemyString = DataAndOtherStuff.TIER5ID;
						break;
					}
				break;
			case 1:
				// Lair
				enemyString = DataAndOtherStuff.TIER6ID;
				break;
			case 2:
				// Bathroom
				enemyString = DataAndOtherStuff.TIER7ID;
				break;
		}

		int id = EnemyManager.getEnemyId(enemyString);

		hp = DataAndOtherStuff.ENEMY_HEALTH[id];
		strength = DataAndOtherStuff.ENEMY_STRENGTH[id];
		shortEnemyString = DataAndOtherStuff.ENEMY_SHORT_IDS[id];
	}

	@Override
	public String toString()
	{
		return "Enemy is: " + enemyString + "\nHP = " + hp + "\nStrength = " + strength;
	}
}
