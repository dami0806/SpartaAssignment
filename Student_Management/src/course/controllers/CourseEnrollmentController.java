package course.controllers;

import Score.models.Score;
import course.models.CourseEnrollment;
import student.models.Student;

import java.io.BufferedReader;
import java.io.IOException;

public class CourseEnrollmentController {


    /**
     * 과목별 점수 입력하기
     * 한 과목당 최대 10회차 까지 점수 입력 가능 과목별 -  회차 점수 -> CourseEnrollment에서 관리
     *
     * @param br:     사용자 점수 입력
     * @param student 학생 //가지고 있음 Map<String, CourseEnrollment> courses;
     * @throws IOException
     */
    public static void handleAddScores(BufferedReader br, Student student) throws IOException {
        System.out.println("과목별 점수를 입력하려면 's', 점수 입력을 마치려면 'e'를 입력하세요.");
        String input = br.readLine();

        if ("s".equalsIgnoreCase(input)) {
            //학생이 등록한 과목 조회
            for (CourseEnrollment enrollment : student.getCourses().values()) {

                System.out.println("과목: " + enrollment.getCourse().getCourseName());
                for (int session = 1; session <= 3; session++) {
                    System.out.printf("%d 회차의 점수: (e 누르면 입력완료)", session);
                    String scoreInput = br.readLine();
                    if ("e".equalsIgnoreCase(scoreInput)) break;
                    try {
                        int score = Integer.parseInt(scoreInput);
                        enrollment.addScore(session, score);
                    } catch (NumberFormatException e) {
                        System.out.println("유효한 숫자를 입력하세요.");
                        session--;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        session--;

                    }
                }
            }
            displayScores(student);
        }

    }

    //과목별 점수 수정하기
    public static void handleUpdateScores(BufferedReader br, Student student) throws IOException {
        System.out.println("점수를 수정할 과목의 ID를 입력하세요:");
        String courseId = br.readLine().trim();
        int session = 0;
        CourseEnrollment courseEnrollment = student.getCourses().get(courseId);
        if (courseEnrollment == null) {
            System.out.println("해당 ID의 과목이 존재하지 않습니다. 다시 입력해주세요.");
            return;
        }

        System.out.println("수정할 회차를 입력하세요:");


        try {
            session = Integer.parseInt(br.readLine().trim());
            if (session < 1 || session > 3) {
                System.out.println("유효한 섹션 범위를 지정해주세요(1-3)");
            }
            if (!courseEnrollment.getScoresBySession().containsKey(session)) {
                System.out.println("이전 섹션의 점수가 없습니다");
            }
        } catch (NumberFormatException e) {
            System.out.println("유효한 숫자를 입력하세요.");
        }

        System.out.println("새로운 점수를 입력하세요:");
        int newScore = 0;

        try {
            newScore = Integer.parseInt(br.readLine());
            if (newScore < 0 || newScore > 100) {
                System.out.println("유효한 점수를 입력하세요.");
            }
        } catch (NumberFormatException e) {
            System.out.println("유효한 숫자를 입력하세요.");
        }
        try {
            courseEnrollment.updateScore(session, newScore);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        displayScores(student);
    }

    /**
     * 과목별 섹션별 점수 출력표 >> 과목만 출력, 섹션별 출력으로도 나누기
     *
     * @param student
     */
    private static void displayScores(Student student) {
        System.out.println("등록된 모든 과목의 점수:");
        for (CourseEnrollment enrollment : student.getCourses().values()) {
            System.out.println("과목: " + enrollment.getCourse().getCourseName() + "의 점수");
            for (int session = 1; session <= 3; session++) {
                Score score = enrollment.getScoresBySession().get(session);
                String scoreOutput = (score != null) ? String.valueOf(score.getScore()) : "점수 없음";
                System.out.printf(" 회차 %d: 점수 %s\n", session, scoreOutput);
            }
        }
    }
}
