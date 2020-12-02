package org.jk;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
 * 1)Convert all map values into the list
 * 2)print the max length string from above list
 * 3)Extract all the strings from above list which contains word car
 */

class Solution {
  public static void main(String[] args) {
    Map<String, String> phrases = new HashMap<>();
    phrases.put("10001", "Vehicle");
    phrases.put("10024", "CAr Race");
    phrases.put("10034", "caramel chocolate is good adadadadadadd a dadasd");
    phrases.put("34567", "BMW Cars have Garmin GPS");
    phrases.put("22333", "Children Daycare");
    phrases.put("33434", "Navionics");
    phrases.put("33442", "Garmin International");
    
    List<String> list = new ArrayList<String>(phrases.values());
    
    Collections.sort(list, Comparator.comparing(String::length).reversed());
    System.out.println(list.get(0));
    
    List<String> l = list.stream().map(s-> s.toLowerCase())
      .filter(s -> s.contains("car"))
      .collect(Collectors.toList());
    
      System.out.println(l);
    
  }
}
