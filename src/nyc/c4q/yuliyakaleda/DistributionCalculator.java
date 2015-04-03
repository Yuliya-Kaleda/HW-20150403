package nyc.c4q.yuliyakaleda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * C4Q, Access Code
 * Distribution Calculator
 * Created by Yuliya Kaleda on 3/30/15.
 */

public class DistributionCalculator {

    public static void main(String[] args) throws FileNotFoundException {
        //a test file is in HW-20150403/src/ (one level up)
        File textFile = new File("/Users/July/Desktop/accesscode/HW-20150403/src/TestDistributionCalculator.txt");

        ArrayList<String> result = calculate(textFile);
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static String readFile (File textFile) throws FileNotFoundException {

        Scanner in = new Scanner(textFile);

        //create a string that keeps the file content
        String line = "";
        while (in.hasNextLine()) {
            line += in.nextLine().toLowerCase();
        }
        return line;
    }

    public static ArrayList<String> distribution (TreeMap<Character, Double> treeMap, int countLetters) {
        ArrayList<String> result = new ArrayList<String>();

        for (Character key : treeMap.keySet()) {
            //calculate letter distribution
            double percent = (treeMap.get(key) / countLetters) * 100.00;
            result.add(key + " = " + String.format("%.2f", percent) + " %");
        }
        return result;
    }

    public static ArrayList<String> calculate(File textFile) throws FileNotFoundException {

        String line = readFile(textFile);
        //convert a file string to a charArray
        char[] charArray = line.toCharArray();

        //create a TreeMap with every char as a key and number of times it is used as a value
        TreeMap<Character, Double> countChars = new TreeMap<Character, Double>();
        int countLetters = 0;

        //check if a char is a letter and set its value
        for (Character c : charArray) {
            if (Character.isLetter(c)) {
                if (!countChars.containsKey(c)) {
                    countChars.put(c, 1.00);
                } else {
                    double value = countChars.get(c);
                    countChars.put(c, value + 1);
                }
                //keep track of the number of all letters
                countLetters++;
            }
        }
        return distribution(countChars, countLetters);
    }
}
