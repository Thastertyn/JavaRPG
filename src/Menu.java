import Colors.Colorize;

import java.util.Scanner;

import Classes.Player;
import Classes.Properties;

public class Menu extends Player{

    // Each menu will have its own method

    /*
        Main menu
        Class choose
    */

    static Scanner sc = new Scanner(System.in);

    // Boolean for retrying - if the input was invalid, give true, to change the text
    // Sort of like my own try/catch
    public void mainMenu(boolean retry)
    {

        System.out.print(Colorize.RESET + Colorize.CLEAR);

        if(retry)
        {
            System.err.println("Incorrect input, try again");
        }else
        {
            System.out.println("Welcome to the RPG game");
            System.out.println("If you want help, run this program again with a \"--help\" flag (without the quotes)");
        }

        System.out.println(Colorize.GREEN + "> Start" + Colorize.RESET);
        System.out.println(Colorize.RED + "> Quit" + Colorize.RESET);

        String choice = sc.next();

        switch(choice)
        {
            // Start cases
            case "s":
                classChoose(false);
                break;
            case "start":
                classChoose(false);
                break;
            case "1":
                classChoose(false);
                break;

            // Quit cases
            case "q":
                System.out.println("Exiting...");
                System.exit(0);
                break;
            case "quit":
                System.out.println("Exiting...");
                System.exit(0);
                break;
            case "2":
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                mainMenu(true);
                break;
        }
    }

    public void classChoose(boolean retry)
    {
        System.out.print(Colorize.CLEAR + Colorize.RESET);

        if(retry)
        {
            System.err.println("Incorrect input, try again.");
        }

        System.out.println("Choose your class. \nYou can choose from " + 
        "\n1.> " + Colorize.MAGENTA + "Wizard" + Colorize.RESET + 
        "\n2.> " + Colorize.CYAN + "Dwarf" + Colorize.RESET +
        "\n3.> " + Colorize.WHITE + "Elf " + Colorize.RESET +
        "\n4.> " + Colorize.YELLOW + "Human" + Colorize.RESET
        );
        System.out.println("\n If you are unsure type \"info [classname]\" (eg. info wizard), or \"info\" for specifics about stats");

        // https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
        sc.nextLine(); // WTF
        /*
        int option = input.nextInt();
        input.nextLine();  // Consume newline left-over
        String str1 = input.nextLine();
        */

        String classInput = sc.nextLine();
        classInput.toLowerCase();

        // A flag wanna-be
        switch(classInput)
        {
            case "wizard":
                Player.hp = Properties.wizardHP;
                Player.strength = Properties.wizardStrength;
                Player.hasMana = true;
                Player.playerClass = "wizard";
                System.out.println(Player.infoAboutPlayer());
                break;
            case "dwarf":
                Player.hp = Properties.dwarfHP;
                Player.strength = Properties.dwarfStrength;
                Player.hasMana = false;
                Player.playerClass = "dwarf";
                System.out.println(Player.infoAboutPlayer());
                break;
            case "elf":
                Player.hp = Properties.elfHP;
                Player.strength = Properties.elfStrength;
                Player.hasMana = false;
                Player.playerClass = "elf";
                System.out.println(Player.infoAboutPlayer());
                break;
            case "human":
                Player.hp = Properties.humanHP;
                Player.strength = Properties.humanStrength;
                Player.hasMana = false;
                Player.playerClass = "human";
                System.out.println(Player.infoAboutPlayer());
                break;
            default:

                String trimmedOfSpaces = classInput.replaceAll("\s", "");

                System.out.println(trimmedOfSpaces);

                // https://howtodoinjava.com/java/string/get-first-4-characters/
                if(trimmedOfSpaces.substring(0, 4).equals("info"))
                {
                    Help.getHelp(trimmedOfSpaces.substring(4, trimmedOfSpaces.length()));
                }else{
                    classChoose(true);
                }


                /*
                !I like this stuff so it's staying, it's just comments, so nothing much, not much of a space hurry atm (there kinda is, but not rn)

                String[] split = classInput.split("\\s+");

                String trimmedOfSpacesInput = classInput.replaceAll("\\s", "");
                char[] trimmedOfSpacesInputCharArray = trimmedOfSpacesInput.toCharArray();

                System.out.println(trimmedOfSpacesInput);

                if(trimmedOfSpacesInputCharArray[0] == 'i' && trimmedOfSpacesInputCharArray[1] == 'n' && trimmedOfSpacesInputCharArray[2] == 'f' && trimmedOfSpacesInputCharArray[3] == 'o')
                {
                    Help.getHelp(trimmedOfSpacesInput);
                }

                if(split[0].equals("info"))
                {
                }else{
                    //classChoose(true);
                }*/
                break;
        }
    }
}
