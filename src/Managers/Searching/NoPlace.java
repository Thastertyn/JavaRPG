package Managers.Searching;

import java.util.Random;

import Classes.Inventory;

public class NoPlace {
    
    static Random rnd = new Random();

    public static void wasFound()
    {
        System.out.println("You didn't find any interesting place, but at least found the following items:");

        // Items
        int addedItems = rnd.nextInt(5, 11);
        Inventory.add("wood", (Inventory.get("wood") + addedItems));
        System.out.println(addedItems + " Wood");
    }
}
