// === entity/AdSlot.java ===
public class AdSlot {
    private final String description;
    private final double pricePerClick;

    public AdSlot(String description, double pricePerClick) {
        this.description = description;
        this.pricePerClick = pricePerClick;
    }

    public String getDescription() {
        return description;
    }

    public double getPricePerClick() {
        return pricePerClick;
    }
}