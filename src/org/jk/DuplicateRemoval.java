package org.jk;

import java.util.*;

public class DuplicateRemoval {
    public static void main(String[] args) {
        List<String> listString = Arrays.asList("Ram", "Shyam", "Mohan", "Sohan", "Ram",
                "Shyam", "Robert", "Julia", "Shakespeare", "Mohan");

        // Duplicate removal for String (equals, hashcode already implemented for String).
        // String already implements equals and hashcode methods which provides inbuilt
        // duplicate removal while adding elements into a set.
        Set<String> setString = new HashSet<>(listString);
        System.out.println(setString);

        // Duplicate removal for Student objects.
        Student s1 = new Student("121", "Rohan", "Roy");
        Student s2 = new Student("122", "John", "Dcosta");
        Student s3 = new Student("123", "Robert", "King");
        Student s4 = new Student("124", "Ram", "Kumar");
        Student s5 = new Student("121", "Rohan", "Roy");
        Student s6 = new Student("126", "Rohan", "Roy");
        Student s7 = new Student("122", "John", "Dcosta");

        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        studentList.add(s6);
        studentList.add(s7);

        Set<Student> studentSet = new LinkedHashSet<>(studentList);
        System.out.println(studentSet);

        // sorting of students list
        Collections.sort(studentList);
        System.out.println(studentList);
    }
}

class Student implements Comparable<Student>{
    private String id;
    private String firstName;
    private String lastName;

    public Student(){}

    public Student(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student student) {
        return this.getId().compareTo(student.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getId().equals(student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
