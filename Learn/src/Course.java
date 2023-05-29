public class Course {
    private String name; // 课程名称

    // 课程类的构造方法，用于初始化课程名称
    public Course(String name) {
        this.name = name;
    }

    // 显示课程信息的方法
    public void displayInfo() {
        System.out.println("Course: " + name);
    }
}
