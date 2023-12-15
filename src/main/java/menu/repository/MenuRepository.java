package menu.repository;

import menu.domain.Menu;

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

}