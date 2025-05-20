// === service/UserService.java ===
import java.util.*;

public class UserService {
    private final List<User> users = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void register() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Are you an advertiser (a) or publisher (p)?: ");
        String role = scanner.nextLine();
        User user = role.equals("a") ? new Advertiser(username, password) : new Publisher(username, password);
        users.add(user);
        System.out.println("Registration successful!");
    }

    public User login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        System.out.println("Login failed");
        return null;
    }

    public void registerDefaultUsers() {
        users.add(new Advertiser("admin", "1234"));
        users.add(new Publisher("pub", "1234"));
    }

    public User login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

}