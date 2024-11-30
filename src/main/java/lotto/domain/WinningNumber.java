package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    public boolean isDuplicateNumber(BonusNumber bonusNumber) {
        Set<Integer> set = new HashSet<>();
        for(Integer number : winningNumbers){
            if(set.contains(number)){
                return true;
            }
            set.add(number);
        }
        return set.contains(bonusNumber.getNumber());
    }

    public boolean isSameNumberExists(Integer number) {
        for(Integer winningNumber : winningNumbers){
            if (number == winningNumber) {
                return true;
            }
        }
        return false;
    }
}
