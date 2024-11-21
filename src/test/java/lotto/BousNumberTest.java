package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

class BousNumberTest {
    @Test
    void 보너스_숫자_범위안이아니면_예외() {
        assertThatThrownBy(() -> new BonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
