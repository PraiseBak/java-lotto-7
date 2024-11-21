package lotto.domain;

import java.util.List;
import lotto.validator.LottoNumberValidator;

public class WinningNumber {

    private final List<Integer> winningNumbers;

    public WinningNumber(List<Integer> winningNumbers)
    {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validate(List<Integer> numbers) {
        LottoNumberValidator.validateLottoNumbers(numbers);
    }
}
