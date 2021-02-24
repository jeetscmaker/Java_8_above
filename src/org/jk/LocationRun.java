package org.jk;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LocationRun {
    public static void main(String[] args) {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("Boston", "MA", "021567"));
        locations.add(new Location("Baltimore", "CA", "521567"));
        locations.add(new Location("Baltimore", "BA", "521567"));
        locations.add(new Location("Baltimore", "BA", "121567"));
        locations.add(new Location("London", "UK", "276453"));
        locations.add(new Location("NewYork", "NY", "125427"));
        locations.add(new Location("Dallas", "TX", "081517"));
        locations.add(new Location("King of Prussia", "PA", "765409"));
        locations.add(new Location("San Francisco", "CA", "459823"));

        locations.forEach(l -> System.out.println(l.FormatString()));

        List<Location> li = locations.stream()
                .filter(l -> !l.getZipCode().startsWith("0"))
                .sorted(Comparator.comparing(Location::getCity)
                .thenComparing(Location::getState)
                .thenComparing(loc -> Integer.parseInt(loc.getZipCode())))
                .collect(Collectors.toList());
        System.out.println("====================================================================");
        li.forEach(l -> System.out.println(l.FormatString()));
    }
}
