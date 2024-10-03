import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Random;
import java.text.DecimalFormat;

public class Account {

    private String balance;
    private String name;

    private Integer acctNum() {
        int acctNum;
        //Creates dF object to format account numbers
        DecimalFormat dF = new DecimalFormat("#########");
        //Creates Random object to create account numbers
        Random acct = new Random();

        //Generates random 10 digit number, repeats until unique
        do {
            acctNum = acct.nextInt(999999999);
        }
        while (Tracker.accts.containsValue(acctNum));

        if (!Tracker.accts.containsValue(acctNum))   {
            return acctNum;
        }
            return 1;
    }

    //Generates a new customers' acct#, gives them a balance based
    //on starting deposit, and returns an array with said info + name
    public String[] custGen(String name, String balance)   {
        this.name = name;
        this.balance = balance;
        Integer acctNum = acctNum();

        String[] arr = new String[3];

        arr[0] = name;
        arr[1] = acctNum.toString();
        arr[2] = balance;

        Tracker.accts.put(acctNum,arr);

        return arr;

    }

}
