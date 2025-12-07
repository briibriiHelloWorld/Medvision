import java.time.LocalDate;

public abstract class Medicine {
    private String name;
    private LocalDate expiryDate;
    private double price;
    private String usageInstructions;

    public Medicine(String name, LocalDate expiryDate, double price, String usageInstructions) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.price = price;
        this.usageInstructions = usageInstructions;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    public void showWarning() {
        Warning warning = new Warning();
        warning.displayWarning();
    }

    class Warning {
        public void displayWarning() {
            if (isExpired()) {
                System.out.println("⚠ WARNING: " + name + " is expired!");
            } else {
                System.out.println("✓ " + name + " is safe to use.");
            }
        }
    }

    public abstract void displayInfo();

    public String getName() { return name; }
    public double getPrice() { return price; }
    public LocalDate getExpiryDate() { return expiryDate; }
}
