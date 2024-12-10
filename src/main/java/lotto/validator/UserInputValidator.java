package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoExceptionHelper;
import lotto.exception.LottoException;
import lotto.utility.NumberUtility;
import lotto.view.OutputView;

public class UserInputValidator {
    public static final int MAX = 31;
    public static final int MIN = 1;
    public static final String INVALID_LOTTO_NUMBER = "[ERROR] 로또번호는1부터45 사이의숫자여야합니다.";
    public static final int MIN_LOTTO_NUMBER = 0;
    public static final Integer MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final String DUPLICATE_LOTTO_NUMBERS = "중복된 로또 숫자입니다.";

    public static void validateBuyLottos(String s) {
        validateNumber(s);
        int buyMoney = Integer.parseInt(s);
        validatePositive(buyMoney);
        if(buyMoney % 1000 != 0){
            throw new LottoException(LottoExceptionHelper.INVALID_LOTTO_BUY_MONEY);
        }
    }

    public static void validatePositive(int buyMoney) {
        if(!NumberUtility.isPositive(buyMoney)){
            throw new LottoException(LottoExceptionHelper.INVALID_NUMBER);
        }
    }

    public static void validateNumber(String s) {
        if(!NumberUtility.isNumber(s)){
            throw new LottoException(LottoExceptionHelper.INVALID_NUMBER);
        }

    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        validateDuplicateNumbers(numbers);
        for(Integer number : numbers){
            validateLottoNumber(number);
        }
    }

    public static void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for(Integer num : numbers){
            if(set.contains(num)){
                throw new LottoException(DUPLICATE_LOTTO_NUMBERS);
            }
            set.add(num);
        }
    }

    public static void validateLottoNumber(Integer number) {
        if(number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER){
            throw new LottoException(INVALID_LOTTO_NUMBER);
        }
    }

    public static void validateNumbers(String input) {
        String[] split = input.split(",");
        for(String s : split ){
            validateNumber(s);
        }
    }
}
