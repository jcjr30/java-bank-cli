import java.io.File;
import java.io.IOException;
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
        Random rand = new Random();


        //Generates random 10 digit number, repeats until unique
        do {
            acctNum = Integer.parseInt(dF.format(rand.nextInt(999999999)));
        }
        while (Tracker.accts.containsKey(acctNum));

        if (!Tracker.accts.containsKey(acctNum))   {
            return acctNum;
        }
            return 1;
    }

    //Generates a new customers' acct#, gives them a balance based
    //on starting deposit, and returns an array with said info + name
    public String[] custGen(String name, String balance) throws IOException {
        this.name = name;
        this.balance = balance;
        Integer acctNum = acctNum();

        String[] arr = new String[3];

        arr[0] = name;
        arr[1] = acctNum.toString();
        arr[2] = balance;
        Tracker.accts.put(acctNum,arr);
        Tracker.obMap.writeValue(new File("C:\\Users\\Josh\\.IntelliJ\\bank\\JSON_Data\\account.json"), Tracker.accts);

        return arr;

    }

}
