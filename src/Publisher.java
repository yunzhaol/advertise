// === entity/Publisher.java ===
import java.util.ArrayList;
import java.util.List;

public class Publisher extends User {
    private final List<AdSlot> slots = new ArrayList<>();

    public Publisher(String username, String password) {
        super(username, password);
    }

    public List<AdSlot> getSlots() {
        return slots;
    }
}