package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoManager {
    private final List<Lotto> lottos;

    public LottoManager(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public String resultBuyLottos() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Lotto lotto : lottos){
            stringBuilder.append("[")
                    .append(lotto.resultBuyLotto())
                    .append("]")
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
