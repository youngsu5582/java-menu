package menu.view.message;

public enum OutputViewMessage {
    APPLICATION_START("점심 메뉴 추천을 시작합니다.\n"),
    RECEIPT_COACH("코치의 이름을 입력해 주세요. (, 로 구분)"),
    RESULT("""
            메뉴 추천 결과입니다.
            [ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]
            """),
    CATEGORY_INFO("[ 카테고리 | %s ]"),
    RECOMMEND_INFO("[ %s | %s ]"),
    FINISH("추천을 완료했습니다.");
    private final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(Object... args) {
        return String.format(message, args);
    }
}