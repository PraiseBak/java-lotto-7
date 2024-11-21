package lotto.utility;

public class NumberUtility {

    private final static String IS_NUMBER_REGEX = "^[0-9]+$";

    public static boolean isNumber(String input) {
        return input.matches(IS_NUMBER_REGEX);
    }
}
