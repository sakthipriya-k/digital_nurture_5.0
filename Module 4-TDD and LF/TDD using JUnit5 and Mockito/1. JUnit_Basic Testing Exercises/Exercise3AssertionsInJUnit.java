/*
Exercise 3: Assertions in JUnit

Objective:
Demonstrate assertion concepts using Java.
*/

public class Exercise3AssertionsInJUnit {

    public static void main(String[] args) {

        int expected = 100;

        int actual = 50 + 50;

        if (expected == actual) {

            System.out.println(
                    "Assertion Passed"
            );

        } else {

            System.out.println(
                    "Assertion Failed"
            );

        }

    }

}