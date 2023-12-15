package menu.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomGenerator {
    public static Integer generateRandomCategoryNumber() {
        return Randoms.pickNumberInRange(1, 5);
    }

    public static String generateRandomMenuName(List<String> menuNameList) {
        return Randoms.shuffle(menuNameList).get(0);
    }

}
