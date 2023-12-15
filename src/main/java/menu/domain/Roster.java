package menu.domain;

import menu.exception.ExceptionMessage;
import menu.util.Constant;

import java.util.List;

public record Roster(List<String> coachNameList) {
    public Roster(List<String> coachNameList) {
        validateCoachNameList(coachNameList);
        this.coachNameList = coachNameList;
    }

    private void validateCoachNameList(List<String> coachNameList) {
        validateListSize(coachNameList);
        validateDuplicate(coachNameList);
        validateCoachName(coachNameList);
    }

    private void validateListSize(List<String> coachNameList) {
        Integer size = coachNameList.size();
        if (size > Constant.COACH_ROSTER_MAX_SIZE || size < Constant.COACH_ROSTER_MIN_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_COACH_SIZE.getMessage());
        }
    }

    private void validateDuplicate(List<String> coachNameList) {
        if (coachNameList.stream().distinct().count() != coachNameList.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_COACH_NAME.getMessage());
        }
    }

    private void validateCoachName(List<String> coachNameList) {
        if (coachNameList.stream().anyMatch(this::isNameInvalid)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_COACH_NAME.getMessage());
        }
    }

    private boolean isNameInvalid(String coachName) {
        Integer length = coachName.length();
        return length > Constant.COACH_NAME_MAX_LENGTH || length < Constant.COACH_NAME_MIN_LENGTH;
    }

}
