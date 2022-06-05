import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import Classes.Player;
import Colors.Colorize;
import Help.Help;
import MenusAndUIs.Menu;

// For Brackeys
public class App {

	static boolean saveData = false;
	
	// Java
	// Boilerplate-driven language designed for writing verbose object-oriented instant legacy code.

	// For documentation refer to the docs folder (not yet)
	public static void main(String[] args)
	{
		Runtime.getRuntime().addShutdownHook(new Thread()
		{
			@Override
			public void run()
			{
				quit();
			}
		}); 

		Scanner sc = new Scanner(System.in);

		System.out.print(Colorize.CLEAR);
		
		System.out.println(Colorize.MAGENTA +  "Hello, World!" + Colorize.RESET);

		for (int i = 0; i < args.length; i++)
		{
			args[i].toLowerCase();

			switch(args[i])
			{
				case "-h":
				case "--help":
					Help.flagHelp();
					break;
				case "-bh":
				case "--bigger-help":
					Help.fullHelp(false);
					break;
				case "-i":
				case "--invincible":
					Player.isInvincible = true;
					break;
				case "-s":
				case "--super-strength":
					Player.isSuperStrong = true;
					break;
				case "-sd":
				case "--save-data":
					saveData = true;
					break;
			}
		}

		Menu.mainMenu();
		
		sc.close();
	}

	static void quit()
	{
		System.out.println("");
		System.out.println("The program ended via System.exit()\nor caught a SIGINT or a SIGTERM");
		if(saveData)
		{
			System.out.println("Data will be written to " + Colorize.GREEN + "\"data.csv\"" + Colorize.RESET + " in " + Colorize.ITALIC + System.getProperty("user.dir") + Colorize.RESET);
			
			// Get the date and time
			String dateAndTime = LocalDate.now() + " " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond();
			
			File file = new File("data.csv");

			FileWriter fWriter;
			try {
				fWriter = new FileWriter(file, true);

				BufferedWriter bWriter = new BufferedWriter(fWriter);

				// Check if the file isnt emtpy to add separation lines
				BufferedReader bReader = new BufferedReader(new FileReader(file));
				if(bReader.readLine() != null)
				{
					bWriter.newLine();
					bWriter.newLine();
				}
				bReader.close();

				bWriter.append(dateAndTime);
				bWriter.newLine();
				bWriter.append("Player Class: " + ", " + Colorize.capitalize(Player.playerClass));
				bWriter.newLine();
				bWriter.append("Coins: " + ", " + Player.coins);
				bWriter.newLine();
				bWriter.append("Kills: " + ", " + Player.enemyKills);
				bWriter.newLine();
				bWriter.append("Level: " + ", " + Player.level);
				bWriter.newLine();
				bWriter.append("XP: " + ", " + Player.xp);
				bWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("");
			System.out.println("No data will be written,\nto save data run with --save-data or -sd flag,\nor set saveData in App.java to true to save always");
		}
	}
}