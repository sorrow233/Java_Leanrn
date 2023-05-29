public class Student {
    private String name; // 学生姓名
    private int age; // 学生年龄

    // 学生类的构造方法，用于初始化姓名和年龄
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 显示学生信息的方法
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
