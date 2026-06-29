/*
Exercise 2:
Verifying Interactions

Objective:
Verify whether a method interaction happened.
*/

class UserService {

    void login() {

        System.out.println(
                "Login Method Executed"
        );

    }

}

public class Exercise2VerifyingInteractions {

    public static void main(String[] args) {

        UserService service =
                new UserService();

        boolean interactionVerified =
                false;

        // Interaction
        service.login();

        interactionVerified =
                true;

        // Verification
        if (interactionVerified) {

            System.out.println(
                    "Interaction Verified"
            );

        } else {

            System.out.println(
                    "Interaction Not Verified"
            );

        }

    }

}