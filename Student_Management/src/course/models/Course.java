package course.models;

import java.util.Map;

public class Course {
    private int courseId; // 과목 고유 번호
    private String courseName; // 과목 이름
    private Map<Integer, Integer> scoresBySession; // 회차별 점수를 저장하는 맵

    public Course(int courseId, String courseName, Map<Integer, Integer> scoresBySession) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.scoresBySession = scoresBySession;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Map<Integer, Integer> getScoresBySession() {
        return scoresBySession;
    }

    public void setScoresBySession(Map<Integer, Integer> scoresBySession) {
        this.scoresBySession = scoresBySession;
    }
}
