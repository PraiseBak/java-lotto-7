package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoCalculator {
    private final static HashMap<Integer,Integer> hashMap = new HashMap<>();
    static {
        hashMap.put(3,5000);
        hashMap.put(4,50000);
        hashMap.put(5,1500000);
        hashMap.put(6,2000000000);
        hashMap.put(WinningNumbers.BONUS_CASE_IDX,30000000);
    }

    public boolean isBonusCase(){

        return true;
    }
    public static String calculateLottoResult(LottoManager lottoManager, WinningNumbers winningNumbers) {
        Map<Integer, Integer> calculateCountWinningNumberMap = lottoManager.getCalculateCountWinningNumberMap(winningNumbers);
        StringBuilder resultStringBuilder = new StringBuilder(LottoFormatter.formattedCalculateLottoResult());
        int sum = 0;
        for(int count = 3;count <=6;count++){
            sum = calculateLottoWinning(count, resultStringBuilder, calculateCountWinningNumberMap, sum);
            if(count == WinningNumbers.SPEICAL_CASE){
                sum = calculateLottoWinning(WinningNumbers.BONUS_CASE_IDX, resultStringBuilder, calculateCountWinningNumberMap, sum);
            }
        }
        resultStringBuilder.append(LottoFormatter.lottoWinRatio(calculateRatio(sum,lottoManager.getLottoBuyMoney())));
        return resultStringBuilder.toString();
    }

    private static double calculateRatio(int sum, int lottoBuyMoney) {
        double v = (double) sum / (double) lottoBuyMoney;
        double result = (v * 100) ;
        return result;
    }

    private static int calculateLottoWinning(int count, StringBuilder resultStringBuilder,
                                             Map<Integer, Integer> calculateCountWinningNumberMap, int sum) {
        int money = hashMap.get(count);
        resultStringBuilder.append(LottoFormatter.getCalculateLottoResult(count,
                calculateCountWinningNumberMap.getOrDefault(count,0),money));
        sum += money * calculateCountWinningNumberMap.getOrDefault(count,0);
        return sum;
    }
}
