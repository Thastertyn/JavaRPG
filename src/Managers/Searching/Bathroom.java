package Managers.Searching;

import java.util.Random;
import java.util.Scanner;

import Colors.Colorize;
import Managers.Final;

public class Bathroom {
	
	static Random rnd = new Random();
	static Scanner sc = new Scanner(System.in);

	public static void wasFound()
	{
		System.out.print(Colorize.CLEAR);
		System.out.println("You suddenly appear in complete darkness");
		sc.nextLine();
		System.out.println("You lit up your torch, but still can't see anything");
		sc.nextLine();
		System.out.println("All of the sudden everything lit up...");
		System.out.println("It looks like...");
		System.out.println("A GIANT BATHROOM!");
		sc.nextLine();
		System.out.println("A loud \"Quack\" echoed through the room, you went to investigate");
		sc.nextLine();
		System.out.println("The noises were getting louder, but no source still visible");
		sc.nextLine();
		System.out.println("You suddently saw it...");
		System.out.println("A Giant Duck");
		System.out.println("It's the super intergalactic duck");
		System.out.println("Ready to take you down with the rest of the world");
		sc.nextLine();

		System.out.println("You can try escaping while you can, or take it head on");
		System.out.println("What do you choose?");
		System.out.println(" 1.> Fight");
		System.out.println(" 2.> Escape");

		switch(Colorize.scannerize(sc.next()))
		{
			case "f":
			case "fight":
			case "1":
				System.out.println("You are ready to fight it, LETS GO!");
				Final.startBattle();
				break;
			case "e":
			case "escape":
			case "2":
				System.out.println("You ran away, while you still were unnoticed");
				break;
		}
	}
}
