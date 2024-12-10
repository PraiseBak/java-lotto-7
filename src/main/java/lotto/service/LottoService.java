package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.LottoNumberGenerater;
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
        for(int i = 0; i<buyMoney % 1000; i++){
            lottos.add(new Lotto(LottoNumberGenerater.generate()));
        }
        lottoRepository.initLottos(lottos);
        LottoManager lottoManager = lottoRepository.getLottoManager();
        return lottoManager.resultBuyLottos();
    }

    public void inputWinNumbers(String s) {
    }
}
