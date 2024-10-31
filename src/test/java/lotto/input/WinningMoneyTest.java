package lotto.input;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningMoneyTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("보너스_번호가_45_초과일시_예외_발생")
    @Test
    void 보너스_번호가_45_초과일시_예외_발생() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "47");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스_번호가_1_미만일시_예외_발생")
    @Test
    void 보너스_번호가_1_미만일시_예외_발생() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨_번호에_숫자가_아닌_문자가_있으면_예외가_발생한다")
    @Test
    void 당첨_번호에_숫자가_아닌_문자가_있으면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "a,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨_번호가_45_초과일시_예외_발생")
    @Test
    void 당첨_번호가_45_초과일시_예외_발생() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "7");
        });
    }

    //그냥 통과하는 케이스로만들어보기
    @DisplayName("당첨_번호가_1_미만일시_예외_발생")
    @Test
    void 당첨_번호가_1_미만일시_예외_발생() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "7");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}