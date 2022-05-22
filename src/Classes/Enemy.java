package Classes;

import java.util.Random;

public class Enemy {
	
	Random rnd = new Random();

	public int hp;
	public int strength;
	public String enemyString;
	public String shortEnemyString;

	public Enemy(int rarity)
	{
		// Random enemy inbetween the lowest and highest given rarity
		int enemyType = rnd.nextInt(rarity);
		int enemyId;
		enemyType++;

		switch(enemyType)
		{
			case 1:
				enemyId = rnd.nextInt(2);
				enemyString = DataAndOtherStuff.TIER1IDS[enemyId];
				shortEnemyString = DataAndOtherStuff.TIER1SHORT_IDS[enemyId];
				hp = DataAndOtherStuff.TIER1_HP[enemyId];
				strength = DataAndOtherStuff.tier1Strength[enemyId];
				break;
			case 2:
				enemyId = rnd.nextInt(3);
				enemyString = DataAndOtherStuff.TIER2IDS[enemyId];
				shortEnemyString = DataAndOtherStuff.TIER2SHORT_IDS[enemyId];
				hp = DataAndOtherStuff.TIER2_HP[enemyId];
				strength = DataAndOtherStuff.tier2Strength[enemyId];
				break;
			case 3:
				enemyId = rnd.nextInt(2);
				enemyString = DataAndOtherStuff.TIER3IDS[enemyId];
				shortEnemyString = DataAndOtherStuff.TIER3SHORT_IDS[enemyId];
				hp = DataAndOtherStuff.TIER3_HP[enemyId];
				strength = DataAndOtherStuff.tier3Strength[enemyId];
				break;
			case 4:
				enemyId = rnd.nextInt(2);
				enemyString = DataAndOtherStuff.TIER4IDS[enemyId];
				shortEnemyString = DataAndOtherStuff.TIER4SHORT_IDS[enemyId];
				hp = DataAndOtherStuff.TIER4_HP[enemyId];
				strength = DataAndOtherStuff.tier4Strength[enemyId];
				break;
			case 5:
				enemyId = rnd.nextInt(2);
				enemyString = DataAndOtherStuff.TIER5IDS[enemyId];
				shortEnemyString = DataAndOtherStuff.TIER5SHORT_IDS[enemyId];
				hp = DataAndOtherStuff.TIER5_HP[enemyId];
				strength = DataAndOtherStuff.tier5Strength[enemyId];
				break;
			case 6:
				enemyString = "duck";
				shortEnemyString = "d";
				hp = DataAndOtherStuff.DUCK_HP;
				strength = DataAndOtherStuff.duckStrength;
				break;
		}
	}

	@Override
	public String toString()
	{
		return "Enemy is: " + enemyString + "\nHP = " + hp + "\nStrength = " + strength;
	}
}
