public class Authenticator {

    static int tempAuth;

    public static void authStore(int acctNum)   {
        tempAuth = acctNum;
    }

    public static int authGet()    {
        return tempAuth;
    }

    public static void authWipe()   {
        tempAuth = 0;
    }
}
