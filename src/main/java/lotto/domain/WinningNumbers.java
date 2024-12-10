package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.validator.UserInputValidator;

public class WinningNumbers {
    private final List<Integer> numberList;
    private int bonusNumber;
    public static int SPEICAL_CASE = 5;
    public static int BONUS_CASE_IDX = 7;

    public WinningNumbers(List<Integer> numberList) {
        UserInputValidator.validateLottoNumbers(numberList);
        this.numberList = numberList;
    }

    public void initBonusNumber(int bonusNumber){
        List<Integer> allWiningNumber = new ArrayList<>(bonusNumber);
        allWiningNumber.addAll(numberList);
        UserInputValidator.validateDuplicateNumbers(allWiningNumber);
        UserInputValidator.validateLottoNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Map<Integer,Integer> calculateCountWinningNumberMap(List<Lotto> lottos) {
        Map<Integer,Integer> countSameLotto = new HashMap<>();
        for(Lotto lotto : lottos){
            int winningNumberCount = lotto.countSameExists(numberList);
            int bonusNumberCount = lotto.countSameExists(Collections.singletonList(bonusNumber));
            if(winningNumberCount == SPEICAL_CASE && bonusNumberCount != 0){
                countSameLotto.put(BONUS_CASE_IDX,countSameLotto.getOrDefault(BONUS_CASE_IDX,0)+1);
                continue;
            }
            countSameLotto.put(winningNumberCount,countSameLotto.getOrDefault(winningNumberCount,0)+1);
        }
        return countSameLotto;
    }
}
