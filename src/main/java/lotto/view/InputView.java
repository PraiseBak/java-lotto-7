package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.LottoException;
import lotto.exception.LottoExceptionMessage;
import lotto.utility.NumberUtility;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;

public class InputView {

    private final static String INPUT_BUY_MONEY = "구입금액을 입력해 주세요.";
    private final static String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
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
        OutputView.println(INPUT_BONUS_NUMBER);
        return inputNumber();
    }

    public static List<Integer> inputWinningNumbers() {
        OutputView.println(INPUT_WINNING_NUMBER);
        String input = inputLine();
        String[] split = input.split(SPLITTER);
        for(String string : split){
            if(!NumberUtility.isNumber(string)){
                throw new LottoException(LottoExceptionMessage.IS_NOT_NUMBER);
            }
        }
        List<Integer> numberList = new ArrayList<>();
        for(String string : split){
            numberList.add(Integer.parseInt(string));
        }
        return numberList;
    }
}
