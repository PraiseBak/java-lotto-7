package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
    @Test
    void 우승_번호는_6자리여야_합니다() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 우승_번호는_6자리여야_합니다_미만() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 우승_번호는_중복될_수_없습니다() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1,1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 우승_번호_범위_체크() {
        assertThatThrownBy(() -> new WinningNumber(List.of(0,1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
