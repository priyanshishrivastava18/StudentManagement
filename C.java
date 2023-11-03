import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Student {
    private String studentId;
    private String name;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}

class Course {
    private String courseId;
    private String name;

    public Course(String courseId, String name) {
        this.courseId = courseId;
        this.name = name;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }
}

class Enrollment {
    private String studentId;
    private String courseId;

    public Enrollment(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourseId() {
        return courseId;
    }
}

class Grade {
    private String studentId;
    private String courseId;
    private double grade;

    public Grade(String studentId, String courseId, double grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public double getGrade() {
        return grade;
    }
}

public class C  {
    private Map<String, Student> students = new HashMap<>();
    private Map<String, Course> courses = new HashMap<>();
    private List<Enrollment> enrollments = new ArrayList<>();
    private List<Grade> grades = new ArrayList<>();

    public void addStudent(String studentId, String name) {
        Student student = new Student(studentId, name);
        students.put(studentId, student);
    }

    public void addCourse(String courseId, String name) {
        Course course = new Course(courseId, name);
        courses.put(courseId, course);
    }

    public void enrollStudent(String studentId, String courseId) {
        Enrollment enrollment = new Enrollment(studentId, courseId);
        enrollments.add(enrollment);
    }

    public void recordGrade(String studentId, String courseId, double grade) {
        Grade studentGrade = new Grade(studentId, courseId, grade);
        grades.add(studentGrade);
    }

    public List<Enrollment> getStudentEnrollments(String studentId) {
        List<Enrollment> studentEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId().equals(studentId)) {
                studentEnrollments.add(enrollment);
            }
        }
        return studentEnrollments;
    }

    public List<Grade> getStudentGrades(String studentId) {
        List<Grade> studentGrades = new ArrayList<>();
        for (Grade grade : grades) {
            if (grade.getStudentId().equals(studentId)) {
                studentGrades.add(grade);
            }
        }
        return studentGrades;
    }

    public static void main(String[] args) {
        C sms = new C();

        sms.addStudent("S1001", "Alice");
        sms.addStudent("S1002", "Bob");

        sms.addCourse("C101", "Math");
        sms.addCourse("C102", "History");

        sms.enrollStudent("S1001", "C101");
        sms.enrollStudent("S1001", "C102");
        sms.enrollStudent("S1002", "C102");

        sms.recordGrade("S1001", "C101", 90.5);
        sms.recordGrade("S1001", "C102", 85.0);
        sms.recordGrade("S1002", "C102", 78.5);

        System.out.println("Enrollments for Priyanshi (S1001):");
        List<Enrollment> aliceEnrollments = sms.getStudentEnrollments("S1001");
        for (Enrollment enrollment : aliceEnrollments) {
            System.out.println("Course ID: " + enrollment.getCourseId());
        }

        System.out.println("\nGrades for Priyanshi (S1001):");
        List<Grade> aliceGrades = sms.getStudentGrades("S1001");
        for (Grade grade : aliceGrades) {
            System.out.println("Course ID: " + grade.getCourseId() + ", Grade: " + grade.getGrade());
        }
    }
}