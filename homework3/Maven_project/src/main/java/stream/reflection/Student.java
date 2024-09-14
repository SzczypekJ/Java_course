package stream.reflection;

public class Student {

    private String name;

    public Student(String ivan) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
    }

    public void print(String text) {
        System.out.println("Print: " + text);
    }
}
