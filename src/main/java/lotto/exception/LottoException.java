package lotto.exception;

public class LottoException extends IllegalArgumentException {
    public LottoException(LottoExceptionMessage lottoExceptionMessage) {
        super(lottoExceptionMessage.getMessage());
    }
}
