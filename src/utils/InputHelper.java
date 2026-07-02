package utils;

public class InputHelper {
    public static boolean isAlpha(String text) {
        return text.matches("[a-zA-Z\\s]+");
    }
    
    public static boolean isNumeric(String text) {
        return text.matches("[0-9]+");
    }
}