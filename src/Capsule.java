import java.time.LocalDate;

public class Capsule extends Medicine {
    private String size;

    public Capsule(String name, LocalDate expiryDate, double price, String usageInstructions, String size) {
        super(name, expiryDate, price, usageInstructions);
        this.size = size;
    }

    @Override
    public void displayInfo() {
        System.out.println("Capsule: " + getName() + " | Size: " + size + " | Price: $" + getPrice());
    }
}
