package menu.repository;

import menu.domain.Category;
import menu.domain.Menu;
import menu.exception.ExceptionMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuRepository {
    private static final List<Menu> menus = new ArrayList<>();

    public static List<Menu> menus() {
        return Collections.unmodifiableList(menus);
    }

    public static void addMenu(Menu menu) {
        menus.add(menu);
    }

    public static Menu findMenuByName(String menuName) {
        return menus.stream()
                .filter(menu -> menu.menuName().equals(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_EXIST_MENU.getMessage()));
    }

    public static List<String> findMenuNamesByCategory(Category category) {
        return menus().stream().filter(menu -> menu.category().equals(category)).map(Menu::menuName).toList();
    }
}