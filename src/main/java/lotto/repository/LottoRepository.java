package lotto.repository;

import lotto.domain.BonusNumber;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.domain.WinningNumbers;
import lotto.exception.LottoException;
import lotto.exception.LottoStateException;

public class LottoRepository {
    private final static String ALREADY_INIT_LOTTOS = "로또 번호는 최초 한번만 초기화 가능합니다.";
    private final static String ALREADY_INIT_BONUS_NUMBER = "보너스 숫자는 최초 한번만 초기화 가능합니다.";
    private final static String ALREADY_INIT_WINNING_NUMBER = "우승 숫자는 최초 한번만 초기화 가능합니다.";
    private final static String ALREADY_INIT_WINNING_NUMBERS = "로또 숫자는 최초 한번만 초기화 가능합니다.";

    private Lottos lottos;
    private WinningNumbers winningNumbers;
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;

    public void saveLottos(Lottos lottos) {
        if(lottos == null){
            throw new LottoStateException(ALREADY_INIT_LOTTOS);
        }
        this.lottos = lottos;
    }

    public void saveWinningNumbers(WinningNumbers winningNumbers) {
        if(lottos == null){
            throw new LottoStateException(ALREADY_INIT_WINNING_NUMBERS);
        }
        this.winningNumbers = winningNumbers;
    }

    public void saveWinningNumber(WinningNumber winningNumber) {
        if(winningNumber == null){
            throw new LottoStateException(ALREADY_INIT_WINNING_NUMBER);
        }
        this.winningNumber = winningNumber;
    }

    public void saveBonusNumber(BonusNumber bonusNumber) {
        if(bonusNumber == null){
            throw new LottoStateException(ALREADY_INIT_BONUS_NUMBER);
        }
        this.bonusNumber = bonusNumber;
    }
}
