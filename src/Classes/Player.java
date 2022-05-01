package Classes;

public class Player implements IClass{
    
    public static int hp;
    public static int strength;

    public static String playerClass;

    public static boolean hasMana;

    public void attack()
    {
        
    }

    public static String infoAboutPlayer()
    {
        return "Player has class:" + playerClass + "\nHP:" + hp + "\nStrength:" + strength;
    }
}
