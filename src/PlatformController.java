import java.util.Scanner;

public class PlatformController {
    private final UserService userService = new UserService();
    private final AdvertiserController advertiserController = new AdvertiserController();
    private final PublisherController publisherController = new PublisherController();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Ad Platform");
            System.out.println("1. Register\n2. Login\n3. Exit");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                userService.register();
            } else if (input.equals("2")) {
                User user = userService.login();
                if (user != null) {
                    if (user instanceof Advertiser) {
                        advertiserController.menu((Advertiser) user);
                    } else if (user instanceof Publisher) {
                        publisherController.menu((Publisher) user);
                    }
                }
            } else {
                break;
            }
        }
    }
}
