package menu.domain;

import menu.repository.MenuRepository;
import menu.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public record CoachRecommend(Coach coach, List<Menu> recommendMenus) {
    public static CoachRecommend of(Coach coach) {
        return new CoachRecommend(coach, new ArrayList<>());
    }

    public boolean satisfyMenu(Menu menu) {
        if (coach.hateInfo().containMenu(menu) || recommendMenus.contains(menu)) {
            return false;
        }
        return true;
    }

    public void recommendMenu(Menu menu) {
        recommendMenus.add(menu);
    }
}
