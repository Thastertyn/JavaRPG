package Main.src;

import static Main.src.BattleManager.StartBattle;

import java.io.Console;
import java.util.Random;
import java.util.Scanner;

public class GameManager {

    App mainApp = new App();

    public static void ChooseClass() {
        ClassManager.GetClass();
    }

    public static void GetEnemy() {
        EnemyManager.GetNewEnemy();
    }

    public static void TryAgain() {
        ClassManager.GetClass();
    }
}

class BattleManager {

    public static Properties properties = new Properties();
    public static Random rnd = new Random();
    public static App mainApp = new App();

    public static Scanner sc = new Scanner(System.in);

    public static String userClass;

    static void StartBattle(String enemyType, int enemyID) {
        System.out.print("\033[H\033[2J");
        System.out.println("Let's go for some adventure!");
        String[] messages = { "You wandered around for a bit and stumbled upon ",
                "You peacefully minded your own business and all of the sudden you got attacked by ",
                "While collecting some berries you suddenly were interupted by ",
                "You heard some rustling leaves and what doesnt happen, you get attacked by " };

        int msgId = rnd.nextInt(messages.length - 1);
        System.out.println(messages[msgId] + enemyType);

        if (Properties.hasMana) {
            Properties.playerMana = properties.wizardMana;
        }
        {
            Properties.playerMana = 0;
        }

        System.out.print("\033[H\033[2J");
        GetAction();
    }

    static void GetAction() {
        
        if(Properties.playerHP <= 0)
        {
            Die();
        }
        else
        {     
            System.out.println("<---- Player Stats " + Properties.playerHP + " HP, " + Properties.playerStrength + " Damage ---->" + "\n" + ">---- " + properties.enemyId[EnemyManager.enemyID] + " Stats " + Properties.enemyHP + " HP, " + Properties.enemyStrength + " Damage ----<");
            System.out.println("\nWaiting for your action\n You can \n Attack \n Defend \n Escape");
            String action = sc.nextLine();
            action.toLowerCase();
    
            switch (action) {
                case "attack":
                    Attack();
                    break;
                case "1":
                    Attack();
                    break;
                case "defend":
                    Defend();
                    break;
                case "2":
                    Defend();
                    break;
                case "escape":
                    System.out.println("Not implemented yet");
                    break;
                case "3":
                    System.out.println("Not implemented yet");
                    break;
            }
        }
    }

    //Add hit or miss system
    static void Attack() {
        System.out.println("\nYou attacked and...");

        int hitOrMiss = rnd.nextInt(99);
        if(hitOrMiss >= 9)
        {
            Properties.enemyHP -= Properties.playerStrength;
            System.out.println("You successfully hit the enemy taking away " + Properties.playerStrength + " of their hp");
            if (Properties.enemyHP <= 0) {
                Victory();
            }
            else{
                EnemyAction();
            }
        }
        else{
            System.out.println("You missed the enemy");
            EnemyAction();
        }
    }
    
    static void Defend() {
        int hitOrMiss = rnd.nextInt(99);
        if (hitOrMiss >= 9) {
            System.out.println("You dodged the attack");
            GetAction();
        } else {
            Properties.playerHP -= Properties.enemyStrength;
            System.out.println("You tried dodging, and...");
            EnemyAction();
        }
    }
    
    static void EnemyAction() {
            int hitOrMiss = rnd.nextInt(99);
            if (hitOrMiss >= 9) {
                System.out.println("The enemy missed you.");
                GetAction();
            }
            else {
                Properties.playerHP -= Properties.enemyStrength;
                System.out.println("Enemy hit you taking away " + Properties.enemyStrength + " HP.");
                GetAction();
            }
    }

    static void Die() {
        System.out.print("\033[H\033[2J");
        System.out.println("You died, \ntry again? y/n");
        String tryAgain = sc.nextLine();
        switch (tryAgain) {
            case "y":
                GameManager.TryAgain();
                break;
            case "n":
                break;
            default:
                System.out.println("Incorrect input, exiting");
                break;
        }
    }

    static void Victory()
    {
        System.out.println("You have defeated the enemy. Congratulations!! \nAnother round? y/n");
        String nextRound = sc.nextLine();
        nextRound.toLowerCase();
        switch(nextRound)
        {
            case "y":
                EnemyManager.GetNewEnemy();
                break;
            case "n":
                break;
            default:
                System.out.println("Incorrect input, exiting");
                break;
        }
    }
}

// #region ClassManager
class ClassManager {

    public static Scanner sc = new Scanner(System.in);
    public static Properties properties = new Properties();
    public static String userClass;

    public static void GetClass() {
        System.out.print("\033[H\033[2J");
        System.out.println("Choose your class. \n You can choose from \n 1. Wizard \n 2. Dwarf \n 3. Elf \n 4. Human");
        System.out.println("\n If you are unsure type \"info [classname]\" (eg. info wizard), or \"info\" for specifics about stats");

        String userInput = sc.nextLine();
        userInput.toLowerCase();

        Console c = System.console();

        // A flag wanna-be
        switch (userInput) {
            case "info wizard":
                System.out.print("\033[H\033[2J");
                System.out.println("Wizard is low hp, high damage and medium speed. \n Press enter to continue");
                c.readLine();
                GetClass();
                break;
            case "info dwarf":
                System.out.print("\033[H\033[2J");
                System.out.println("Dwarf is slow, strong and medium on hp. \n Press enter to continue");
                c.readLine();
                GetClass();
                break;
            case "info elf":
                System.out.print("\033[H\033[2J");
                System.out.println("Elf is fast, medium on hp and medium damage, \n but is ranged giving him couple of rounds of headstart before enemy gets close enough to him \n Press enter to continue");
                c.readLine();
                GetClass();
                break;
            case "info human":
                System.out.print("\033[H\033[2J");
                System.out.println("Best of all worlds, he is medium in everything. \n Press enter to continue");
                c.readLine();
                GetClass();
                break;
            case "wizard":
                Properties.playerHP = properties.wizardHP;
                Properties.playerStrength = properties.wizardStrength;
                Properties.hasMana = true;
                ApplyClass(userInput);
                break;
            case "dwarf":
                Properties.playerHP = properties.dwarfHP;
                Properties.playerStrength = properties.dwarfStrength;
                ApplyClass(userInput);
                break;
            case "elf":
                Properties.playerHP = properties.elfHP;
                Properties.playerStrength = properties.elfStrength;
                ApplyClass(userInput);
                break;
            case "human":
                Properties.playerHP = properties.humanHP;
                Properties.playerStrength = properties.humanStrength;
                ApplyClass(userInput);
                break;
            default:
                System.out.println("Incorrect input, try again.");
                GetClass();
                break;
        }
    }

    public static void ApplyClass(String userClass) {
        System.out.println("You chose " + userClass + "\n Is that correct? y/n");
        String isClassCorrect = sc.nextLine();
        isClassCorrect.toLowerCase();
        switch (isClassCorrect) {
            case "y":
                System.out.println(Properties.playerHP);
                GameManager.GetEnemy();
                BattleManager.userClass = userClass;
                break;
            case "n":
                GetClass();
                break;
            default:
                System.out.println("Incorrect answer, taking that as an incorrect choice.");
                GetClass();
                break;
        }

    }
}

// #endregion

// #region EnemyManager
class EnemyManager {

    public static Properties properties = new Properties();
    public static Random rnd = new Random();
    public static int enemyID = rnd.nextInt(7);

    static void GetNewEnemy() {
        
        
        String enemyType;

        switch (enemyID) {
            case 0:
                enemyType = "Bear";
                Properties.enemyHP = properties.bearHP;
                Properties.enemyStrength = properties.bearStrength;
                break;
            case 1:
                enemyType = "Centaur";
                Properties.enemyHP = properties.centaurHP;
                Properties.enemyStrength = properties.centaurStrength;
                break;
            case 2:
                enemyType = "Witch";
                Properties.enemyHP = properties.witchHP;
                Properties.enemyStrength = properties.witchStrength;
                break;
            case 3:
                enemyType = "Ogre";
                Properties.enemyHP = properties.ogreHP;
                Properties.enemyStrength = properties.ogreStrength;
                break;
            case 4:
                enemyType = "Mage";
                Properties.enemyHP = properties.mageHP;
                Properties.enemyStrength = properties.mageStrength;
                break;
            case 5:
                enemyType = "Goblin";
                Properties.enemyHP = properties.goblinHP;
                Properties.enemyStrength = properties.goblinStrength;
                break;
            case 6:
                enemyType = "Noone, you should really take your schizofrenia medication";
                Properties.enemyHP = properties.nooneHP;
                Properties.enemyStrength = properties.nooneStrength;
                break;
            case 7:
                enemyType = "... Duck? Wait what?";
                Properties.enemyHP = properties.duckHP;
                Properties.enemyStrength = properties.duckStrength;
                break;
            default:
                enemyType = null;
        }

        StartBattle(enemyType, enemyID);
    }
}
// #endregion