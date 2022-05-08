package Managers;

import java.util.ArrayList;
import java.util.Scanner;

import MenusAndUIs.ActionMenu;
import Classes.Enemy;

public class BattleManager {

	static Scanner sc = new Scanner(System.in);

	public static void startBattle(int enemyCount, int enemyRarity)
	{
		ArrayList<Enemy> enemies = new ArrayList<>();

		for(int i = 0; i < enemyCount; i++)
		{
			enemies.add(new Enemy(enemyRarity));
		}
		
		for(int i = 0; i < enemyCount; i++)
		{
			if(i % 4 == 0 && i != 0)
			{
				System.out.println(enemies.get(i).enemyString + " ");
			}else{
				System.out.print(enemies.get(i).enemyString + " ");
			}
		}
		System.out.print("\n");

		System.out.println("You founght some enemies");
		sc.nextLine();

		ActionMenu.mainMenu(false);
	}
}
