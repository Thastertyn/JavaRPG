package Main.src;

// Just store the properties of all the classes + enemies
public class Properties {

    // Ids
    final String[] enemyId = {"bear", "centaur", "witch", "ogre", "mage", "goblin", "noone", "duck"};
    final String[] playerId = {"wizard", "dwarf", "elf", "human"};

    // Global variables
    static int playerHP;
    static int enemyHP;
    static int playerStrength;
    static int enemyStrength;
    static boolean hasMana;
    static int playerMana;

//#region HP
    // Player HP
    final int elfHP = 50;
    final int wizardHP = 75;
    final int dwarfHP = 150;
    final int humanHP = 100;

    // Enemy HP
    final int bearHP = 1000;
    final int mageHP = 1250; 
    final int duckHP = 10000;
    final int goblinHP = 150;
    final int ogreHP = 1500;
    final int witchHP = 500;
    final int nooneHP = 1000;
    final int centaurHP = 750;
//#endregion

//#region Strength
    // Player Strength
    final int humanStrength = 60;
    final int wizardStrength = 100;
    final int dwarfStrength = 85;
    final int elfStrength = 40; 
    
    final int wizardMana = 50;

    // Enemy Strength
    final int ogreStrength = 50;
    final int duckStrength = 1;
    final int goblinStrength = 10;
    final int witchStrength = 35;
    final int nooneStrength = 49;
    final int mageStrength = 30;
    final int bearStrength = 15;
    final int centaurStrength = 25;
 
//#endregion
}
