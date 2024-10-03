import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Account Mario = new Account();
        Operations B = new Operations();

        String[] arr;

        arr = Mario.custGen("Mario", "0");

        System.out.println("Name: " + arr[0] + "  acc: " + arr[1] + "  balance: " + arr[2]);

        B.deposit(sc.nextInt());
        arr = Tracker.accts.get(sc.nextInt());

        System.out.println(arr[1] + "  new balance: " + arr[2]);


    }
}