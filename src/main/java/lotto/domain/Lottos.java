package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.dto.CalculateWinningNumberResult;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public String createLottoHistory(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LottoFormatter.getFormattedLottoSize(lottos.size()))
                .append("\n");
        for(Lotto lotto : lottos){
            stringBuilder.append(lotto.getLottoSummery());
        }
        return stringBuilder.toString();
    }

    public List<CalculateWinningNumberResult> calculateLottosResult(WinningNumbers winningNumbers) {
        List<CalculateWinningNumberResult> calculateWinningNumberResults = new ArrayList<>();
        for(Lotto lotto : lottos){
            calculateWinningNumberResults.add(lotto.calculte(winningNumbers));
        }
        return calculateWinningNumberResults;
    }

    public int getLottoSize() {
        return lottos.size();
    }
}
