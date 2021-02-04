package org.jk;

public class StringBuilderComparator implements java.util.Comparator<StringBuilder> {
    @Override
    public int compare(StringBuilder sb1, StringBuilder sb2) {
        return sb1.toString().compareTo(sb2.toString());
    }
}
