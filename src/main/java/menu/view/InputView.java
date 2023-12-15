package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.HateInfo;
import menu.domain.Roster;
import menu.util.Parser;
import menu.util.Validator;
import menu.view.message.InputViewMessage;

import java.util.List;

public class InputView {
    private static InputView INSTANCE = null;

    public static InputView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InputView();
        }
        return INSTANCE;
    }

    public String readInput() {
        return Console.readLine();
    }

    public Roster inputRoaster() {
        String coachListInfo = readInput();
        Validator.validateFormat(coachListInfo);
        List<String> coachInfoList = Parser.parseInfoWithSeparator(coachListInfo, ",");

        return new Roster(coachInfoList);
    }

    public HateInfo inputHateInfo(String coachName) {
        System.out.println(InputViewMessage.HATE_INPUT_MESSAGE.getFormattedMessage(coachName));
        String hateInfo = readInput();
        Validator.validateFormat(hateInfo);
        List<String> hateInfoList = Parser.parseInfoWithSeparator(hateInfo, ",");
        return HateInfo.of(hateInfoList);
    }


}