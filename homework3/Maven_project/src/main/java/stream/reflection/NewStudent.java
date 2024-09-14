package stream.reflection;

public class NewStudent {
    private String name;
    private int age;

    public NewStudent() {
    }

    public NewStudent(String name) {
        this.name = name;
    }

    public NewStudent(int age) {
        this.age = age;
    }

    public NewStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
