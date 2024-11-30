package lotto;

import java.util.List;
import lotto.domain.LottoFormatter;
import lotto.domain.WinningNumbers;
import lotto.dto.CalculateWinningNumberResult;
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

    public String getLottoSummery() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LottoFormatter.getLottoSummery(numbers))
                .append("\n");
        return stringBuilder.toString();
    }

    public CalculateWinningNumberResult calculte(WinningNumbers winningNumbers) {
        CalculateWinningNumberResult calWinningNumberResult = winningNumbers.calSameNumber(numbers);
        return calWinningNumberResult;
    }
}
