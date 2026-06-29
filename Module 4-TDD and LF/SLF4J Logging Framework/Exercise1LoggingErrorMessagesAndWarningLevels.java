/*
Exercise 1:
Logging Error Messages and Warning Levels

Objective:
Demonstrate warning and error logging.
*/

public class Exercise1LoggingErrorMessagesAndWarningLevels {

    static void logInfo(String message) {

        System.out.println(
                "[INFO] " + message
        );

    }

    static void logWarning(String message) {

        System.out.println(
                "[WARNING] " + message
        );

    }

    static void logError(String message) {

        System.out.println(
                "[ERROR] " + message
        );

    }

    public static void main(String[] args) {

        logInfo(
                "Application Started"
        );

        logWarning(
                "Low Memory Warning"
        );

        logError(
                "Database Connection Failed"
        );

        logInfo(
                "Application Closed"
        );

    }

}