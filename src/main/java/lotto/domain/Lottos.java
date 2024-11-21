package lotto.domain;

import java.util.List;
import lotto.Lotto;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public String createLottoHistory(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Lotto lotto : lottos){
            stringBuilder.append(lotto.getLottoSummery()).append("\n");
        }
        return stringBuilder.toString();
    }
}
