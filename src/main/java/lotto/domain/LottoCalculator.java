package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.dto.CalculateWinningNumberResult;

public class LottoCalculator {

    public static final Map<Integer,Integer> lottoMoneyMap = new HashMap<>();
    private static final int SPECIAL_IDX = 7;
    private static final int BONUS_CHECK_NUMBER = 5;
    private static final int MIN_WINNING_NUMBER = 3;
    private static final int PER_LOTTO_PRICE = 1000;

    static {
        lottoMoneyMap.put(3,5000);
        lottoMoneyMap.put(4,50000);
        lottoMoneyMap.put(5,1500000);
        lottoMoneyMap.put(6,2000000000);
        lottoMoneyMap.put(SPECIAL_IDX,30000000);
    }

    private LottoCalculator() {
    }

    public static Map<Integer,Integer> calculateWinningNumber(List<CalculateWinningNumberResult> calculateWinningNumberResults) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for(CalculateWinningNumberResult calculateWinningNumberResult : calculateWinningNumberResults){
            int curWinningIdx = calculateWinningNumberResult.sameWinningCount();
            if(calculateWinningNumberResult.sameWinningCount() == BONUS_CHECK_NUMBER && calculateWinningNumberResult.sameBounsCount() != 1){
                curWinningIdx = SPECIAL_IDX;
            }
            if(curWinningIdx >= MIN_WINNING_NUMBER){
                countMap.put(curWinningIdx,countMap.getOrDefault(curWinningIdx,0)+1);
            }
        }
        return countMap;
    }

    public static double calculateWinningRatio(Map<Integer, Integer> winningCountMap, int lottoBuyCount) {
        int moneySum = 0;
        for(Integer idx : winningCountMap.keySet()){
            double earnMoney = winningCountMap.get(idx) * lottoMoneyMap.get(idx);
            moneySum += earnMoney;
        }
        double totalInvestment = PER_LOTTO_PRICE * lottoBuyCount;
        double percentage = (moneySum / totalInvestment) * 100;
        return percentage;
    }
}

