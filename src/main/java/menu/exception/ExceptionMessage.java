package menu.exception;

public enum ExceptionMessage {
    INVALID_GAME_COMMAND("올바르지 않은 커맨드입니다.");
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
