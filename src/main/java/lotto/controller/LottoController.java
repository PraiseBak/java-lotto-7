package lotto.controller;

import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public String inputBuyNumber(String s) {
        return lottoService.buyLottos(s);
    }

    public void inputWinNumbers(String s) {
        lottoService.inputWinNumbers(s);
    }

    public void inputBonusNumber(String s) {
        return;
    }

    public String lottoResult() {
        return "";
    }
}
