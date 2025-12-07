

import java.time.LocalDate;

public class Syrup extends Medicine {
    private double volume;

    public Syrup(String name, LocalDate expiryDate, double price, String usageInstructions, int volume) {
        super(name, expiryDate, price, usageInstructions);
        this.volume = volume;
    }

    @Override
    public void displayInfo() {
        System.out.println("Syrup: " + getName() + " | Volume: " + volume + "ml | Price: $" + getPrice());
    }
}
