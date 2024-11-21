package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.LottoException;
import lotto.exception.LottoExceptionMessage;
import lotto.utility.NumberUtility;

public class InputView {

    private final static String INPUT_BUY_MONEY = "구입금액을 입력해 주세요.";
    private static final String SPLITTER = ",";

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
        String input = inputLine();
        String[] split = input.split(SPLITTER);
        for(String string : split){
            if(!NumberUtility.isNumber(string)){
                throw new LottoException(LottoExceptionMessage.IS_NOT_NUMBER);
            }
        }
        return Arrays.stream(input.split(SPLITTER))
                .map((string) -> Integer.parseInt(input))
                .collect(Collectors.toList());
    }
}
