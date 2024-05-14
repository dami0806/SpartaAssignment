package course.controllers;

import Score.models.Score;
import course.models.CourseEnrollment;
import exception.course.InvalidCourseException;
import exception.score.InvalidScoreException;
import exception.couseEnrollment.IsFullSessionException;
import student.models.Student;
import student.views.StudentView;

import java.io.BufferedReader;
import java.io.IOException;

import static Score.controllers.ScoreController.convertGradeElectiveCourse;
import static Score.controllers.ScoreController.convertGradeRequiredCourse;
import static util.ValidationUtils.*;

public class CourseEnrollmentController {
    static StudentView studentview = new StudentView();

    /**
     * 과목별 점수 입력하기
     * 한 과목당 최대 10회차 까지 점수 입력 가능 과목별 -  회차 점수 -> CourseEnrollment에서 관리
     *
     * @param br:     사용자 점수 입력
     * @param student 학생 //가지고 있음 Map<String, CourseEnrollment> courses;
     * @throws IOException
     */

    // 과목별 점수 추가하기
    public static void handleAddScores(BufferedReader br, Student student) {
        studentview.displayStudentDetails(student);
        try {
            String courseId = getValidCourseId(br, student);

            CourseEnrollment courseEnrollment = student.getCourses().get(courseId);

            if (courseEnrollment == null) {
                System.out.println("해당 ID의 과목이 존재하지 않습니다. 다시 입력해주세요.");
                return;
            }
            // 해당 섹션에 점수 입력
            getAddScoreSession(br, student, courseEnrollment);
        } catch (InvalidCourseException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getAddScoreSession(BufferedReader br, Student student, CourseEnrollment courseEnrollment) {
        // 채워지지않은 섹션보여주기
        try {
            int nextSession =  courseEnrollment.findNextSession();

            System.out.printf("%d 회차에 점수를 입력하세요: \n", nextSession);

            int newScore = getValidScore(br);

            courseEnrollment.inputScore(nextSession, newScore); // 점수 추가
            System.out.println("점수가 성공적으로 추가되었습니다.");
            displayAllCourseScores(student);
            getMoreAddScoreSession(br, student, courseEnrollment);

        } catch (IsFullSessionException e) {
            System.out.println(e.getMessage());
        } catch (InvalidScoreException e) {
            System.out.println(e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void getMoreAddScoreSession(BufferedReader br, Student student, CourseEnrollment courseEnrollment) throws IOException {

        try {

            int nextSession =  courseEnrollment.findNextSession();

            while (true) {
                System.out.printf("[%s 과목]의 다음[%d섹션]의 점수도 입력할건가요?(Y/N)\n",
                        courseEnrollment.getCourse().getCourseName(), nextSession);
                String input = br.readLine().trim();

                if (input.equalsIgnoreCase("Y")) {
                    getAddScoreSession(br, student, courseEnrollment);
                    break;
                } else if (input.equalsIgnoreCase("N")) {
                    System.out.printf("[%s 과목]의 점수 입력을 진행하지 않습니다.\n", courseEnrollment.getCourse().getCourseName());
                    System.out.println("점수를 입력할 다른 과목을 선택하시겠습니까?(Y/N)");

                    input = br.readLine().trim();
                    if (input.equalsIgnoreCase("Y")) {
                        handleAddScores(br, student);

                    } else {
                        System.out.println("더 이상 점수 입력을 진행하지 않습니다.");
                        break;
                    }
                    break;
                } else {
                    System.out.println("Y/N로 입력해야 합니다.");
                }
            }
        } catch (IsFullSessionException e) {
            System.out.println(e.getMessage());
        }
    }

    //과목별 점수 수정하기
    public static void handleUpdateScores(BufferedReader br, Student student) {
        studentview.displayStudentDetails(student);
        try {
            String courseId = getValidCourseId(br, student);

            if (courseId == null) {
                System.out.println("입력한 과목 ID가 유효하지 않습니다.");
                return;
            }

            // 해당 과목 찾은 후 섹션 입력
            CourseEnrollment courseEnrollment = student.getCourses().get(courseId);
            int session = getValidSession(br, courseEnrollment);
            if (session == -1) {
                System.out.println("유효한 회차 정보가 입력되지 않았습니다.");
                return;
            }

            // 해당 섹션 찾은 후 점수 입력
            System.out.println("새로운 점수를 입력하세요:");

            int validScore = getValidScore(br);
            if (validScore == -1) {
                System.out.println("유효한 점수가 입력되지 않았습니다.");
                return;
            }

            // 점수 업데이트
            courseEnrollment.inputScore(session, validScore);

            // 호출
            displaySelectedCourseScores(courseEnrollment);
            return;

        } catch (InvalidScoreException e) {
            System.out.println(e.getMessage());
        } catch (InvalidCourseException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 과목별 섹션별 점수 출력표 >> 과목만 출력, 섹션별 출력으로도 나누기
     *
     * @param student
     */
    private static void displayAllCourseScores(Student student) {
        System.out.println("등록된 모든 과목의 점수:");
        for (CourseEnrollment enrollment : student.getCourses().values()) {
            System.out.println("과목: " + enrollment.getCourse().getCourseName() + "의 점수");
            for (int session = 1; session <= 10; session++) {
                Score score = enrollment.getScoresBySession().get(session);
                String scoreOutput = (score != null) ? String.valueOf(score.getScore()) : "점수 없음";
                System.out.printf(" 회차 %d: 점수 %s\n", session, scoreOutput);
            }
        }
    }

    //특정 과목의 점수만
    private static void displaySelectedCourseScores(CourseEnrollment enrollment) {
        System.out.println("과목: " + enrollment.getCourse().getCourseName() + "의 점수");
        for (int session = 1; session <= 10; session++) {
            Score score = enrollment.getScoresBySession().get(session);
            String scoreOutput = (score != null) ? String.valueOf(score.getScore()) : "점수 없음";
            System.out.printf(" 회차 %d: 점수 %s\n", session, scoreOutput);
        }
    }


    public static void displaySessionGrades(BufferedReader br, Student student) throws IOException {

        String courseId = "";
        CourseEnrollment courseEnrollment = null;
        while (true) {
            System.out.println("등급을 조회할 과목의 ID를 입력하세요:");

            courseId = br.readLine().trim();

            courseEnrollment = student.getCourses().get(courseId);

            if (courseEnrollment == null) {
                System.out.println("해당 ID의 과목이 존재하지 않습니다. 다시 입력해주세요.");
            } else {
                break;
            }
        }
        int session = 0;
        System.out.println("모든 세션의 성적을 보려면 'ALL'을 입력하고, 특정 세션만 보려면 세션 번호를 입력하세요:");
        String input = br.readLine().trim();
        if(input.equalsIgnoreCase("ALL")) {}

            while (true) {
            System.out.printf("[%s]의 조회하고 싶은 [회차]를 입력하세요:\n", courseEnrollment.getCourse().getCourseName());
            try {
                session = Integer.parseInt(br.readLine().trim());
                if (!courseEnrollment.getScoresBySession().containsKey(session) || session < 1 || session > 10) {
                    System.out.println("유효하지 않은 세션 번호입니다. 다시 입력해주세요.");
                } else {
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("숫자를 입력해야 합니다.");
            }
        }

        Score score = courseEnrollment.getScoresBySession().get(session);
        // 선택 과목인지 필수 과목인지에 따라 등급을 변환
        if (courseEnrollment.getCourse().getType().equalsIgnoreCase("REQUIRED")) {
            convertGradeRequiredCourse(score);
        } else if (courseEnrollment.getCourse().getType().equalsIgnoreCase("ELECTIVE")) {
            convertGradeElectiveCourse(score);
        }

        System.out.printf("과목: %s, 회차: %d, 점수: %d, 등급: %s\n",
                courseEnrollment.getCourse().getCourseName(), session, score.getScore(), score.getGrade());
    }
}