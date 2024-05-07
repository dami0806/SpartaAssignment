package course.models;

import Score.controllers.ScoreController;
import Score.models.Score;
import exception.couseEnrollment.InvalidSessionException;
import exception.couseEnrollment.IsFullSessionException;
import exception.score.InvalidScoreException;
import student.controllers.StudentController;
import util.ErrorMessage;

import java.util.Map;

public class CourseEnrollment {
    private Course course;


    private Map<Integer, Score> scoresBySession; // 개별 회차별 Score 객체 저장

    public Map<Integer, Score> getScoresBySession() {
        return scoresBySession;
    }

    //자동으로 채워지지않은 섹션보여주기 CourseEnrollment에서 처리
    public int findNextSession() throws IsFullSessionException {
        int nextSession = 1;
        while (scoresBySession.containsKey(nextSession)) {
            nextSession++;
            if (nextSession > 10) {
                throw new IsFullSessionException(ErrorMessage.IS_FULL_SESSION.getMessage());
            }
        }
        return nextSession;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public CourseEnrollment(Course course, Map<Integer, Score> scoresBySession) {
        this.course = course;
        this.scoresBySession = scoresBySession;
    }

    // 점수 입력
    public void inputScore(int session, int score)  {
        scoresBySession.put(session, new Score(score, "A"));
    }

}
