package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.domain.LottoFormatter;
import lotto.domain.Lottos;
import lotto.exception.LottoException;
import lotto.exception.LottoExceptionMessage;
import lotto.repository.LottoRepository;

public class LottoMachineService {
    private final int LOTTO_BUY_UNIT = 1000;
    private final LottoRepository lottoRepository;

    public LottoMachineService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public String buyLotto(int money) {
        validateBuyLotto(money);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_BUY_UNIT; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange (1, 45, 6));
            lottoList.add(lotto);
        }
        Lottos lottos = new Lottos(lottoList);
        return LottoFormatter.getFormattedBuyLotto(lottos);
    }

    private void validateBuyLotto(int money) {
        if(money == 0){
            throw new LottoException(LottoExceptionMessage.INPUT_INVALID_ERROR);
        }
        if(money % LOTTO_BUY_UNIT != 0){
            throw new LottoException(LottoExceptionMessage.INPUT_INVALID_ERROR);
        }
    }
}
