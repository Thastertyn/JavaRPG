package Classes;

import Colors.Colorize;

// Just store the properties of all the classes + enemies
public class DataAndOtherStuff {

	// Exploration POIs
	public static final String[] POIS = {"campsite", "cottage", "cave", "ruin", "castle", "lair"};
	public static final String[] POI_MESSAGES = {"You stumbled upon a ", "You found a ", "You find yourself in a ", "Your senses lead you to a ", "After countles hours, you saw it, a "};
	
//#region Enemies

	// Full ids
	public static final String[] ENEMY_IDS = {
		"slime", 
		"hog", 
		"bear", 
		"goblin", 
		"zombie", 
		"skeleton", 
		"ogre", 
		"witch", 
		"mage", 
		"centaur", 
		"noone", 
		"duck"
	};

	public static final String[] TIER1IDS = {ENEMY_IDS[0], ENEMY_IDS[1]};
	public static final String[] TIER2IDS = {ENEMY_IDS[2], ENEMY_IDS[3]};
	public static final String[] TIER3IDS = {ENEMY_IDS[4], ENEMY_IDS[5]};
	public static final String[] TIER4IDS = {ENEMY_IDS[6], ENEMY_IDS[7]};
	public static final String[] TIER5IDS = {ENEMY_IDS[8], ENEMY_IDS[9]};
	public static final String TIER6ID = ENEMY_IDS[10];
	public static final String TIER7ID = ENEMY_IDS[11];

	// Short ids
	public static final String[] ENEMY_SHORT_IDS = {
		"sl",
		"h",
		"b",
		"g",
		"z",
		"sk",
		"o",
		"w",
		"m",
		"c",
		"n",
		"d"
	};

	public static final String[] ENEMY_COLORS = {
		/* Slime */ Colorize.GREEN,
		/* Hog */ Colorize.YELLOW,
		/* Bear */ Colorize.WHITE,
		/* Goblin */ Colorize.GREEN,
		/* Zombie */ Colorize.MAGENTA,
		/* Skeleton */ Colorize.WHITE,
		/* Ogre */ Colorize.GREEN,
		/* Witch */ Colorize.MAGENTA,
		/* Mage */ Colorize.RED,
		/* Centaur */ Colorize.YELLOW,
		/* Noone */ Colorize.BACKGROUND_WHITE + Colorize.BLACK,
		/* Duck */ Colorize.YELLOW
	};

	// Enemy HP
	public static final int[] ENEMY_HEALTH = {
		/* Slime */ 20, 
		/* Hog */ 50, 
		/* Bear */ 75, 
		/* Goblin */ 65, 
		/* Zombie*/ 100, 
		/* Skeleton */ 50, 
		/* Ogre */ 175, 
		/* Witch */ 125, 
		/* Mage */ 250, 
		/* Centaur */ 375, 
		/* Noone */ 500, 
		/* Duck */ 10000
	};

	// Enemy Strength
	public static final int[] ENEMY_STRENGTH = {
		/* Slime */ 5, 
		/* Hog */ 15, 
		/* Bear */ 25, 
		/* Goblin */ 20, 
		/* Zombie*/ 35, 
		/* Skeleton */ 50, 
		/* Ogre */ 60, 
		/* Witch */ 45, 
		/* Mage */ 35, 
		/* Centaur */ 60, 
		/* Noone */ //Same as player, set in Enemy on line 69, 
		/* Duck */ 200
	};

//#endregion

//#region Player

	public final String[] PLAYER_IDS = {"wizard", "dwarf", "elf", "human"};

	// Player HP
	public static final int ELF_HP = 100;
	public static final int WIZARD_HP = 75;
	public static final int DWARF_HP = 150;
	public static final int HUMAN_HP = 125;

	// Player Strength
	public static final int HUMAN_STRENGTH = 20;
	public static final int WIZARD_STRENGTH = 50;
	public static final int DWARF_STRENGTH = 35;
	public static final int ELF_STRENGTH = 25; 

	public static final int WIZARD_MAX_ARMOR = 12;
	public static final int DWARF_MAX_ARMOR = 20;
	public static final int ELF_MAX_ARMOR = 15;
	public static final int HUMAN_MAX_ARMOR = 15;

	public static final int WIZARD_MAX_WEAPON = 12;
	public static final int DWARF_MAX_WEAPON = 15;
	public static final int ELF_MAX_WEAPON = 20;
	public static final int HUMAN_MAX_WEAPON = 15;
//#endregion

//#region Cheats
	public static final int STUPID_LARGE_STRENGTH = 1147483647;
	public static final int STUPID_LARGE_HP = 1147483647;
//#endregion
}
