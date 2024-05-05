package course.models;

import Score.controllers.ScoreController;
import Score.models.Score;
import java.util.Map;

public class CourseEnrollment {
    private Course course;
    private Map<Integer, Score> scoresBySession; // 개별 회차별 Score 객체 저장

    public Map<Integer, Score> getScoresBySession() {
        return scoresBySession;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setScoresBySession(Map<Integer, Score> scoresBySession) {
        this.scoresBySession = scoresBySession;
    }

    public CourseEnrollment(Course course, Map<Integer, Score> scoresBySession) {
        this.course = course;
        this.scoresBySession = scoresBySession;
    }

    // 점수 추가
    public void addScore(int session, int score) throws Exception {
        // 점수 정의
        if (session < 1 || session > 10) {
            throw new Exception("유효한 섹션 범위를 지정해주세요(1-10)");
        }
        // 중복성
        if (scoresBySession.containsKey(session)) {
            throw new Exception("이전 섹션의 점수가 있습니다");
        }
        if (score < 0 || score > 100) {
            throw new Exception("유효한 점수를 지정해주세요(0-100)");
        }
        scoresBySession.put(session, new Score(score, "A"));
    }

    // 점수 수정
    public void updateScore(int session, int newScore) throws Exception {
        // 세션 번호와 점수의 유효성 검사
        if (session < 1 || session > 10) {
            throw new Exception("유효한 섹션 범위를 지정해주세요(1-10)");
        }
        if (newScore < 0 || newScore > 100) {
            throw new Exception("유효한 점수를 지정해주세요(0-100)");
        }

        // 점수 객체 찾기
        Score score = scoresBySession.get(session);
        if (score == null) {
            throw new Exception("이전 섹션의 점수가 없음");
        }
        score.setScore(newScore);

        // 과목의 종류에 따라 등급 변환
        if (course.getType().equalsIgnoreCase("REQUIRED")) {
            ScoreController.convertGradeRequiredCourse(score);
        } else if (course.getType().equalsIgnoreCase("ELECTIVE")) {
            ScoreController.convertGradeElectiveCourse(score);
        }
    }
}
