package Score.controllers;

import Score.models.Score;

public class ScoreController {

    // 필수 과목 등급 산정
    public static void convertGradeRequiredCourse(Score score) {
        int points = score.getScore();
        String grade = "";
        if ((100 >= points) && (points >= 95)) grade = "A";
        else if (points >= 90) grade = "B";
        else if (points >= 80) grade = "C";
        else if (points >= 70) grade = "D";
        else if (points >= 60) grade = "F";
        else grade = "N";
        score.setGrade(grade);
    }

    // 선택 과목 등급 산정
    public static void convertGradeElectiveCourse(Score score) {
        int points = score.getScore();
        String grade = "";
        if (points >= 90) grade = "A";
        else if (points >= 80) grade = "B";
        else if (points >= 70) grade = "C";
        else if (points >= 60) grade = "D";
        else if (points >= 50) grade = "F";
        else grade = "N";
        score.setGrade(grade);
    }
}
