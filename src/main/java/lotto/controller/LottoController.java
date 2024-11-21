package lotto.controller;

import java.util.List;
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

    public void inputWinningNumbers(List<Integer> numbers){
        lottoService.inputWinningNumber(numbers);
    }

    public void inputBonusNumber(int bonusNumber){
        lottoService.inputBonusNumber(bonusNumber);
        lottoService.initWinningNumbers();
    }

    public String calculateLottoResult(){
        return lottoService.calculateLottoResult();
    }
}
