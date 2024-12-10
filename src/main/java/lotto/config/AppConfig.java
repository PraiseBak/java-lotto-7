package lotto.config;

import lotto.controller.LottoController;
import lotto.repostiroy.LottoRepository;
import lotto.service.LottoService;

public class AppConfig {
    private static final LottoController lottoController = new LottoController(new LottoService(new LottoRepository()));

    public static  LottoController getLottoController() {
        return lottoController;
    }




}
