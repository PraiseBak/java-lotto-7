package lotto.exception;

public class LottoException extends IllegalArgumentException {
    public LottoException(LottoExceptionMessage lottoExceptionMessage) {
        super(lottoExceptionMessage.getMessage());
    }

    public LottoException(String message) {
        super(message);
    }
}
