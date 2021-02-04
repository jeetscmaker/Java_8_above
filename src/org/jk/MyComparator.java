package org.jk;

public class MyComparator implements java.util.Comparator<Laptop> {
    @Override
    public int compare(Laptop l1, Laptop l2) {
        return Integer.parseInt(l1.getRam()) - Integer.parseInt(l2.getRam());
    }
}
