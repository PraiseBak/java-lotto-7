package lotto.domain;

import lotto.exception.LottoException;
import lotto.exception.LottoExceptionMessage;

public class WinningNumbers {
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningNumbers(WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        validateWinningNumbers();
    }

    private void validateWinningNumbers() {
        if(winningNumber.isDuplicateNumber(bonusNumber)){
            throw new LottoException(LottoExceptionMessage.BONUS_NUMBER_CANNOT_BE_DUPLICATE);
        }
    }

    public String calculateResult() {
        return "";
    }
}
