import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// public是公共，表示可以从其他类和包访问。一旦定义变量类型时是private，而构建对象和方法则都是public
// Student和StudentManagementSystem没有public，说明他们只能在这个代码被调用


// 第一个类：学生类
// 编写逻辑：
class Student {
    private String id;
    private String name;
    private int age;

    // 通常变量名 = 参数名  但例外 this.参数名 = 变量名
    // 构造函数，用于创建学生对象
    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // 不写这个输出只会返回哈希码。写了这个之后打印构造的学生，就会返回这个格式
    // 不写返回数据为：Student@1b6d3586   @1b6d3586为哈希码
    // '\'' 表示单引号字符
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

// 第二个类：学生管理系统类
//  编写逻辑：
// 学生管理系统类
class StudentManagementSystem {
    private List<Student> students;  // <Student> 表示该students列表只能存储 Student 类型的对象。

    // 构造函数，初始化学生管理系统
    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    // 添加学生
    public void addStudent(Student student) {  // Student 是指方法 addStudent 的参数类型
        students.add(student);  // 将传入的 student 对象添加到 students 列表中
        System.out.println("Student added successfully.");
    }

    // 根据ID查找学生
    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // 显示所有学生信息
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("List of students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // 删除学生
    public void deleteStudent(String id) {
        Student studentToDelete = null;
        for (Student student : students) {
            if (student.getId().equals(id)) {
                studentToDelete = student;
                break;
            }
        }

        if (studentToDelete != null) {
            students.remove(studentToDelete);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}


// 主程序
// 运行逻辑：
public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1. Add student");
            System.out.println("2. Find student by ID");
            System.out.println("3. Display all students");
            System.out.println("4. Delete student by ID");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();// 获取用户输入的选项
            scanner.nextLine(); // 消费掉输入缓冲区中的换行符

            switch (choice) {
                case 1:
                    System.out.println("Enter student ID:");
                    String id = scanner.nextLine();
                    System.out.println("Enter student name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter student age:");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // 消费掉输入缓冲区中的换行符
                    Student student = new Student(id, name, age); // 新建一个student对象，传入数据
                    sms.addStudent(student);  // 使用sms对象，调用其中的函数，传入新建的student对象
                    break;
                case 2:
                    System.out.println("Enter student ID:");
                    String searchId = scanner.nextLine();
                    Student foundStudent = sms.findStudentById(searchId);
                    if (foundStudent != null) {
                        System.out.println("Student found:");
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    sms.displayAllStudents();
                    break;
                case 4:
                    System.out.println("Enter student ID:");
                    String deleteId = scanner.nextLine();
                    sms.deleteStudent(deleteId);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
