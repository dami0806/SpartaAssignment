package course.controllers;

import Score.models.Score;
import course.models.Course;
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

    // 과목별 점수 추가하기
    public static void handleAddScores(BufferedReader br, Student student) throws IOException {
        System.out.println("점수를 추가할 과목의 ID를 입력하세요:");
        String courseId = br.readLine().trim();
        CourseEnrollment courseEnrollment = student.getCourses().get(courseId);

        if (courseEnrollment == null) {
            System.out.println("해당 ID의 과목이 존재하지 않습니다. 다시 입력해주세요.");
            return;
        }
//
        // 해당 섹션에 점수 입력
        getAddScoreSession(br, student, courseEnrollment);

        String response = br.readLine().trim();

        if (response.equalsIgnoreCase("Y")) {
            handleAddScores(br, student);
        }

//        //s 입력
//        if (!handleStartAddScores(br, student)) {
//            System.out.println("점수입력없이 마칩니다.");
//            return;
//        }

    }

    //자동으로 채워지지않은 섹션보여주기
    public static int findNextSession(CourseEnrollment courseEnrollment) {
        int nextSession = 1;
        while (courseEnrollment.getScoresBySession().containsKey(nextSession)) {
            nextSession++;
        }
        return nextSession;
    }

    public static void getMoreAddScoreSession(BufferedReader br, Student student, CourseEnrollment courseEnrollment) throws IOException {
        int nextSession = findNextSession(courseEnrollment);

        while (true) {
            System.out.printf("[%s 과목]의 다음[%d섹션]의 점수도 입력할건가요?(Y/N)\n", courseEnrollment.getCourse().getCourseName(), nextSession);
            String input = br.readLine().trim();

            if (input.equalsIgnoreCase("Y")) {
                getAddScoreSession(br, student, courseEnrollment);
                break;
            } else if (input.equalsIgnoreCase("N")) {
                System.out.printf("[%s 과목]의 점수 입력을 진행하지 않습니다.", courseEnrollment.getCourse().getCourseName());
                System.out.println("점수를 입력할 다른 과목을 선택하시겠습니까?");
                //
                input = br.readLine().trim();
                if (input.equalsIgnoreCase("Y")) {
                    //다른과목 선택
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
    }

    public static void getAddScoreSession(BufferedReader br, Student student, CourseEnrollment courseEnrollment) throws IOException {
        //자동으로 채워지지않은 섹션보여주기
        int nextSession = findNextSession(courseEnrollment);

        int newScore = getValidScore(br);
        System.out.printf("%d 회차에 점수를 입력하세요: ", nextSession);

        try {
            courseEnrollment.addScore(nextSession, newScore); // 점수 추가
            System.out.println("점수가 성공적으로 추가되었습니다.");
            displayAllCourseScores(student);
            getMoreAddScoreSession(br, student, courseEnrollment);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //과목별 점수 수정하기
    public static void handleUpdateScores(BufferedReader br, Student student) throws IOException {
        // System.out.println("점수를 수정할 과목의 ID를 입력하세요:");
        String courseId = getValidCourseId(br, student);

        CourseEnrollment courseEnrollment = student.getCourses().get(courseId);
        getValidSession(br, student, courseEnrollment);

        getValidScore(br);

        displayAllCourseScores(student);
    }

    // 유효한 과목ID
    private static String getValidCourseId(BufferedReader br, Student student) throws IOException {
        System.out.println("점수를 수정할 과목의 ID를 입력하세요:");

        String courseId = br.readLine().trim();
        if (!student.getCourses().containsKey(courseId)) {
            System.out.println("해당 ID의 과목이 존재하지 않습니다. 다시 입력해주세요.");
            return getValidCourseId(br, student);
        }
        return courseId;

    }

    // 유효한 섹션
    private static int getValidSession(BufferedReader br, Student student, CourseEnrollment courseEnrollment) throws
            IOException {
        System.out.println("수정할 회차를 입력하세요:");
        int session = 0;
        try {
            session = Integer.parseInt(br.readLine().trim());
            if (session < 1 || session > 10) {
                System.out.println("유효한 섹션 범위를 지정해주세요(1-10)");
                getValidSession(br, student, courseEnrollment);
            }
            if (!courseEnrollment.getScoresBySession().containsKey(session)) {
                System.out.println("이전 섹션의 점수가 없습니다");
                getValidSession(br, student, courseEnrollment);
            }

        } catch (NumberFormatException e) {
            System.out.println("유효한 숫자를 입력하세요.");
            return getValidSession(br, student, courseEnrollment);
        }
        return session;
    }

    // 유효한 점수
    private static int getValidScore(BufferedReader br) throws IOException {
        System.out.println("새로운 점수를 입력하세요:");
        int newScore = 0;
        try {
            newScore = Integer.parseInt(br.readLine());
            if (newScore < 0 || newScore > 100) {
                System.out.println("유효한 점수를 입력하세요.");
                return getValidScore(br);
            }
        } catch (NumberFormatException e) {
            System.out.println("유효한 숫자를 입력하세요.");
            return getValidScore(br);
        }
        return newScore;
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

    private static void displayScores(Student student, CourseEnrollment courseEnrollment) {
        System.out.printf("등록된[%s] 과목의 점수:\n");
        if(student.getCourses().containsKey(courseEnrollment.getCourse().getCourseId())) {
            System.out.println("과목: " + courseEnrollment.getCourse().getCourseName() + "의 점수");

            for (int session = 1; session <= 10; session++) {
                Score score = courseEnrollment.getScoresBySession().get(session);
                String scoreOutput = (score != null) ? String.valueOf(score.getScore()) : "점수 없음";
                System.out.printf(" 회차 %d: 점수 %s\n", session, scoreOutput);
            }
        }
    }
}