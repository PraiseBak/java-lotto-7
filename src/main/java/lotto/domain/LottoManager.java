package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoManager {
    private final List<Lotto> lottos1;
    List<Lotto> lottos  = new ArrayList<>();

    public LottoManager(List<Lotto> lottos){
        this.lottos = lottos;
    }
}
