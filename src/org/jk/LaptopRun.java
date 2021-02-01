package org.jk;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LaptopRun {
    public static void main(String[] args) {
        List<Laptop> list = new ArrayList<>();
        Laptop l1 = new Laptop("6");
        Laptop l2 = new Laptop("8");
        Laptop l3 = new Laptop("4");
        Laptop l4 = new Laptop("2");
        Laptop l5 = new Laptop("32");
        Laptop l6 = new Laptop("16");
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        list.add(l5);
        list.add(l6);
        System.out.println("Before sorting Laptop list is:");
        list.stream().forEach(System.out::println);
        System.out.println("After sorting Laptop list is:");
        List<Laptop> l = list.stream()
                .sorted(((o1, o2) -> Integer.parseInt(o1.getRam()) - Integer.parseInt(o2.getRam())))
                .collect(Collectors.toList());
        l.forEach(System.out::println);
    }
}

class Laptop {
    private String ram;

    Laptop(String ram) {
        this.ram = ram;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "ram='" + ram + '\'' +
                '}';
    }
}
