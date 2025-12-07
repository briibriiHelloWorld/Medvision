

import java.util.List;

public class MedicineScanner implements Scannable {

    private Repository<Medicine> repository;

    public MedicineScanner(Repository<Medicine> repository) {
        this.repository = repository;
    }

    @Override
    public void scan(String medicineName) {
        List<Medicine> found = repository.search(m ->
                m.getName().equalsIgnoreCase(medicineName));

        if (found.isEmpty()) {
            System.out.println("❌ Medicine not found!");
        } else {
            found.forEach(m -> {
                m.displayInfo();
                m.showWarning();
            });
        }
    }
}
