package Managers.Searching;

import java.util.Random;

import Classes.ASCII;
import Classes.Inventory;

public class NoPlace {
    
    static Random rnd = new Random();

    public static void wasFound()
    {
        int message = rnd.nextInt(21);
        
        if(message == 20)
        {
            System.out.println(ASCII.MEAGMIND);
        }else{
            System.out.println("You didn't find any interesting place, but at least found the following items:");
        }

        // Items
        int addedItems = rnd.nextInt(5, 11);
        Inventory.add("wood", (Inventory.get("wood") + addedItems));
        System.out.println(addedItems + " Wood");
    }
}
