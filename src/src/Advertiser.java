// === entity/Advertiser.java ===
import java.util.ArrayList;
import java.util.List;

public class Advertiser extends User {
    private final List<Ad> ads = new ArrayList<>();

    public Advertiser(String username, String password) {
        super(username, password);
    }

    public List<Ad> getAds() {
        return ads;
    }
}
