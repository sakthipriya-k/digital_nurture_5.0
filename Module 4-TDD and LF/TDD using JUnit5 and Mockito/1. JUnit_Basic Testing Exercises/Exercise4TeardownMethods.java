/*
Exercise 4:
Teardown Methods

Objective:
Demonstrate setup and teardown concept.
*/

public class Exercise4TeardownMethods {

    static void setup() {

        System.out.println(
                "Setup Completed"
        );

    }

    static void executeTest() {

        System.out.println(
                "Executing Test"
        );

    }

    static void teardown() {

        System.out.println(
                "Resources Released"
        );

    }

    public static void main(String[] args) {

        // Setup
        setup();

        // Execute
        executeTest();

        // Teardown
        teardown();

    }

}