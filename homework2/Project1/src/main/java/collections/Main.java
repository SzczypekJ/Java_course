package collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String [] stringArray = new String [10];
        int [] intArray = new int [10];


        List<String> stringList = new ArrayList<>();
        stringList.add("First");
//        Error:
//        a.add(5);


        List<Integer> integerList = new ArrayList<>();
        integerList.add(5);
//        Error:
//        integerList.add("ten");


        List<Student> students = new ArrayList<>();
        Student student = new Student("Jakub", 20);
        students.add(student);
//        Error:
//        students.add("");
//        students.add(5);


        List<String> arrayList = new ArrayList<>();
        arrayList.add("First");
        arrayList.add("Second");
        arrayList.remove("First");
        System.out.println("Size of stringList: " + arrayList.size());
        System.out.println("First element in stringList: " + arrayList.get(0));


        List<String> linkedList = new LinkedList<String>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        System.out.println("LinkedList elements: " + linkedList);

        // HasSet - unsorted, LinkedHashSet - sorted (insertion order), TreeSet - sorted
        Set<Student> set = new HashSet<>();
        set.add(new Student("Jakub", 20));
        set.add(new Student("Jakub", 20)); // This student will not be added
        for (int i = 0; i <100; i++)
            set.add(new Student("Jakub" + i, i));
        System.out.println(set);


        Set<Integer> setInteger = new HashSet<>();
        setInteger.add(5);
        setInteger.add(5); // 5 will not be added because it's duplicate
        System.out.println(setInteger);


        StudentComparator studentComparator = new StudentComparator();
        Set<Student> sortedStudentSet = new TreeSet<>(studentComparator);
        sortedStudentSet.addAll(set);
        System.out.println("Sorted Student set: " + sortedStudentSet);


        Queue<String> queue = new PriorityQueue<>();
        queue.add("C");
        queue.add("B");
        queue.add("A");
        System.out.println("PriorityQueue poll: " + queue.poll());
        System.out.println("PriorityQueue poll: " + queue.poll());
        System.out.println("PriorityQueue poll: " + queue.poll());


        queue.add("C");
        queue.add("B");
        queue.add("A");
        System.out.println("PriorityQueue peek: " + queue.peek());
        System.out.println("PriorityQueue peek: " + queue.peek());
        System.out.println("PriorityQueue peek: " + queue.peek());


        Stack<String> newB = new Stack<>();
        newB.add("C");
        newB.add("B");
        newB.add("A");
        System.out.println("Stack pop: " + newB.pop());
        System.out.println("Stack pop: " + newB.pop());
        System.out.println("Stack pop: " + newB.pop());


        newB.add("C");
        newB.add("B");
        newB.add("A");
        System.out.println("Stack peek: " + newB.peek());
        System.out.println("Stack peek: " + newB.peek());
        System.out.println("Stack peek: " + newB.peek());

        Map<String, Integer> map = new HashMap<>();
        map.put("First", 1);
        map.put("Second", 2);
        map.put("First", 3); //  Override value for key ‘First’
        System.out.println("Value for 'First': " + map.get("First"));

//      Iterate through the map
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println("Key: " + pair.getKey() + ", Value: " + pair.getValue());
        }

        List<ANCUB> ancubList = new ArrayList<>();
        ancubList.add(new ANCUB());
        ancubList.add(new ANCUB());
        System.out.println("List of ANCUB objects: " + ancubList);


        // Testing custom LinkedList with generic!!!!!!!!!!!!!!!!
        // Integer List

        // Creating new empty Integer linked list
        list<Integer> list1 = new list<>();
        System.out.println(
                "Integer LinkedList created as list1 :");
        // Adding elements to the above List object

        // Element 1 - 100
        list1.add(100);
        // Element 2 - 200
        list1.add(200);
        // Element 3 - 300
        list1.add(300);

        // Display message only
        System.out.println(
                "list1 after adding 100,200 and 300 :");

        // Print and display the above List elements
        System.out.println(list1);

        // Removing 200 from list1
        list1.remove(200);

        // Display message only
        System.out.println("list1 after removing 200 :");

        // Print and display again updated List elements
        System.out.println(list1);

        // String LinkedList

        // Creating new empty String linked list
        list<String> list2 = new list<>();
        System.out.println(
                "\nString LinkedList created as list2");
        // Adding elements to the above List object

        // Element 1 - hello
        list2.add("hello");

        // Element 2 - world
        list2.add("world");

        // Display message only
        System.out.println(
                "list2 after adding hello and world :");

        // Print current elements only
        System.out.println(list2);

        // Now, adding element 3- "GFG" at position 2
        list2.add(2, "GFG");

        // Display message only
        System.out.println(
                "list2 after adding GFG at position 2 :");

        // now print the updated List again
        // after inserting element at second position
        System.out.println(list2);

        // Float LinkedList

        // Creating new empty Float linked list
        list<Float> list3 = new list<>();

        // Display message only
        System.out.println(
                "\nFloat LinkedList created as list3");

        // Adding elements to the above List

        // Element 1 - 20.25
        list3.add(20.25f);
        // Element 2 - 50.42
        list3.add(50.42f);
        // Element 3 - 30.99
        list3.add(30.99f);

        // Display message only
        System.out.println(
                "list3 after adding 20.25, 50.42 and 30.99 :");

        // Print and display List elements
        System.out.println(list3);

        // Display message only
        System.out.println("Clearing list3 :");

        // Now.clearing this list using clear() method
        list3.clear();

        // Now, print and display the above list again
        System.out.println(list3);
    }
}
