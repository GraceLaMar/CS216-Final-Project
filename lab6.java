import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * lab6.java
 * fall 2025
 * 
 * Grace La Mar
 * 
 * convert String to double using Java Collection Stack and Queue
 */

public class lab6 {
    public static void main(String[] args) {

        // test cases - add x3 additional cases here
        test("6", 6.0);
        test("7,000,000", 7000000.0);
        test(" $$$7 000 000 ", 7000000.0);
        test("$5,678.13 ", 5678.13);
        test("$0.25", 0.25);
        test(" -$.25", -0.25);
        test("-8.96", -8.96);

        // *** add three additional test cases here
        test("$$$265,372", 265372.0);
        test("37,1,7657,4", 37176574.0);
        test("$$$4,,84", 484);
    }// main

    private static double toDouble(String a) {

        double answer = 0.0;

        Stack<Integer> s = new Stack<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();

        boolean decimalFound = false; // *** may or may not use this approach
        boolean negative = false; // *** may or may not use this approach

        // *** add code here ***

        a = a.trim();
            
        if (a.contains("-")) {
            negative = true;
        }

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);

            if (Character.isDigit(c)) {
                int digit = c - '0';
                if (!decimalFound)
                    s.push(digit);
                else
                    q.add(digit);
            } else if (c == '.') {
                decimalFound = true;
            } else {

            }

        }
        
        double place = 1;
        while (!s.isEmpty()) {
            int d = s.pop();
            answer += d * place;
            place *= 10;
        }

        place = 10;
        while (!q.isEmpty()) {
            int d = q.remove();
            answer += d / place;
            place *= 10;
        }

        if (negative)
            answer = -answer;

        return answer;



    }// toDouble

    // test method
    private static void test(String s, double expected) {

        double actual = toDouble(s);

        if (actual == expected)
            System.out.printf("Passed: %15s => %15f\n", s, actual);
        else
            System.out.printf(" Error: %15s => %15f   Expected: %15f\n", s, actual, expected);

    } // test

}// class
