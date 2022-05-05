package Classes;

import java.util.ArrayList;

public class Player {
    
    public static int hp;
    public static int strength;

    public static String playerClass;

    public static boolean hasMana;

    // Item Positions
    // 0. Weapon
    // 1. Armor
    // 2. Wood
    // 3. Stone
    // 4. Potions
    // 5. Gems
    // There won't be any size limit, at least for now
    public static ArrayList<Integer> inventory = new ArrayList<>();

    public static void init(String classString)
    {
        // Set the weapon and armor to nothing
        inventory.add(0, 0);
        inventory.add(1, 0);
    }

    public static void attack()
    {
        
    }

    // toString can't be static, which it has to be if there is only one player, therefore everything else being static
    public static String playerInfoString()
    {
        return "Player has class:" + playerClass + "\nHP:" + hp + "\nStrength:" + strength;
    }
}
