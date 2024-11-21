package lotto.controller;

import lotto.repository.LottoRepository;
import lotto.service.LottoMachineService;
import lotto.service.LottoService;

public class LottoController {

    private final LottoRepository lottoRepository = new LottoRepository();
    private final LottoMachineService lottoMachineService = new LottoMachineService(lottoRepository);
    private final LottoService lottoService = new LottoService(lottoRepository);


    public String buyLotto(int money) {
        return lottoMachineService.buyLotto(money);
    }

    public void inputWinningNumbers(){

    }

    public void inputBonusNumber(){
    }

    public String calculateLottoResult(){
        return "로또결과랑 수익류 ";
    }
}
