package lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.utility.NumberUtility;
import lotto.validator.UserInputValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        UserInputValidator.validateLottoNumbers(numbers);
    }

    public String resultBuyLotto() {
        return numbers.stream()
                .map((num) -> num + "")
                .collect(Collectors.joining(", "));
    }

    public int countSameExists(List<Integer> numberList) {
        return NumberUtility.countDuplicateNumbers(numberList,numbers);
    }
}
