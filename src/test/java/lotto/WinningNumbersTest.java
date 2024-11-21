package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @Test
    void 우승_번호와_보너스_번호_겹칠시_예외() {
        WinningNumber winningNumber = new WinningNumber(List.of(1,6,2,3,4,5));
        BonusNumber bonusNumber = new BonusNumber(1);
        assertThatThrownBy(() -> new WinningNumbers(winningNumber,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
