package course.models;

import Score.models.Score;
import student.models.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.AnnotatedType;
import java.util.HashMap;
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
    public void updateScore(int session, int score) throws Exception {
        if (scoresBySession == null) {
            throw new Exception("점수가 등록되어있지 않습니다");
        }
        String CourseId = course.getCourseId();

        int ses = session;

        if (score < 0 || score > 100) {
            throw new Exception("유효한 점수를 지정해주세요(0-100)");
        }
        int score_ = score;

        scoresBySession.put(session, new Score(score, "A"));
    }
}
