package lotto.dto;

import java.util.List;

public record LottoRequest(int buyMoney, List<Integer> winningNumbers, int bonusNumber) {
    
}