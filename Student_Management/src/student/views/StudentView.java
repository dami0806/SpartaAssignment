package student.views;

import course.models.CourseEnrollment;
import student.models.Student;

import java.util.Map;

public class StudentView {

    public static void displayStudentDetails(Student student){

        System.out.println("=======================================");

        System.out.println("학생 ID: " + student.getId());
        System.out.println("이름: " + student.getName());
        System.out.println("상태: " + student.getState());
        System.out.println("수강 과목:");
        student.getCourses().forEach((id, enrollment) ->
                System.out.println("과목 ID: " + id + ", 과목 이름: " + enrollment.getCourse().getCourseName()));
        System.out.println("=========================================");
    }


    public static void displaysAllStudents(Map<Integer, Student> students) {
        students.forEach((id, student) -> displayStudentDetails(student));
    }
}
