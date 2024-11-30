package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.dto.CalculateWinningNumberResult;

public class LottoFormatter {

    private final static String LOTTO_SUMMERY_FORMAT = "[%s]";
    private final static String LOTTO_BUY_FORMAT = "%d개를 구매했습니다.";
    private final static String LOTTO_SUMMERY_START = "당첨 통계\n---\n";
    private final static String LOTTO_WINNING_FORMAT = "%d개 일치 (%,d원) - %d개";
    private final static String LOTTO_WINNING_SPECIAL_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private final static String LOTTO_WINNING_RATIO = "총 수익률은 %.1f%%입니다.";
    private final static int SPECIAL_IDX = 7;
    private final static int SPEICAL_WINNING_IDX = 5;


    public static String getLottoSummery(List<Integer> numbers) {
        return String.format(LOTTO_SUMMERY_FORMAT,numbers.stream()
                .map((number) -> number + "")
                .collect(Collectors.joining(", ")));
    }

    public static String getFormattedLottoSize(int size) {
        return String.format(LOTTO_BUY_FORMAT,size);

    }

    public static String formattedLottoResult(double winningRatio, Map<Integer, Integer> winningCountMap) {
        StringBuilder stringBuilder = new StringBuilder(LOTTO_SUMMERY_START);
        for(Integer idx : LottoCalculator.lottoMoneyMap.keySet()){
            Integer count = winningCountMap.getOrDefault(idx,0);
            int money = LottoCalculator.lottoMoneyMap.get(idx);
            if(idx == SPECIAL_IDX){
                stringBuilder.append(String.format(LOTTO_WINNING_SPECIAL_FORMAT,SPEICAL_WINNING_IDX,money,count)).append("\n");
                continue;
            }
            stringBuilder.append(String.format(LOTTO_WINNING_FORMAT,idx,money,count)).append("\n");
        }
        return stringBuilder.append(String.format(LOTTO_WINNING_RATIO,winningRatio)).toString();
    }
}
