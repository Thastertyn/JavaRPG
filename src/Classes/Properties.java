package Classes;

// Just store the properties of all the classes + enemies
public class Properties {

    // Ids
    public final String[] enemyId = {"bear", "centaur", "witch", "ogre", "mage", "goblin", "noone", "duck"};
    public final String[] playerId = {"wizard", "dwarf", "elf", "human"};

//#region HP
    // Player HP
    public static final int elfHP = 50;
    public static final int wizardHP = 75;
    public static final int dwarfHP = 150;
    public static final int humanHP = 100;

    // Enemy HP
    public static final int bearHP = 1000;
    public static final int mageHP = 1250; 
    public static final int duckHP = 10000;
    public static final int goblinHP = 150;
    public static final int ogreHP = 1500;
    public static final int witchHP = 500;
    public static final int nooneHP = 1000;
    public static final int centaurHP = 750;
//#endregion

//#region Strength
    // Player Strength
    public static final int humanStrength = 60;
    public static final int wizardStrength = 100;
    public static final int dwarfStrength = 85;
    public static final int elfStrength = 40; 
    public static final int wizardMana = 50;

    // Enemy Strength
    public static final int ogreStrength = 50;
    public static final int duckStrength = 1;
    public static final int goblinStrength = 10;
    public static final int witchStrength = 35;
    public static final int nooneStrength = 49;
    public static final int mageStrength = 30;
    public static final int bearStrength = 15;
    public static final int centaurStrength = 25;
 
//#endregion
}
