package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFormatter {

    private final static String LOTTO_SUMMERY_FORMAT = "[%s]";
    private final static String LOTTO_BUY_FORMAT = "%d개를 구매했습니다.";

    public static String getLottoSummery(List<Integer> numbers) {
        return String.format(LOTTO_SUMMERY_FORMAT,numbers.stream()
                .map((number) -> number + "")
                .collect(Collectors.joining(", ")));
    }

    public static String getFormattedLottoSize(int size) {
        return String.format(LOTTO_BUY_FORMAT,size);

    }
}
