import java.util.HashMap;

public class Tracker {

      public static  HashMap<Integer, String[]> accts = new HashMap<>();

      public static int custAmt()       {
            System.out.println(accts.size());
            return accts.size();
      }




}

