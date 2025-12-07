
import java.time.LocalDate;

public class Tablet extends Medicine {
    private int quantity;

    public Tablet(String name, LocalDate expiryDate, double price, String usageInstructions, int quantity) {
        super(name, expiryDate, price, usageInstructions);
        this.quantity = quantity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Tablet: " + getName() + " | Qty: " + quantity + " | Price: $" + getPrice());
    }
}
