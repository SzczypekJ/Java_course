package collections;
import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        // Najpierw porównaj po nazwisku
        int nameComparison = o1.getName().compareTo(o2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        // Jeśli nazwiska są równe, porównaj po wieku
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
