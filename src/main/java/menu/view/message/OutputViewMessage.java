package menu.view.message;

public enum OutputViewMessage {
    APPLICATION_START("점심 메뉴 추천을 시작합니다.");
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