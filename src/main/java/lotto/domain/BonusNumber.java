package lotto.domain;

import java.util.List;
import lotto.exception.LottoException;
import lotto.exception.LottoExceptionMessage;
import lotto.validator.LottoNumberValidator;

public class BonusNumber {

    private final static String BONUS_NUMBER_INPUT_INVALID = "보너스 숫자는 1이상 45이하입니다.";
    private final Integer bonusNumber;


    public BonusNumber(Integer bonusNumber)
    {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if(!LottoNumberValidator.isLottoNumber(bonusNumber)){
            throw new LottoException(BONUS_NUMBER_INPUT_INVALID);
        }
    }
}
