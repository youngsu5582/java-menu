package menu.util;

import menu.exception.ExceptionMessage;

import java.util.regex.Pattern;

public class Validator {
    //쉼표 검증
    private static Pattern pattern = Pattern.compile("^([a-zA-Z가-힣]+,)*[a-zA-Z가-힣]+$");

    public static void validateFormat(String info) {
        if (pattern.matcher(info).matches()) {
            return;
        }

        throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_COACH_NAME.getMessage());
    }

}
