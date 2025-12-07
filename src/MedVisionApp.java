import java.time.LocalDate;
import java.util.Scanner;

public class MedVisionApp {
    private static Repository<Medicine> repo = new Repository<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        loadSampleMedicines(); // sample data

        while (true) {
            System.out.println("\n=== MedVision Menu ===");
            System.out.println("1. View All Medicines");
            System.out.println("2. Search Medicine by Name");
            System.out.println("3. View Expired Medicines");
            System.out.println("4. Sort by Expiry Date");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewAll();
                    break;
                case 2:
                    searchByName();
                    break;
                case 3:
                    viewExpired();
                    break;
                case 4:
                    sortByExpiry();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void viewAll() {
        for (Medicine m : repo.getAll()) {
            m.displayInfo();
            m.showWarning();
        }
    }

    private static void searchByName() {
        System.out.print("Enter medicine name: ");
        String name = scanner.nextLine();

        MedicineScanner ms = new MedicineScanner(repo);
        ms.scan(name);

        var found = repo.search(m -> m.getName().equalsIgnoreCase(name));
        if (found.isEmpty()) System.out.println("Medicine not found!");
        else {
            found.forEach(Medicine::displayInfo);
        }
    }

    private static void viewExpired() {
        var expired = repo.search(Medicine::isExpired);
        if (expired.isEmpty())
            System.out.println("No expired medicines!");
        else
            expired.forEach(Medicine::displayInfo);
    }

    private static void sortByExpiry() {
        repo.getAll().sort((a, b) ->
                a.getExpiryDate().compareTo(b.getExpiryDate()));
        System.out.println("Sorted by expiry date!");
        viewAll();
    }

    private static void loadSampleMedicines() {
        repo.add(new Tablet("Paracetamol", LocalDate.of(2026, 5, 10), 5.0, "After meals", 10));
        repo.add(new Syrup("Cough Syrup", LocalDate.of(2024, 2, 10), 7.5, "Shake well", 250));
        repo.add(new Capsule("Vitamin D", LocalDate.of(2025, 11, 1), 12.0, "Morning only", "Large"));
        // 50 Common Medicines - Mixed Expiry Dates
repo.add(new Tablet("Paracetamol", LocalDate.of(2026, 5, 10), 5.0, "Take after meals", 10));
repo.add(new Tablet("Ibuprofen", LocalDate.of(2027, 3, 15), 8.5, "Take with water", 20));
repo.add(new Tablet("Aspirin", LocalDate.of(2024, 11, 25), 6.0, "Avoid empty stomach", 15));
repo.add(new Tablet("Metformin", LocalDate.of(2025, 9, 12), 4.5, "Twice daily", 30));
repo.add(new Tablet("Losartan", LocalDate.of(2023, 6, 1), 10.0, "Once daily for BP", 25));
repo.add(new Tablet("Amlodipine", LocalDate.of(2027, 1, 2), 12.0, "For high blood pressure", 20));
repo.add(new Tablet("Acetaminophen", LocalDate.of(2028, 4, 8), 6.5, "Every 6 hours", 18));
repo.add(new Tablet("Naproxen", LocalDate.of(2023, 12, 31), 9.0, "Pain relief", 20));
repo.add(new Tablet("Prednisone", LocalDate.of(2026, 10, 9), 11.0, "With food", 14));
repo.add(new Tablet("Glipizide", LocalDate.of(2022, 7, 14), 7.0, "Diabetes medication", 25));

repo.add(new Capsule("Amoxicillin", LocalDate.of(2025, 3, 5), 10.0, "3 times daily", "Medium"));
repo.add(new Capsule("Azithromycin", LocalDate.of(2023, 11, 20), 14.0, "Once daily", "Medium"));
repo.add(new Capsule("Omeprazole", LocalDate.of(2027, 6, 18), 13.0, "Before breakfast", "Small"));
repo.add(new Capsule("Doxycycline", LocalDate.of(2024, 1, 18), 12.5, "With water", "Large"));
repo.add(new Capsule("Tetracycline", LocalDate.of(2028, 9, 9), 16.0, "Avoid sunlight exposure", "Medium"));
repo.add(new Capsule("Clindamycin", LocalDate.of(2024, 8, 23), 15.0, "For bacterial infection", "Small"));
repo.add(new Capsule("Pantoprazole", LocalDate.of(2023, 2, 7), 13.0, "GERD treatment", "Medium"));
repo.add(new Capsule("Loratadine", LocalDate.of(2028, 12, 4), 7.5, "Anti-allergy", "Small"));
repo.add(new Capsule("Cetirizine", LocalDate.of(2025, 10, 11), 6.5, "For allergies", "Small"));
repo.add(new Capsule("Ranitidine", LocalDate.of(2022, 9, 3), 9.5, "Stomach acid control", "Medium"));

repo.add(new Syrup("Cough Syrup", LocalDate.of(2023, 11, 1), 7.0, "Before sleep", 100));
repo.add(new Syrup("Montelukast", LocalDate.of(2027, 2, 10), 9.0, "Asthma control", 150));
repo.add(new Syrup("Antacid Liquid", LocalDate.of(2026, 6, 7), 5.5, "Acid relief", 200));
repo.add(new Syrup("Salbutamol", LocalDate.of(2023, 5, 10), 8.0, "For wheezing", 120));
repo.add(new Syrup("Acetylcysteine", LocalDate.of(2025, 7, 14), 10.0, "Mucus thinner", 100));
repo.add(new Syrup("Vitamin C", LocalDate.of(2027, 8, 5), 4.0, "Immune booster", 250));
repo.add(new Syrup("Zinc Supplement", LocalDate.of(2024, 4, 19), 6.5, "Health supplement", 200));
repo.add(new Syrup("Paragyl", LocalDate.of(2023, 1, 20), 5.5, "For stomach issues", 180));
repo.add(new Syrup("Glycerin Syrup", LocalDate.of(2028, 3, 29), 7.5, "Soothing relief", 100));
repo.add(new Syrup("ORS Solution", LocalDate.of(2022, 8, 12), 3.0, "Hydration solution", 500));

repo.add(new Tablet("Hydroxyzine", LocalDate.of(2027, 9, 22), 8.0, "Anxiety treatment", 12));
repo.add(new Tablet("Clopidogrel", LocalDate.of(2024, 12, 15), 18.0, "Blood thinner", 15));
repo.add(new Tablet("Atorvastatin", LocalDate.of(2026, 9, 10), 20.0, "Cholesterol control", 30));
repo.add(new Tablet("Bisacodyl", LocalDate.of(2023, 8, 4), 6.0, "Constipation relief", 20));
repo.add(new Tablet("Fexofenadine", LocalDate.of(2027, 11, 12), 7.5, "Anti-histamine", 28));
repo.add(new Capsule("Metoclopramide", LocalDate.of(2025, 1, 5), 6.0, "Nausea treatment", "Medium"));
repo.add(new Capsule("Minocycline", LocalDate.of(2022, 10, 20), 12.0, "Acne treatment", "Small"));
repo.add(new Capsule("Soframycin", LocalDate.of(2028, 3, 30), 14.0, "Bacterial infections", "Medium"));
repo.add(new Syrup("Lactulose", LocalDate.of(2024, 6, 14), 8.5, "Constipation", 300));
repo.add(new Syrup("Ambroxol", LocalDate.of(2026, 11, 19), 6.5, "Expectorant", 150));

repo.add(new Tablet("Cholecalciferol", LocalDate.of(2028, 10, 30), 10.0, "Vitamin D supplement", 60));
repo.add(new Tablet("Montair", LocalDate.of(2023, 3, 22), 6.0, "Anti-allergic", 20));
repo.add(new Capsule("Tranexamic Acid", LocalDate.of(2025, 5, 11), 18.0, "Blood clot control", "Small"));
repo.add(new Capsule("Spironolactone", LocalDate.of(2027, 12, 29), 14.0, "BP/Heart failure treatment", "Large"));
repo.add(new Syrup("Bromhexine", LocalDate.of(2022, 11, 10), 5.0, "Cough relief", 120));
repo.add(new Syrup("Azithro Syrup", LocalDate.of(2026, 4, 8), 11.0, "Bacterial infections", 100));
repo.add(new Syrup("Gaviscon", LocalDate.of(2027, 8, 18), 12.5, "Acid reflux relief", 200));
repo.add(new Tablet("Folic Acid", LocalDate.of(2023, 10, 10), 5.0, "Supplement", 60));
repo.add(new Capsule("Gabapentin", LocalDate.of(2028, 12, 20), 22.0, "Nerve pain", "Medium"));
repo.add(new Tablet("Levothyroxine", LocalDate.of(2026, 7, 5), 9.0, "Thyroid medication", 90));

    }
}
