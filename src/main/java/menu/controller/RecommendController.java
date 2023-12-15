package menu.controller;

import menu.ApplicationStatus;
import menu.domain.Category;
import menu.domain.CategoryResult;
import menu.domain.CoachRecommend;
import menu.repository.CoachRepository;
import menu.repository.MenuRepository;
import menu.util.RandomGenerator;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RecommendController {
    private final InputView inputView;
    private final OutputView outputView;
    Integer dayCount = 0;

    public RecommendController() {
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
    }

    ;

    public ApplicationStatus process() {
        List<CoachRecommend> coachRecommends = CoachRepository
                .coaches()
                .stream()
                .map(CoachRecommend::of)
                .toList();

        CategoryResult categoryResult = new CategoryResult(new ArrayList<>());

        while (dayCount < 5) {
            Integer randomCategoryIndex = RandomGenerator.generateRandomCategoryNumber();
            Category category = Category.getCategoryFromIndex(randomCategoryIndex);

            if (categoryResult.isMaximum(category)) {
                continue;
            }
            List<String> menus = MenuRepository.findMenuNamesByCategory(category);
            coachRecommends.forEach(coachRecommend -> coachRecommend.recommendMenu(menus));
            dayCount++;
        }

        outputView.printResultMessage();
        outputView.printCategoryMessage(categoryResult.categoryList());
        for (CoachRecommend coachRecommend : coachRecommends) {
            outputView.printCoachRecommend(coachRecommend);
        }
        outputView.printFinishMessage();
        return ApplicationStatus.APPLICATION_EXIT;
    }
}
