package Managers;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Classes.Enemy;
import Classes.Inventory;
import Classes.Player;
import Colors.Colorize;

// For the finall battle, had to kinda tweak the battle manager, so this is the hybrid version for the final battle
public class Final
{
	static Scanner sc = new Scanner(System.in);
	static Random rnd = new Random();

	public static Enemy duck = new Enemy(69, 2);
	public static int enemyCounts = 1;

	// Kinda a combination of the two above, its just for the enemy choosing
	public static ArrayList<String> enemiesThatExist = new ArrayList<>();

	static int xpGained = 0;

	// Special location tells whether the player found either a lair or a bathroom
	public static void startBattle()
	{
		xpGained = 0;

		System.out.println(Colorize.RED + Colorize.UNDERLINE + "! ⁠BATTLE ⁠!" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);

		BattleMenuRipoff.battleMenu();
	}

	/**
	 * <p> Every enemy there currently is will attack the player </p>
	 */
	static void enemyAttack()
	{
		int hitOrMiss = rnd.nextInt(11);

		if(hitOrMiss != 0)
		{
			System.out.println(Colorize.RED + Colorize.capitalize(duck.enemyString) + " managed to land a hit dealing " + duck.strength + " damage" + Colorize.RESET);
			Player.hp -= duck.strength;
			if(Player.hp <= 0)
			{
				GameManager.playerDied();
			}
		}else{
			System.out.println(Colorize.GREEN + "The Duck completely missed you" + Colorize.RESET);
		}

		sc.nextLine();
		BattleMenuRipoff.battleMenu();
	}

	/**
	 * 
	 * @param index Index of the enemy to attack
	 * <p> Get an enemy and deal according damage </p>
	 */
	static void playerAttack()
	{
		System.out.println(Colorize.BLUE + "You Attacked The Duck "  + Colorize.RESET);

		int hitOrMiss = rnd.nextInt(19);

		if(hitOrMiss == 0)
		{
			System.out.println(Colorize.RED + "You missed your attack" + Colorize.RESET);
			System.out.println("");
		}else{
			duck.hp -= Player.strength;
			
			if(duck.hp <= 0)
			{
				System.out.println("You killed him, wait what?");
				System.out.println("The Duck is dead?");
				sc.nextLine();
				GameManager.PlayerWon();
			}else{
				System.out.println(Colorize.GREEN + "You Dealt " + Player.strength + " To The Duck");
				System.out.println("The Duck was left with " + duck.hp + " HP");
				enemyAttack();
			}
		}
	}

	static void defend(boolean usePotion)
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
			BattleMenuRipoff.battleMenu();
		}else{
			BattleManager.enemyAttack();
		}
	}
}

class BattleMenuRipoff
{
	static Scanner sc = new Scanner(System.in);

	public static void battleMenu()
	{
		System.out.print(Colorize.CLEAR);
		System.out.println(Colorize.BLUE + ">> BATTLE  WITH THE DUCK <<" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_MEDIUM);
		System.out.println(Player.playerInfoString());
		System.out.println(Colorize.SEPARATOR_MEDIUM);
		System.out.println("You can now do the following:");
		System.out.println(" 1.> Attack");
		System.out.println(" 2.> Defend (allows taking a potion item)");

		System.out.print(Colorize.PROMPT);
		String input = sc.next();
		input.toLowerCase();

		switch(input)
		{
			case "a":
			case "attack":
			case "1":
				chooseEnemy();
				break;
			case "d":
			case "defend":
			case "2":
				defendMenu();
				break;
			default:
				GameManager.missInput();
				battleMenu();
				break;
		}
	}

	public static void chooseEnemy()
	{
		System.out.print(Colorize.RESET + Colorize.CLEAR);
		System.out.println(Colorize.BLUE + ">> BATTLE WITH THE DUCK <<" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);
		System.out.println("You can choose from:");
		System.out.println(" 1.> The Duck");

		System.out.print(Colorize.PROMPT);
		String enemyInput = sc.next();
		enemyInput = Colorize.sterilize(enemyInput);
		
		if(enemyInput.equals("d") || enemyInput.equals("duck") || enemyInput.equals("1"))
		{
			Final.playerAttack();
		}else{
			GameManager.missInput();
			chooseEnemy();
		}
	}

	public static void defendMenu()
	{
		System.out.println("");
		System.out.println("Do you want to use a potion?");
		System.out.println(" 1.> Yes");
		System.out.println(" 2.> No");

		System.out.print(Colorize.PROMPT);
		String input = sc.next();
		input = Colorize.sterilize(input);

		switch(input)
		{
			case "y":
			case "yes":
			case "1":
				Final.defend(true);
				break;
			case "n":
			case "no":
			case "2":
				Final.defend(false);
				break;
		}
	}
}