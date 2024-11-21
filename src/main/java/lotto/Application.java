package lotto;

import com.sun.source.doctree.BlockTagTree;
import lotto.controller.LottoController;
import lotto.exception.LottoException;
import lotto.exception.LottoExceptionMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private static final LottoController lottoController = new LottoController();
    public static void main(String[] args) {
        buyLotto();
        buyLotto();



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
