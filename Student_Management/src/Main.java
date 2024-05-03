import course.models.Course;
import course.models.CourseEnrollment;
import student.models.IDGenerator;
import student.models.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 학생 이름 등록
        System.out.print("학생 이름을 입력하세요: ");
        String name = br.readLine();

        // 2. 과목 선택
        System.out.println("선택할 수 있는 과목 목록: ");
        System.out.println("[\"Java\", \"객체지향\", \"Spring\", \"JPA\", \"MySql\"]");
        System.out.print("최소 2개 이상의 선택 과목을 입력하세요 (예: Java 객체지향): ");
        String[] selectedCoursesInput = br.readLine().split(" ");
        Map<String, CourseEnrollment> courses = new HashMap<>();


    }

}