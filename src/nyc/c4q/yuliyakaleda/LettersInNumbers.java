package nyc.c4q.yuliyakaleda;

import java.util.Scanner;

/**
 * C4Q, Access Code
 * Count number of letters in integers
 * Created by Yuliya Kaleda on 3/30/15.
 */

public class LettersInNumbers {

    public static int letterCount (String number) {
        int count = 0;
        for (int i =0; i < number.length(); i++) {
            //exclude whitespaces and hyphens, count just letters
            if (Character.isLetter(number.charAt(i))) {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Type in any number in letters: ");
        String userIn = in.nextLine();
        System.out.println("The number has " + letterCount(userIn) + " letters.");
    }
}
