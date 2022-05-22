package Classes;

// Just store the properties of all the classes + enemies
public class DataAndOtherStuff {

    // Exploration POIs
    public static final String[] POIS = {"campsite", "cottage", "cave", "ruin", "castle", "lair"};
    public static final String[] POI_MESSAGES = {"You stumbled upon a ", "You found a ", "You find yourself in a ", "Your senses lead you to a ", "After countles hours, you saw it, a "};
    
    // Ids
    public final String[] playerId = {"wizard", "dwarf", "elf", "human"};
    
    public static final String[] ENEMY_IDS = {"slime", "hog", "bear", "goblin", "zombie", "skeleton", "ogre", "witch", "mage", "centaur", "noone", "duck"};
    public static final String[] TIER1IDS = {"slime", "hog"};
    public static final String[] TIER1SHORT_IDS = {"sl", "h"};
    public static final String[] TIER2IDS = {"bear", "goblin", "zombie"};
    public static final String[] TIER2SHORT_IDS = {"b", "g", "z"};
    public static final String[] TIER3IDS = {"skeleton", "ogre"};
    public static final String[] TIER3SHORT_IDS = {"sk", "o"};
    public static final String[] TIER4IDS = {"witch", "mage"};
    public static final String[] TIER4SHORT_IDS = {"w", "m"};
    public static final String[] TIER5IDS = {"centaur", "noone"};
    public static final String[] TIER5SHORT_IDS = {"c", "n"};
    public static final String[] TIER6ID = {"noone"};

//#region HP
    // Player HP
    public static final int ELF_HP = 75;
    public static final int WIZARD_HP = 50;
    public static final int DWARF_HP = 150;
    public static final int HUMAN_HP = 100;

    // Enemy HP
    public static final int SLIME_HP = 20;
    public static final int HOG_HP = 50;
    public static final int[] TIER1_HP = {SLIME_HP, HOG_HP};
    public static final int BEAR_HP = 100;
    public static final int GOLBLIN_HP = 150;
    public static final int ZOMIE_HP = 200;
    public static final int[] TIER2_HP = {BEAR_HP, GOLBLIN_HP, ZOMIE_HP};
    public static final int SKELETON_HP = 75;
    public static final int OGRE_HP = 350;
    public static final int[] TIER3_HP = {SKELETON_HP, OGRE_HP};
    public static final int WITCH_HP = 250;
    public static final int MAGE_HP = 500; 
    public static final int[] TIER4_HP = {WITCH_HP, MAGE_HP};
    public static final int CENTAUR_HP = 750;
    public static final int NOONE_HP = 1000;
    public static final int[] TIER5_HP = {CENTAUR_HP, NOONE_HP};
    public static final int DUCK_HP = 10000;
//#endregion

//#region Strength
    // Player Strength
    public static final int HUMAN_STRENGTH = 20;
    public static final int WIZARD_STRENGTH = 50;
    public static final int DWARF_STRENGTH = 35;
    public static final int ELF_STRENGTH = 25; 

    // Enemy Strength
    public static final int slimeStrength = 5;
    public static final int hogStrength = 15;
    public static final int[] tier1Strength = {slimeStrength, hogStrength};
    public static final int bearStrength = 35;
    public static final int goblinStrength = 50;
    public static final int zombieStrength = 75;
    public static final int[] tier2Strength = {bearStrength, goblinStrength, zombieStrength};
    public static final int skeletonStrength = 100;
    public static final int ogreStrength = 100;
    public static final int[] tier3Strength = {skeletonStrength, ogreStrength};
    public static final int witchStrength = 35;
    public static final int mageStrength = 30;
    public static final int[] tier4Strength = {witchStrength, mageStrength};
    public static final int centaurStrength = 25;
    public static final int nooneStrength = Player.strength; // Take your meds son
    public static final int[] tier5Strength = {centaurStrength, nooneStrength};
    public static final int duckStrength = 200;
 
//#endregion

    public static final int STUPID_LARGE_STRENGTH = 1147483647;
    public static final int STUPID_LARGE_HP = 1147483647;
}
