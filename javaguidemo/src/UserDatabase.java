import java.util.HashMap;

public class UserDatabase {
    private static HashMap<String, String> users = new HashMap<>();

    public static void register(String email, String password) {
        users.put(email, password);
    }

    public static boolean authenticate(String email, String password) {
        return users.containsKey(email) && users.get(email).equals(password);
    }
}

