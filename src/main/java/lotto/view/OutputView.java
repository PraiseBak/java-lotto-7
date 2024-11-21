package lotto.view;

public class OutputView {
    private final static String ERROR_PREFIX = "[ERROR] ";
    public static void println(String string) {
        System.out.println(string);
    }

    public static void printError(String message) {
        println(ERROR_PREFIX + message);
    }
}
