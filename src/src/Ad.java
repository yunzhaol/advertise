// === entity/Ad.java ===
public class Ad {
    private final String title;
    private final double budget;
    private int clicks;

    public Ad(String title, double budget) {
        this.title = title;
        this.budget = budget;
        this.clicks = 0;
    }

    public String getTitle() {
        return title;
    }

    public double getBudget() {
        return budget;
    }

    public int getClicks() {
        return clicks;
    }

    public void click() {
        clicks++;
    }
}