import java.io.*;
import java.util.*;

class SetManipulation {
  public static void main(String[] args) {

    Set<Integer> set1 = new HashSet<Integer>();
    set1.add(1);
    set1.add(2);
    set1.add(3);

    Set<Integer> set2 = new HashSet<Integer>();
    set2.add(2);
    set2.add(3);
    set2.add(4);

    //retainAll, will modify the content of set1. 
    // we need to create a copy of set1 if we want to keep set1 unchanged
    Set<Integer> intersection = new HashSet<Integer>(set1);
    intersection.retainAll(set2);
    System.out.println("Intersection Set: " + intersection);

    //addAll, will modify the content of set1. 
    // we need to create a copy of set1 if we want to keep set1 unchanged
    Set<Integer> union = new HashSet<Integer>(set1);
    union.addAll(set2);
    System.out.println("Union Set: " + union);

    //.removeAll, will modify the content of set1. 
    // we need to create a copy of set1 if we want to keep set1 unchanged
    Set<Integer> difference = new HashSet<Integer>(set1);
    difference.removeAll(set2);
    System.out.println("Difference Set: " + difference);

  }
}
