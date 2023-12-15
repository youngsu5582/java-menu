package menu.util;

import menu.exception.ExceptionMessage;

import java.util.regex.Pattern;

public class Validator {
    public static void validateFormat(String info) {
        Pattern pattern = Pattern.compile("^([a-zA-Z]+,)*[a-zA-Z]+$\n");
        if (pattern.matcher(info).matches()) {
            return;
        }
        throw new Error(ExceptionMessage.INVALID_FORMAT.getMessage());
    }

}
