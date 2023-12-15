package menu.domain;

import menu.util.Constant;

import java.util.List;

public record CategoryResult(List<Category> categoryList) {

    public boolean isMaximum(Category category) {
        if (categoryList.stream().filter(category::equals).count() > Constant.CATEGORY_MAX_SIZE) {
            return true;
        }
        categoryList.add(category);
        return false;
    }
}
