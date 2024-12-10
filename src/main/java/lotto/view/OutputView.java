package lotto.view;

public class OutputView {

    private static final String INPUT_BUY_NUMBER = "구매금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void printError(String message) {
        println(message);
    }

    private static void println(String message) {
        System.out.println(message);
    }

    public static void inputBuyNumber() {
        println(INPUT_BUY_NUMBER);
    }

    public static void printLottoBuyNumber(String buyResult) {
        println(buyResult);
    }

    public static void printWinNumbers() {
        println(INPUT_WIN_NUMBERS);

    }

    public static void printBonusNumber() {
        println(INPUT_BONUS_NUMBER);
    }

    public static void printLottoResult(String lottoResult) {
        println(lottoResult);
    }
}
