package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.domain.LottoFormatter;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.exception.LottoException;
import lotto.exception.LottoExceptionMessage;
import lotto.repository.LottoRepository;
import lotto.validator.LottoNumberValidator;

public class LottoService {
    private final LottoRepository lottoRepositroy;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepositroy = lottoRepository;

    }


    public void inputWinningNumber(List<Integer> numbers) {
        LottoNumberValidator.validateLottoNumbers(numbers);
        WinningNumber winningNumber = new WinningNumber(numbers);
        lottoRepositroy.saveWinningNumber(winningNumber);
    }

}
