import java.io.IOException;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        //Gets and adds accounts from JSON file
        Tracker.getAccts();

        for (boolean runAgain = true; runAgain;) {
            boolean isRunning = true;
            runAgain = false;

            int response = GUI.welcome();

            do {
                if (response == 1) {
                    response = GUI.createAcct();
                } else if (response == 2) {
                    response = GUI.accessAcct();
                } else if (response == 3) {
                    do {
                        response = GUI.operatorGUI();
                    } while (response == 3);
                    if (response == 5) {
                        System.out.println("Thank you have a good day!");
                        Authenticator.authWipe();
                        System.out.println("You have been successfully logged out!");
                        isRunning = false;

                        System.out.println("Press 1 to close");
                        System.out.println("Press 2 to restart");
                        if (sc.nextInt() == 2)  {
                            runAgain = true;
                        }

                    }
                }
            } while (isRunning);
        }
    }
    }
