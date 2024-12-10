package lotto.repostiroy;

import java.util.List;
import lotto.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.WinningNumbers;

public class LottoRepository {
    private LottoManager lottoManager;

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    private WinningNumbers winningNumbers;

    public LottoManager getLottoManager() {
        return lottoManager;
    }

    public void initLottos(List<Lotto> lottos) {
        lottoManager = new LottoManager(lottos);
    }

    public void initWinNumbers(List<Integer> numberList) {
        winningNumbers = new WinningNumbers(numberList);
    }

    public void initBonusNumber(int bonusNumber) {
        winningNumbers.initBonusNumber(bonusNumber);
    }
}
