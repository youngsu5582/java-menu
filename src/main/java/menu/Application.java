package menu;

import menu.controller.GameController;
import menu.service.MenuService;

public class Application {
    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        menuService.process();

        GameController gameController = new GameController();
        gameController.service();
    }
}
