package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.Lotto;

public class LottoManager {
    private final List<Lotto> lottos;

    public LottoManager(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public String resultBuyLottos() {
        StringBuilder stringBuilder = new StringBuilder(LottoFormatter.getResultBuyLottosPrefix(lottos.size()));
        for(Lotto lotto : lottos){
            stringBuilder.append("[")
                    .append(lotto.resultBuyLotto())
                    .append("]")
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    public int getLottoBuyMoney(){
        return lottos.size() * 1000;
    }

    public Map<Integer,Integer> getCalculateCountWinningNumberMap(WinningNumbers winningNumbers) {
        return winningNumbers.calculateCountWinningNumberMap(lottos);
    }
}
