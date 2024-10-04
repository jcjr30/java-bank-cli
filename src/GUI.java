import java.io.IOException;
import java.util.Scanner;

public class GUI {


    //Creates a welcome GUI with options
    public static int welcome()    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, Press _");
        System.out.println("1 - Create Account");
        System.out.println("2 - Access Existing Account");
        int response = sc.nextInt();

        if (response != 1 && response != 2) {
            do {
                System.out.println("Invalid response, please try again.");
                response = sc.nextInt();
            } while (response != 1 && response != 2);   {}
        }
        return response;
    }

    //Creates accounts with name, account number, and starting balance
    public static int createAcct() throws IOException {
        Account A = new Account();
        Scanner sc = new Scanner(System.in);
        String[] arr;

        System.out.println("Input name");
        String name = sc.next();

        System.out.println("Input initial deposit");
        Double initialDep = sc.nextDouble();

        arr = A.custGen(name, initialDep.toString());
        System.out.println("Here is your account number, do not lose it!");
        System.out.println(arr[1]);

        int tempAcctNum = Integer.parseInt(arr[1]);
        Authenticator.authStore(tempAcctNum);
        return 3;
    }

    //Allows access to an account using account number as a password
    public static int accessAcct() throws IOException  {
        Scanner sc = new Scanner(System.in);
        String[] arr;

        System.out.println("Please input 10-digit account number");
        int acctNumber = sc.nextInt();
        Authenticator.authStore(acctNumber);
        arr = Tracker.accts.get(acctNumber);


        System.out.println("Balance: $" + arr[2]);
        System.out.println("Name: " + arr[0]);
        System.out.println("Account #: " + arr[1]);
        return 3;
    }

    //Displays options after account is accessed
    public static int operatorGUI() throws IOException {
        Scanner sc = new Scanner(System.in);
        Operations A = new Operations();
        System.out.println("Would you like to withdraw, deposit, or end session?");
        System.out.println("1 - Withdraw");
        System.out.println("2 - Deposit");
        System.out.println("3 - End Session");
        int response = sc.nextInt();

        if (response != 1 && response != 2 && response != 3) {
            do {
                System.out.println("Invalid response, please try again.");
                response = sc.nextInt();
            } while (response != 1 && response != 2 && response != 3);  {}
        }
        else if (response == 1) {
            A.withdraw(Authenticator.authGet());
            return 3;
        }
        else if (response == 2) {
            A.deposit(Authenticator.authGet());
            return 3;
        }
        return 5;
    }

}
