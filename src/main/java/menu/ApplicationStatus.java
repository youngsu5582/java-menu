package menu;

public enum ApplicationStatus {
    APPLICATION_START,
    COACH_RECEIPT,
    MENU_RECOMMEND,
    APPLICATION_EXIT;

    public boolean playable() {
        return this != APPLICATION_EXIT;
    }
    }
