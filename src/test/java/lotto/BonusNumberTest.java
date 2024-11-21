package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.BonusNumber;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @Test
    void 보너스_숫자_범위안이아니면_예외() {
        assertThatThrownBy(() -> new BonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
