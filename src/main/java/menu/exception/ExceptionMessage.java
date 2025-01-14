package menu.exception;

public enum ExceptionMessage {
    INVALID_GAME_COMMAND("올바르지 않은 커맨드입니다."),
    INVALID_FORMAT("입력 형식이 올바르지 않습니다."),
    INVALID_COACH_SIZE("코치는 2명 에서 5명 사이 입력 해야 합니다."),
    INVALID_COACH_NAME("코치의 이름은 2글자 에서 4글자 사이 입력 해야 합니다."),
    DUPLICATE_COACH_NAME("코치의 이름은 중복될 수 없습니다."),
    INVALID_HATE_INFO("싫어하는 메뉴는 최대 2개 까지입니다."),
    DUPLICATE_HATE_MENU_NAME("싫어하는 메뉴는 중복될 수 없습니다."),
    NOT_EXIST_MENU("없는 메뉴입니다.");
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
