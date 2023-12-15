package menu.controller;

import menu.ApplicationStatus;
import menu.domain.*;
import menu.repository.CoachRepository;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RecommendController recommendController;
    private final Map<ApplicationStatus, Supplier<ApplicationStatus>> gameGuide;

    public GameController() {
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
        this.recommendController = new RecommendController();
        this.gameGuide = new EnumMap<>(ApplicationStatus.class);
        initializeGameGuide();
    }

    public void service() {
        ApplicationStatus applicationStatus = progress(ApplicationStatus.APPLICATION_START); // 초기 설정
        while (applicationStatus.playable()) {
            applicationStatus = progress(applicationStatus);
        }
    }

    public ApplicationStatus progress(ApplicationStatus applicationStatus) {
        try {
            return gameGuide.get(applicationStatus).get();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return ApplicationStatus.APPLICATION_EXIT;
        }
    }

    private void initializeGameGuide() {
        gameGuide.put(ApplicationStatus.APPLICATION_START, this::applicationStart);
        gameGuide.put(ApplicationStatus.COACH_RECEIPT, this::coachReceipt);
        gameGuide.put(ApplicationStatus.MENU_RECOMMEND,recommendController::process);
        gameGuide.put(ApplicationStatus.APPLICATION_EXIT, this::applicationExit);

    }

    private ApplicationStatus applicationStart() {
        outputView.printStartMessage();
        return ApplicationStatus.COACH_RECEIPT;
    }

    private ApplicationStatus coachReceipt() {
        outputView.printReceiptMessage();
        Roster roster = inputView.inputRoaster();
        roster.coachNameList().stream().forEach(this::addCoach);
        return ApplicationStatus.MENU_RECOMMEND;
    }

    private void addCoach(String coachName) {
        try {
            HateInfo hateInfo = inputView.inputHateInfo(coachName);
            CoachRepository.addCoach(new Coach(coachName, hateInfo));
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            addCoach(coachName);
        }
    }

    private ApplicationStatus applicationExit() {
        return ApplicationStatus.APPLICATION_EXIT;
    }


}
