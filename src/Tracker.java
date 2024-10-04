import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Tracker {

      public static ObjectMapper obMap = new ObjectMapper();
      public static  HashMap<Integer, String[]> accts = new HashMap<>();

      public static void getAccts() throws IOException {
            accts = obMap.readValue(new File("C:\\Users\\Josh\\.IntelliJ\\bank\\JSON_Data\\account.json"), new TypeReference<HashMap<Integer, String[]>>(){});
            String[] arr = accts.get(199747281);
            System.out.println(arr[1]);
      }

      public static int custAmt()       {
            System.out.println(accts.size());
            return accts.size();
      }

      public static void updateBal() throws IOException {
            obMap.writeValue(new File("C:\\Users\\Josh\\.IntelliJ\\bank\\JSON_Data\\account.json"), Tracker.accts);
      }




}

