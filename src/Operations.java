import java.io.IOException;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Operations {

    private Integer acctNum;

    public void deposit(int acctNum) throws IOException {
        Scanner sc = new Scanner(System.in);
        this.acctNum = acctNum;

        String[] arr = Tracker.accts.get(acctNum);
        System.out.println("How much would you like to deposit? $0.01-$10,000.00");
        double depositAmt = sc.nextDouble();

        Double tempBal = parseDouble(arr[2]) + depositAmt;

        arr[2] = tempBal.toString();
        System.out.println("New Balance: $" + arr[2]);

        //Test, maybe remove this.acctNum from accts prior to put
        Tracker.accts.put(this.acctNum, arr);
        Tracker.updateBal();
    }

    public void withdraw(int acctNum) throws IOException {
        Scanner sc = new Scanner(System.in);
        this.acctNum = acctNum;

        String[] arr = Tracker.accts.get(acctNum);
        System.out.println("How much would you like to withdraw? $0.01-$10,000.00");
        Double withdrawAmt = sc.nextDouble();
        Double balance = parseDouble(arr[2]);

        boolean operate = false;

        while (operate == false) {
            if (balance >= withdrawAmt) {
                balance = balance - withdrawAmt;
                arr[2] = balance.toString();
                System.out.println("New Balance: $" + arr[2]);
                operate = true;
            } else {
                System.out.println("Error, please try again.");
                withdrawAmt = sc.nextDouble();
            }
        }
        Tracker.accts.put(this.acctNum, arr);
        Tracker.updateBal();
    }
}