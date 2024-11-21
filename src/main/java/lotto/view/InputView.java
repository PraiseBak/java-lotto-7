package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.exception.LottoException;
import lotto.exception.LottoExceptionMessage;
import lotto.utility.NumberUtility;

public class InputView {

    private final static String INPUT_BUY_MONEY = "구입금액을 입력해 주세요.";

    public static int inputBuyMoney() {
        while (true){
            OutputView.println(INPUT_BUY_MONEY);
            return inputNumber();
        }
    }

    private static int inputNumber() {
        String input = inputLine();
        if(!NumberUtility.isNumber(input)){
            throw new LottoException(LottoExceptionMessage.IS_NOT_NUMBER);
        }
        return Integer.parseInt(input);
    }

    private static String inputLine() {
        return Console.readLine();
    }

    public static int inputBonusNumber() {
        return 0;
    }

    public static List<Integer> inputWinningNumbers() {

    }
}
