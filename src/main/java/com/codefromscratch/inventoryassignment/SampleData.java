package com.codefromscratch.inventoryassignment;

import com.codefromscratch.inventoryassignment.model.Bicycle;
import com.codefromscratch.inventoryassignment.model.Manufacturer;
import com.codefromscratch.inventoryassignment.repository.InventoryRepo;
import com.codefromscratch.inventoryassignment.repository.ManufacturerRepo;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleData implements CommandLineRunner {

    private final InventoryRepo inventoryRepo;
    private final ManufacturerRepo manufacturerRepo;
    private final Faker faker = new Faker();

    public SampleData(InventoryRepo inventoryRepo, ManufacturerRepo manufacturerRepo) {
        this.inventoryRepo = inventoryRepo;
        this.manufacturerRepo = manufacturerRepo;
    }

    @Override
    public void run(String... args) {
        // Avoid adding duplicates every restart
        if (inventoryRepo.count() > 0) return;

        for (int i = 0; i < 50; i++) {
            // --- create Manufacturer first ---
            Manufacturer m = new Manufacturer();
            m.manufacturerName = faker.company().name();
            m.website = faker.internet().url();
            m.phoneNumber = faker.number().numberBetween(10000000, 99999999);
            manufacturerRepo.save(m);

            // --- create Bicycle and link Manufacturer ---
            Bicycle b = new Bicycle();
            b.setName(faker.commerce().productName());
            b.setColor(faker.color().name());
            b.setModel("BIKE-" + faker.number().digits(3));
            b.setInStock(faker.number().numberBetween(0, 20));
            b.setManufacturer(m);

            inventoryRepo.save(b);
        }

    }
}
