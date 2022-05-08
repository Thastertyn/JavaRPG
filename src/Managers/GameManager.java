package Managers;

import MenusAndUIs.ActionMenu;

public class GameManager {

	// Make exploration and such stuff available, first will always be just searching around
	// Then some chances to either run into some enemies, or explicitely hunt some down
	
	// Static FTW
	public static void start()
	{
		ActionMenu.mainMenu(false);
	}
}
