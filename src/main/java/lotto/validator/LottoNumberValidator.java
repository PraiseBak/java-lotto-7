package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoException;

public class LottoNumberValidator {

    private static final String DUPLICATE_NUMBER_EXISTS = "중복된 로또 숫자입니다.";
    private static final String INVALID_NUMBER_VALUE = "로또 번호는 1이상 45여야 합니다.";
    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 45;

    public static boolean isLottoNumber(int number){
        if(number < NUMBER_MIN || number > NUMBER_MAX){
            return false;
        }
        return true;
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        for (Integer number : numbers){
            if(!LottoNumberValidator.isLottoNumber(number)){
                throw new LottoException(INVALID_NUMBER_VALUE);
            }
        }
        if(isDuplicateLottoExists(numbers)){
            throw new LottoException(DUPLICATE_NUMBER_EXISTS);
        }
    }

    private static boolean isDuplicateLottoExists(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for(Integer number : numbers){
            if(set.contains(number)){
                return true;
            }
            set.add(number);
        }
        return false;
    }
}
