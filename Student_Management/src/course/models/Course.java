package course.models;

import Score.models.Score;

import java.util.Map;

public class Course {
    private String  courseId; // 과목 고유 번호
    private String courseName; // 과목 이름
    private String type;  // "required" or "elective"

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getType() {
        return type;
    }

    public Course(String courseId, String courseName, String type) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.type = type;
    }
    @Override
    public String toString() {
        return String.format("[%s]: %s(%s)",
                this.courseId, courseName,
                type.substring(0, 1).toUpperCase() + type.substring(1));

    }

}