package lotto.validator;

import lotto.exception.LottoExceptionHelper;
import lotto.exception.LottoException;
import lotto.utility.NumberUtility;
import lotto.view.OutputView;

public class UserInputValidator {
    private static final int MAX = 31;
    private static final int MIN = 1;

    public static void validateMenus(String menu) {
        String[] split = menu.split(",");
        if(split.length == 0){
            try {
                throw new LottoException(LottoExceptionHelper.INVALID_LOTTO);
            } catch (LottoException e) {
                OutputView.printError(e.getMessage());
            }
        }
        for(String menuInput : split){
            String[] menuInfo = menuInput.split("-");
        }
    }

    public static void validateBuyLottos(String s) {
        validateNumber(s);
        int buyMoney = Integer.parseInt(s);
        validatePositive(buyMoney);
        if(buyMoney % 1000 != 0){
            throw new LottoException(LottoExceptionHelper.INVALID_LOTTO_BUY_MONEY)
        }
    }

    private static void validatePositive(int buyMoney) {
        if(!NumberUtility.isPositive(buyMoney)){
            throw new LottoException(LottoExceptionHelper.INVALID_NUMBER);
        }
    }

    private static void validateNumber(String s) {
        if(!NumberUtility.isNumber(s)){
            throw new LottoException(LottoExceptionHelper.INVALID_NUMBER);
        }

    }

}
