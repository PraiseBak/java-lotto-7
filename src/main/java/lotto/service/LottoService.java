package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoManager;
import lotto.domain.LottoNumberGenerater;
import lotto.domain.WinningNumbers;
import lotto.repostiroy.LottoRepository;
import lotto.validator.UserInputValidator;

public class LottoService {

    private final LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;

    }

    public String buyLottos(String s) {
        UserInputValidator.validateBuyLottos(s);
        int buyMoney = Integer.parseInt(s);
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i<buyMoney / 1000; i++){
            lottos.add(new Lotto(LottoNumberGenerater.generate()));
        }
        lottoRepository.initLottos(lottos);
        LottoManager lottoManager = lottoRepository.getLottoManager();
        return lottoManager.resultBuyLottos();
    }

    public void inputWinNumbers(String s) {
        UserInputValidator.validateNumbers(s);
        List<Integer> numberList = new ArrayList<>();
        for(String numberString : s.split(",")){
            numberList.add(Integer.valueOf(numberString));
        }
        UserInputValidator.validateLottoNumbers(numberList);
        lottoRepository.initWinNumbers(numberList);
    }

    public void inputBonusNumber(String s) {
        UserInputValidator.validateNumber(s);
        int bonusNumber = Integer.parseInt(s);
        lottoRepository.initBonusNumber(bonusNumber);
    }

    public String calculateLottoResult() {
        LottoManager lottoManager = lottoRepository.getLottoManager();
        WinningNumbers winningNumbers = lottoRepository.getWinningNumbers();
        return LottoCalculator.calculateLottoResult(lottoManager,winningNumbers);
    }
}
