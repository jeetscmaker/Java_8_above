package org.jk;

import java.util.Comparator;

public class User implements Comparator<User> {
    private int id;
    private String name;
    private double salary;

    public User(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compare(User o1, User o2) {
        if (o1.getName().equalsIgnoreCase(o2.getName()))
            return o1.getId() - o2.getId();
        return 0;
    }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", name='" + name + '\'' + ", salary=" + salary + '}';
    }
}
