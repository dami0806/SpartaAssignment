import Score.models.Score;
import course.models.Course;
import course.models.CourseData;
import course.models.CourseEnrollment;
import student.models.IDGenerator;
import student.models.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static course.controllers.CourseEnrollmentController.handleAddScores;
import static course.controllers.CourseEnrollmentController.handleUpdateScores;

// 필수과목인지 선택과목인지 타입에 맞춰서 불러오기
// 과목 선택하기
//과목id -
//과목별 점수 입력하기

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("학생 이름을 입력하세요: ");
        String name = br.readLine();
        int studentId = IDGenerator.getInstance().generateId();

        CourseData.createCourseList();
        List<Course> allCourses = CourseData.getCourseList();
        List<Course> requiredCourses = filterCoursesByType(allCourses, "required");
        List<Course> electiveCourses = filterCoursesByType(allCourses, "elective");

        displayCourses("필수 과목", requiredCourses);
        displayCourses("선택 과목", electiveCourses);

        Student student = new Student(studentId, name, "상태", new HashMap<>());

        student.addCourse(selectCourses(br, requiredCourses, "필수"));
        student.addCourse(selectCourses(br, electiveCourses, "선택"));

        System.out.println("\n학생 정보:");
        System.out.printf("ID: %d, 이름: %s\n", student.getId(), student.getName());

        //점수를 추가하기
        handleAddScores(br, student);

        //점수 수정하기
      //  handleUpdateScores(br, student);


    }

    // 필수과목인지 선택과목인지 타입에 맞춰서 불러오기
    private static List<Course> filterCoursesByType(List<Course> courses, String type) {
        return courses.stream()
                .filter(course -> course.getType().equals(type))
                .collect(Collectors.toList());
    }

    private static void displayCourses(String header, List<Course> courses) {
        System.out.println(header + ":");
        courses.forEach(course -> System.out.printf(" %s (%s) |", course.getCourseName(), course.getCourseId()));
        System.out.println("\n");
    }

    /**
     * 과목선택하기
     *
     * @param br:               입력값: 과목id
     * @param availableCourses: 중복이나 해당 종류가 아닌 과목 선택 방지
     * @param type:             필수과목, 선택과목
     * @return : 선택된 List<Course>
     * @throws IOException
     */
    private static List<Course> selectCourses(BufferedReader br, List<Course> availableCourses, String type) throws IOException {

        System.out.println("다음 중에서 " + type + " 과목을 최소 3개 선택해주세요:");
        List<Course> selectedCourses = new ArrayList<>();

        while (selectedCourses.size() < 3) {
            System.out.print("과목 ID를 입력하세요: ");
            String courseId = br.readLine().trim(); // C01

            if ("e".equalsIgnoreCase(courseId)) break;
            Course course = availableCourses.stream()
                    .filter(c -> courseId.equals(c.getCourseId()))
                    .findFirst()
                    .orElse(null);

            if (course != null && !selectedCourses.contains(course)) {
                selectedCourses.add(course);

                System.out.println(course.getCourseName() + " 추가됨.");
            } else {
                System.out.println("유효하지 않거나 이미 추가된 과목입니다. 다시 입력해주세요.");
            }
        }
        return selectedCourses;
    }
}
