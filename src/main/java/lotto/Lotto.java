package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoException;
import lotto.validator.LottoNumberValidator;

public class Lotto {


    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoNumberValidator.validateLottoNumbers(numbers);
    }
}
