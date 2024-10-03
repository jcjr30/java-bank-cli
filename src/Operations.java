import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Operations {

    private Integer acctNum;

    public void deposit(int acctNum)    {
        Scanner sc = new Scanner(System.in);
        this.acctNum = acctNum;

        String[] arr = Tracker.accts.get(acctNum);
        System.out.println("How much would you like to deposit? $0.01-$10,000.00  ");
        double depositAmt = sc.nextDouble();

        Double tempBal = parseDouble(arr[2]) + depositAmt;

        arr[2] = tempBal.toString();

        //Test, maybe remove this.acctNum from accts prior to put
        Tracker.accts.put(this.acctNum, arr);

    }
}
