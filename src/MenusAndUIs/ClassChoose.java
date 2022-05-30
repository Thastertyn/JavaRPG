package MenusAndUIs;

import java.util.Scanner;

import Classes.DataAndOtherStuff;
import Classes.Inventory;
import Classes.Player;
import Colors.Colorize;
import Managers.GameManager;

public class ClassChoose {
	
	static Scanner sc = new Scanner(System.in);

	public static void chooseWizard()
	{
		System.out.print(Colorize.CLEAR);
		System.out.println(Colorize.MAGENTA + Colorize.UNDERLINE +"> Wizard" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);
		System.out.println("You choose Wizard");
		System.out.println(" > HP: " + DataAndOtherStuff.WIZARD_HP);
		System.out.println(" > Strength: " + DataAndOtherStuff.WIZARD_STRENGTH);
		System.out.println(" > Speciality: Very high damage, but lower hp");
		
		System.out.println("");

		System.out.println("Are you sure with your decision?");
		System.out.println(" 1.> " + Colorize.GREEN + "Yes" + Colorize.RESET);
		System.out.println(" 2.> " + Colorize.RED + "No" + Colorize.RESET);

		System.out.print(Colorize.PROMPT);
		String input = sc.next();
		input.toLowerCase();

		switch(input)
		{
			case "yes":
			case "y":
			case "1":
				finish("wizard");
				break;
			case "no":
			case "n":
			case "2":
				Menu.classChoose();
				break;
			default:
				GameManager.missInput();
				chooseWizard();
		}
	}

	public static void chooseDwarf()
	{
		System.out.print(Colorize.CLEAR);
		System.out.println(Colorize.CYAN + Colorize.UNDERLINE +"> Dwarf" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);
		System.out.println("You choose Dwarf");
		System.out.println(" > HP: " + DataAndOtherStuff.DWARF_HP);
		System.out.println(" > Strength: " + DataAndOtherStuff.DWARF_STRENGTH);
		System.out.println(" > Ability: Has level 2 Armor and tier 2 Weapon from the start");
		
		System.out.println("");

		System.out.println("Are you sure with your decision?");
		System.out.println(" 1.> " + Colorize.GREEN + "Yes" + Colorize.RESET);
		System.out.println(" 2.> " + Colorize.RED + "No" + Colorize.RESET);

		System.out.print(Colorize.PROMPT);
		String input = sc.next();
		input.toLowerCase();

		switch(input)
		{
			case "yes":
			case "y":
			case "1":
				finish("dwarf");
				break;
			case "no":
			case "n":
			case "2":
				Menu.classChoose();
				break;
			default:
				GameManager.missInput();
				chooseWizard();
		}
	}

	public static void chooseElf()
	{
		System.out.print(Colorize.CLEAR);
		System.out.println(Colorize.WHITE + Colorize.UNDERLINE +"> Elf" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);
		System.out.println("You choose Elf");
		System.out.println(" > HP: " + DataAndOtherStuff.ELF_HP);
		System.out.println(" > Strength: " + DataAndOtherStuff.ELF_STRENGTH);
		System.out.println(" > Ability: None");

		System.out.println("");
		
		System.out.println("Are you sure with your decision?");
		System.out.println(" 1.> " + Colorize.GREEN + "Yes" + Colorize.RESET);
		System.out.println(" 2.> " + Colorize.RED + "No" + Colorize.RESET);

		System.out.print(Colorize.PROMPT);
		String input = sc.next();
		input.toLowerCase();

		switch(input)
		{
			case "yes":
			case "y":
			case "1":
				finish("elf");
				break;
			case "no":
			case "n":
			case "2":
				Menu.classChoose();
				break;
			default:
				GameManager.missInput();
				chooseWizard();
		}
	}

	public static void chooseHuman()
	{
		System.out.print(Colorize.CLEAR);
		System.out.println(Colorize.YELLOW + Colorize.UNDERLINE +"> Human" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);
		System.out.println("You choose Human");
		System.out.println(" > HP: " + DataAndOtherStuff.HUMAN_HP);
		System.out.println(" > Strength: " + DataAndOtherStuff.HUMAN_STRENGTH);
		System.out.println(" > Ability: Starts with some items alredy (wood 200, iron 50, leather 50, potions 5, gems 3)");
		
		System.out.println("");

		System.out.println("Are you sure with your decision?");
		System.out.println(" 1.> " + Colorize.GREEN + "Yes" + Colorize.RESET);
		System.out.println(" 2.> " + Colorize.RED + "No" + Colorize.RESET);

		System.out.print(Colorize.PROMPT);
		String input = sc.next();
		input.toLowerCase();

		switch(input)
		{
			case "yes":
			case "y":
			case "1":
				finish("human");
				break;
			case "no":
			case "n":
			case "2":
				Menu.classChoose();
				break;
			default:
				GameManager.missInput();
				chooseWizard();
		}
	}

	static void finish(String classString)
	{
		Inventory.init();
		Player.init(classString);
		System.out.println(Player.playerInfoString());
		ActionMenu.mainMenu();
	}
}
