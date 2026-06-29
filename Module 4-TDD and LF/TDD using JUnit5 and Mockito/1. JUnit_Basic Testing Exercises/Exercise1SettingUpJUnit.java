/*
Exercise 1: Setting Up JUnit

Objective:
Create a simple Java program and verify output.
*/

class Calculator {

    public int add(int firstNumber, int secondNumber) {

        return firstNumber + secondNumber;

    }

}

public class Exercise1SettingUpJUnit {

    public static void main(String[] args) {

        Calculator calculator =
                new Calculator();

        int result =
                calculator.add(20, 30);

        System.out.println(
                "Addition Result: " +
                result
        );

    }

}