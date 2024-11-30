package lotto;

import java.util.List;
import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private static final LottoController lottoController = new LottoController();
    public static void main(String[] args) {
        buyLotto();
        inputWinningNumbers();
        inputBonusNumberAndPlay();
    }

    private static void inputBonusNumberAndPlay() {
        while (true){
            try{
                int bonusNumber = InputView.inputBonusNumber();
                lottoController.inputBonusNumber(bonusNumber);
                OutputView.println(lottoController.calculateLottoResult());
                return;
            }catch (IllegalArgumentException e){
                OutputView.printError(e.getMessage());
            }
        }
    }

    private static void inputWinningNumbers() {
        while (true){
            try{
                List<Integer> winningNumbers = InputView.inputWinningNumbers();
                lottoController.inputWinningNumbers(winningNumbers);
                return;
            }catch (IllegalArgumentException e){
                OutputView.printError(e.getMessage());
            }
        }
    }

    private static void buyLotto() {
        while (true){
            try{
                int money = InputView.inputBuyMoney();
                OutputView.println(lottoController.buyLotto(money));
                return;
            }catch (IllegalArgumentException e){
                OutputView.printError(e.getMessage());
            }
        }
    }


}
