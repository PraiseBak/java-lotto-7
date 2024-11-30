package lotto.domain;

import java.util.List;
import lotto.dto.CalculateWinningNumberResult;
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

    public CalculateWinningNumberResult calSameNumber(List<Integer> numbers) {
        int winningNumberCount = 0;
        int winningBonusCount = 0;
        for(Integer number : numbers){
            if(winningNumber.isSameNumberExists(number)){
                winningNumberCount++;
            }
            if(bonusNumber.isSameNumberExists(number)){
                winningNumberCount++;
            }
        }
        return new CalculateWinningNumberResult(winningNumberCount,winningBonusCount);
    }
}
