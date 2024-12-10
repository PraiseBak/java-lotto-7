package lotto.service;

import lotto.Lotto;
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
        for(int i=0;i<buyMoney % 1000;i++){
            lottoRepository.getLottoManager();

        }
        return "%d개를 구매하였습니다.";
    }

    public void inputWinNumbers(String s) {
    }
}
