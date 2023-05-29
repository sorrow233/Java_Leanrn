public class StudentManager {
    public static void main(String[] args) {
        // 创建学生对象
        Student student = new Student("John Doe", 20);

        // 创建课程对象
        Course course = new Course("Java Programming");

        // 显示学生信息
        student.displayInfo();

        // 显示课程信息
        course.displayInfo();
    }
}