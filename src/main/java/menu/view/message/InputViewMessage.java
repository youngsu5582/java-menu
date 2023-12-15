package menu.view.message;

public enum InputViewMessage {
    COACH_INPUT_MESSAGE("코치의 이름을 입력해 주세요. (, 로 구분)"),
    HATE_INPUT_MESSAGE("%s(이)가 못 먹는 메뉴를 입력해 주세요.");
    private final String message;

    InputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(Object... args) {
        return String.format(message, args);
    }

}