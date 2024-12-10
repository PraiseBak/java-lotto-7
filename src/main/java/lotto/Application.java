package lotto;

import lotto.config.AppConfig;
import lotto.controller.LottoController;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private static final LottoController lottoController = AppConfig.getLottoController();
    public static void main(String[] args) {
        lottoBuyNumber();
        inputWinNumbers();
        inputBonusNumbers();
        printLottoResult();
    }

    private static void printLottoResult() {
        String lottoResult = lottoController.calculateLottoResult();
        OutputView.printLottoResult(lottoResult);
    }

    private static void inputBonusNumbers() {
        while (true){
            try {
                String s = InputView.inputBonusNumber();
                lottoController.inputBonusNumber(s);
                return;
            }catch (LottoException e){
                OutputView.printError(e.getMessage());
            }
        }
    }

    private static void inputWinNumbers() {
        while (true){
            try {
                String s = InputView.inputWinNumbers();
                lottoController.inputWinNumbers(s);
                return;
            }catch (LottoException e){
                OutputView.printError(e.getMessage());
            }
        }
    }

    private static void lottoBuyNumber() {
        while (true){
            try {
                String s = InputView.inputBuyNumber();
                String buyResult = lottoController.inputBuyNumber(s);
                OutputView.printLottoBuyNumber(buyResult);
                return;
            }catch (LottoException e){
                OutputView.printError(e.getMessage());
            }
        }
    }
}
