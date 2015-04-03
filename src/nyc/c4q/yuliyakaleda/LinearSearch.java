package nyc.c4q.yuliyakaleda;

import java.util.ArrayList;

/**
 * C4Q, Access Code
 * Search for a unit in an ArrayList and return the first index of it.
 * Created by Yuliya Kaleda on 3/30/15.
 */
public class LinearSearch {

    public static void main(String[] args) {
        //create a test ArrayList
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(2);

        // search for an int in the created ArrayList
        System.out.println(search(test, 2));
    }

     public static int search (ArrayList alist, int x) {

         //check if alist has int x
        if (alist.contains(x)) {
            return alist.indexOf(x);
        }
         //if alist does not have x, return -1
        return -1;
    }
}
