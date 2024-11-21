package lotto.exception;

public enum LottoExceptionMessage {

    INPUT_INVALID_ERROR("유효하지 않은 금액입니다."),
    BUY_MONEY_INVALID("구매 금액은 1000원 단위로 떨어져야합니다."),
    IS_NOT_NUMBER("입력이 숫자가 아닙니다."),
    BONUS_NUMBER_CANNOT_BE_DUPLICATE("보너스 숫자는 중복될 수 없습니다.");

    public String getMessage() {
        return message;
    }

    private String message;
    LottoExceptionMessage(String message){
        this.message = message;
    }
}
