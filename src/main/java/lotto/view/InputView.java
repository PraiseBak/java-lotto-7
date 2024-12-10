package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputBuyNumber() {
        OutputView.inputBuyNumber();
        return input();
    }

    private static String input() {
        return Console.readLine();
    }

    public static String inputWinNumbers() {
        OutputView.printWinNumbers();
        return input();
    }

    public static String inputBonusNumber() {
        OutputView.printBonusNumber();
        return input();
    }
}
