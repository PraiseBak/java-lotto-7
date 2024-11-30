package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoFormatter;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.domain.WinningNumbers;
import lotto.dto.CalculateWinningNumberResult;
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

    public void inputBonusNumber(int number) {
        BonusNumber bonusNumber = new BonusNumber(number);
        lottoRepositroy.saveBonusNumber(bonusNumber);
    }

    public void initWinningNumbers() {
        WinningNumber winningNumber = lottoRepositroy.getWinningNumber();
        BonusNumber bonusNumber = lottoRepositroy.getBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber,bonusNumber);
        lottoRepositroy.saveWinningNumbers(winningNumbers);
    }


    public String calculateLottoResult() {
        Lottos lottos = lottoRepositroy.getLottos();
        WinningNumbers winningNumbers = lottoRepositroy.getWinningNumbers();
        List<CalculateWinningNumberResult> calculateWinningNumberResults = lottos.calculateLottosResult(winningNumbers);
        Map<Integer, Integer> winningCountMap = LottoCalculator.calculateWinningNumber(calculateWinningNumberResults);
        double winningRatio = LottoCalculator.calculateWinningRatio(winningCountMap,lottos.getLottoSize());
        return LottoFormatter.formattedLottoResult(winningRatio,winningCountMap);
    }
}
