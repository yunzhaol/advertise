// === controller/AdvertiserController.java ===
import java.util.Scanner;

public class AdvertiserController {
    private final Scanner scanner = new Scanner(System.in);

    public void menu(Advertiser advertiser) {
        while (true) {
            System.out.println("1. Create Ad\n2. View Ads\n3. Back");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                System.out.print("Ad title: ");
                String title = scanner.nextLine();
                System.out.print("Budget: ");
                double budget = Double.parseDouble(scanner.nextLine());
                Ad ad = new Ad(title, budget);
                advertiser.getAds().add(ad);
                System.out.println("Ad created.");
            } else if (input.equals("2")) {
                for (Ad ad : advertiser.getAds()) {
                    System.out.println("Ad: " + ad.getTitle() + " | Clicks: " + ad.getClicks());
                }
            } else {
                break;
            }
        }
    }
}