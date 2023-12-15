package menu.util;


import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> parseInfoWithSeparator(String info, String separator) {
        return Arrays.asList(info.split(separator));
    }
}
