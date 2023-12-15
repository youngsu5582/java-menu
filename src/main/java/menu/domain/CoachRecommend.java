package menu.domain;

import menu.repository.MenuRepository;
import menu.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public record CoachRecommend(Coach coach, List<Menu> recommendMenus) {
    public static CoachRecommend of(Coach coach) {
        return new CoachRecommend(coach, new ArrayList<>());
    }

    public void recommendMenu(List<String> menus) {
        String menuName = RandomGenerator.generateRandomMenuName(menus);
        Menu menu = MenuRepository.findMenuByName(menuName);
        if (coach.hateInfo().containMenu(menu) || recommendMenus.contains(menu))
            recommendMenu(menus);
        recommendMenus.add(menu);
    }
}
