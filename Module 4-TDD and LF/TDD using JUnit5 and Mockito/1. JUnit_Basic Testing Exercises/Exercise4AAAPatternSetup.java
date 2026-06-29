/*
Exercise 4:
Arrange – Act – Assert (AAA) Pattern
Test Fixtures and Setup

Objective:
Demonstrate the AAA testing approach.
*/

class Student {

    public int calculateTotal(int mark1, int mark2) {

        return mark1 + mark2;

    }

}

public class Exercise4AAAPatternSetup {

    public static void main(String[] args) {

        // Arrange
        Student student =
                new Student();

        int expected = 90;

        // Act
        int actual =
                student.calculateTotal(40, 50);

        // Assert
        if (expected == actual) {

            System.out.println(
                    "Test Passed"
            );

        } else {

            System.out.println(
                    "Test Failed"
            );

        }

    }

}