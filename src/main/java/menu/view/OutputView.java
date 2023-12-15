package menu.view;

import menu.domain.Category;
import menu.domain.CoachRecommend;
import menu.domain.Menu;
import menu.view.message.OutputViewMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    private static OutputView INSTANCE = null;
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static OutputView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OutputView();
        }
        return INSTANCE;
    }

    private void printNewLine() {
        System.out.println();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String errorMessage) {
        printMessage(ERROR_PREFIX + errorMessage);
    }

    public void printStartMessage() {
        printMessage(OutputViewMessage.APPLICATION_START.getMessage());
    }

    public void printReceiptMessage() {
        printMessage(OutputViewMessage.RECEIPT_COACH.getMessage());
    }

    public void printResultMessage() {
        printMessage(OutputViewMessage.RESULT.getMessage());
    }

    public void printCategoryMessage(List<Category> categoryList) {
        String info = String.join(" | ", categoryList.stream().map(category -> category.getName()).toList());
        printMessage(OutputViewMessage.CATEGORY_INFO.getFormattedMessage(info));
    }

    public void printCoachRecommend(CoachRecommend coachRecommend) {
        String coachName = coachRecommend.coach().name();
        List<String> recommendMenus = coachRecommend.recommendMenus().stream().map(Menu::menuName).toList();
        String info = String.join(" | ", recommendMenus);
        printMessage(OutputViewMessage.RECOMMEND_INFO.getFormattedMessage(coachName, info));
    }

    public void printFinishMessage() {
        printMessage(OutputViewMessage.FINISH.getMessage());
    }


}