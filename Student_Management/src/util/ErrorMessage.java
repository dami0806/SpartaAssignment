package util;

public enum ErrorMessage {
    INVALID_COURSE_ID("해당 ID의 과목이 존재하지 않습니다. 다시 입력해주세요."),
    INVALID_SCORE("유효한 점수 범위는 0-100입니다."),
    INVALID_SESSION("유효한 섹션 범위를 지정해주세요(1-10), 또는 해당 섹션의 점수가 존재하지 않습니다."),
    IS_FULL_SESSION("해당과목의 모든 섹션이 모두 찼습니다."),
    INVALID_STUDENTID("해당 ID의 학생이 존재하지 않습니다. 다시 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
