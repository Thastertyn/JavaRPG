package Colors;

import java.util.Scanner;

public class Colorize {

    static Scanner sc = new Scanner(System.in);

    public static final String PROMPT = "$~> ";
    public static final String PROMPT_ENTER = "ENTER $~> ";

    public static final String SEPARATOR_SMALL = "----";
    public static final String SEPARATOR_MEDIUM = "-----------------";
    public static final String SEPARATOR_LARGE = "----------------------------------";

    ///*
    // Should be printed with System.out.print(), not with println()
    public static final String CLEAR              = "\033[H\033[2J";

    public static final String RESET              = "\u001B[0m";

    public static final String HIGH_INTENSITY     = "\u001B[1m";
    public static final String LOW_INTENSITY      = "\u001B[2m";
    public static final String ITALIC             = "\u001B[3m";
    public static final String UNDERLINE          = "\u001B[4m";
    public static final String BLINK              = "\u001B[5m";
    public static final String RAPID_BLINK        = "\u001B[6m";
    public static final String REVERSE_VIDEO      = "\u001B[7m";
    public static final String INVISIBLE_TEXT     = "\u001B[8m";

    public static final String BLACK              = "\u001B[30m";
    public static final String RED                = "\u001B[31m";
    public static final String GREEN              = "\u001B[32m";
    public static final String YELLOW             = "\u001B[33m";
    public static final String BLUE               = "\u001B[34m";
    public static final String MAGENTA            = "\u001B[35m";
    public static final String CYAN               = "\u001B[36m";
    public static final String WHITE              = "\u001B[37m";

    public static final String BACKGROUND_BLACK   = "\u001B[40m";
    public static final String BACKGROUND_RED     = "\u001B[41m";
    public static final String BACKGROUND_GREEN   = "\u001B[42m";
    public static final String BACKGROUND_YELLOW  = "\u001B[43m";
    public static final String BACKGROUND_BLUE    = "\u001B[44m";
    public static final String BACKGROUND_MAGENTA = "\u001B[45m";
    public static final String BACKGROUND_CYAN    = "\u001B[46m";
    public static final String BACKGROUND_WHITE   = "\u001B[47m";

    //*/

    /**
     * Capitalize some text {@code hello => Hello}
     * @param text text to be Capitalized
     * @return Capitalized text 
     */
    public static String capitalize(String text)
    {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    /**
     * Remove spaces and set the entire string to lower case
     * @param text Input from user
     * @return text with no spaces and upper case characters
     */
    public static String scannerize(String text)
    {
        return text.toLowerCase().replaceAll("\\s", "");
    }

    // Uncomment this if colors dont work (aka on windows)
    // and comment the whole thing above from BACKGROUND_WHITE to CLEAR
    /*
    public static final String CLEAR              = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
    public static final String RESET              = "";
    public static final String HIGH_INTENSITY     = "";
    public static final String LOW_INTENSITY      = "";
    public static final String ITALIC             = "";
    public static final String UNDERLINE          = "";
    public static final String BLINK              = "";
    public static final String RAPID_BLINK        = "";
    public static final String REVERSE_VIDEO      = "";
    public static final String INVISIBLE_TEXT     = "";
    public static final String BLACK              = "";
    public static final String RED                = "";
    public static final String GREEN              = "";
    public static final String YELLOW             = "";
    public static final String BLUE               = "";
    public static final String MAGENTA            = "";
    public static final String CYAN               = "";
    public static final String WHITE              = "";
    public static final String BACKGROUND_BLACK   = "";
    public static final String BACKGROUND_RED     = "";
    public static final String BACKGROUND_GREEN   = "";
    public static final String BACKGROUND_YELLOW  = "";
    public static final String BACKGROUND_BLUE    = "";
    public static final String BACKGROUND_MAGENTA = "";
    public static final String BACKGROUND_CYAN    = "";
    public static final String BACKGROUND_WHITE   = "";
    */
}