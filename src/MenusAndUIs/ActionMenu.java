// The 200 line limit is dumb
package MenusAndUIs;

import Colors.Colorize;
import Searching.SearchManager;

import java.util.Scanner;

public class ActionMenu {

	static Scanner sc = new Scanner(System.in);

	public static void mainMenu()
	{
		System.out.print(Colorize.RESET + Colorize.CLEAR);

		System.out.println("----------------------------------");
		System.out.println("You can now do the following:\n 1.> Search\n 2.> Hunt (Enemies)\n 3.> Craft something");

		System.out.print(Colorize.PROMPT);

		String actionInput = sc.next();
		actionInput.toLowerCase();

		switch(actionInput)
		{
			case "s":
			case "search":
			case "1":
				System.out.println("You went to search for something");
				SearchManager.search();
				break;
			case "h":
			case "hunt":
			case "2":
				System.out.println("You went hunting something");
				break;
			case "c":
			case "craft":
			case "3":
				System.out.println("You opened your inventory");
				break;
		}

		sc.next();

		mainMenu();

	}
}
