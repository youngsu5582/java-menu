package menu.domain;

import menu.exception.ExceptionMessage;
import menu.repository.MenuRepository;
import menu.util.Constant;

import java.util.List;
import java.util.stream.Collectors;

public record HateInfo(List<Menu> hateMenuList) {
    public static HateInfo of(List<String> hateMenuInfo) {
        validateHateMenuInfo(hateMenuInfo);
        List<Menu> hateMenuList = hateMenuInfo
                .stream()
                .map(MenuRepository::findMenuByName)
                .toList();
        return new HateInfo(hateMenuList);
    }
    public boolean containMenu(Menu menu){
        return hateMenuList.contains(menu);
    }

    private static void validateHateMenuInfo(List<String> hateMenuInfo) {
        validateMenuSize(hateMenuInfo.size());
        validateDuplicate(hateMenuInfo);
    }

    private static void validateMenuSize(Integer menuSize) {
        if (menuSize > Constant.HATE_MENU_MAX_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_HATE_INFO.getMessage());
        }
    }

    private static void validateDuplicate(List<String> hateMenuInfo) {
        if (hateMenuInfo.stream().distinct().count() != hateMenuInfo.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_HATE_MENU_NAME.getMessage());
        }
    }


}
