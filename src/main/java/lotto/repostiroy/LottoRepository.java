package lotto.repostiroy;

import java.util.List;
import lotto.Lotto;
import lotto.domain.LottoManager;

public class LottoRepository {
    private LottoManager lottoManager;

    public LottoManager getLottoManager() {
        return lottoManager;
    }

    public void initLottos(List<Lotto> lottos) {
        lottoManager = new LottoManager(lottos);
    }
}
