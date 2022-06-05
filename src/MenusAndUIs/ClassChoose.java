package MenusAndUIs;

import java.util.Scanner;
import java.util.Random;

import Classes.ASCII;
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
		System.out.println(" > " + Colorize.RED + "HP" + Colorize.RESET + ": " + DataAndOtherStuff.WIZARD_HP);
		System.out.println(" > " + Colorize.YELLOW + "Strength" + Colorize.RESET + ": " + DataAndOtherStuff.WIZARD_STRENGTH);
		System.out.println(Colorize.SEPARATOR_SMALL);
		System.out.println(" > " + Colorize.MAGENTA + "Max Weapon Tier" + Colorize.RESET + ": " + DataAndOtherStuff.WIZARD_MAX_WEAPON);
		System.out.println(" > " + Colorize.BLUE + "Max Armor Level" + Colorize.RESET + ": " + DataAndOtherStuff.WIZARD_MAX_ARMOR);
		System.out.println(Colorize.SEPARATOR_SMALL);
		System.out.println(" > " + Colorize.GREEN + "Speciality" + Colorize.RESET + ": Very high damage, but lower hp, can have only low Weapon and Armor levels");

		switch(areYouSure())
		{
			case 0:
				Random rnd = new Random();

				if(rnd.nextInt(100) == 0)
				{
					System.out.println(ASCII.WIZARD);
					sc.nextLine();
					sc.nextLine();
				}
					
				finish("wizard");
				break;
			case 1:
				Menu.classChoose();
				break;
			case -1:
				GameManager.missInput();
				chooseWizard();
				break;
		}
	}

	public static void chooseDwarf()
	{
		System.out.print(Colorize.CLEAR);
		System.out.println(Colorize.CYAN + Colorize.UNDERLINE +"> Dwarf" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);
		System.out.println("You choose Dwarf");
		System.out.println(" > " + Colorize.RED + "HP" + Colorize.RESET + ": " + DataAndOtherStuff.DWARF_HP);
		System.out.println(" > " + Colorize.YELLOW + "Strength" + Colorize.RESET + ": " + DataAndOtherStuff.DWARF_STRENGTH);
		System.out.println(Colorize.SEPARATOR_SMALL);
		System.out.println(" > " + Colorize.MAGENTA + "Max Weapon Tier" + Colorize.RESET + ": " + DataAndOtherStuff.DWARF_MAX_WEAPON);
		System.out.println(" > " + Colorize.BLUE + "Max Armor Level" + Colorize.RESET + ": " + DataAndOtherStuff.DWARF_MAX_ARMOR);
		System.out.println(Colorize.SEPARATOR_SMALL);
		System.out.println(" > " + Colorize.GREEN + "Speciality" + Colorize.RESET + ": Has level 2 Armor and tier 2 Weapon from the start, can get very high tier Armor and moderate Weapon");
		
		switch(areYouSure())
		{
			case 0:
				finish("dwarf");
				break;
			case 1:
				Menu.classChoose();
				break;
			case -1:
				GameManager.missInput();
				chooseWizard();
				break;
		}
	}

	public static void chooseElf()
	{
		System.out.print(Colorize.CLEAR);
		System.out.println(Colorize.WHITE + Colorize.UNDERLINE +"> Elf" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);
		System.out.println("You choose Elf");
		System.out.println(" > " + Colorize.RED + "HP" + Colorize.RESET + ": " + DataAndOtherStuff.ELF_HP);
		System.out.println(" > " + Colorize.YELLOW + "Strength" + Colorize.RESET + ": " + DataAndOtherStuff.ELF_STRENGTH);
		System.out.println(Colorize.SEPARATOR_SMALL);
		System.out.println(" > " + Colorize.MAGENTA + "Max Weapon Tier" + Colorize.RESET + ": " + DataAndOtherStuff.ELF_MAX_WEAPON);
		System.out.println(" > " + Colorize.BLUE + "Max Armor Level" + Colorize.RESET + ": " + DataAndOtherStuff.ELF_MAX_ARMOR);
		System.out.println(Colorize.SEPARATOR_SMALL);
		System.out.println(" > " + Colorize.GREEN + "Speciality" + Colorize.RESET + ": Can have very high level Armor and moderate Weapon");

		switch(areYouSure())
		{
			case 0:
				finish("elf");
				break;
			case 1:
				Menu.classChoose();
				break;
			case -1:
				GameManager.missInput();
				chooseElf();
				break;
		}
	}

	public static void chooseHuman()
	{
		System.out.print(Colorize.CLEAR);
		System.out.println(Colorize.YELLOW + Colorize.UNDERLINE +"> Human" + Colorize.RESET);
		System.out.println(Colorize.SEPARATOR_LARGE);
		System.out.println("You choose Human");
		System.out.println(" > " + Colorize.RED + "HP" + Colorize.RESET + ": " + DataAndOtherStuff.HUMAN_HP);
		System.out.println(" > " + Colorize.YELLOW + "Strength" + Colorize.RESET + ": " + DataAndOtherStuff.HUMAN_STRENGTH);
		System.out.println(Colorize.SEPARATOR_SMALL);
		System.out.println(" > " + Colorize.MAGENTA + "Max Weapon Tier" + Colorize.RESET + ": " + DataAndOtherStuff.HUMAN_MAX_WEAPON);
		System.out.println(" > " + Colorize.BLUE + "Max Armor Level" + Colorize.RESET + ": " + DataAndOtherStuff.HUMAN_MAX_ARMOR);
		System.out.println(Colorize.SEPARATOR_SMALL);
		System.out.println(" > " + Colorize.GREEN + "Speciality" + Colorize.RESET + ": Starts with some items alredy (wood 200, iron 50, leather 50, potions 3, gem 1), can have moderate Armor and Weapon");

		switch(areYouSure())
		{
			case 0:
				finish("human");
				break;
			case 1:
				Menu.classChoose();
				break;
			case -1:
				GameManager.missInput();
				chooseHuman();
				break;
		}
	}

	static int areYouSure()
	{
		System.out.println("");
		System.out.println("Are you sure with your decision?");
		System.out.println(" 1.> " + Colorize.GREEN + "Yes" + Colorize.RESET);
		System.out.println(" 2.> " + Colorize.RED + "No" + Colorize.RESET);

		System.out.print(Colorize.PROMPT);

		switch(Colorize.scannerize(sc.next()))
		{
			case "yes":
			case "y":
			case "1":
				return 0;
			case "no":
			case "n":
			case "2":
				return 1;
			default:
				return -1;
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
