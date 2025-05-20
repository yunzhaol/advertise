// === controller/PublisherController.java ===
import java.util.Scanner;

public class PublisherController {
    private final Scanner scanner = new Scanner(System.in);

    public void menu(Publisher publisher) {
        while (true) {
            System.out.println("1. Add Ad Slot\n2. View Slots\n3. Back");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                System.out.print("Slot description: ");
                String desc = scanner.nextLine();
                System.out.print("Price per click: ");
                double price = Double.parseDouble(scanner.nextLine());
                AdSlot slot = new AdSlot(desc, price);
                publisher.getSlots().add(slot);
                System.out.println("Ad slot added.");
            } else if (input.equals("2")) {
                for (AdSlot slot : publisher.getSlots()) {
                    System.out.println("Slot: " + slot.getDescription() + " | $/click: " + slot.getPricePerClick());
                }
            } else {
                break;
            }
        }
    }
}