package com.codefromscratch.inventoryassignment.service;

import com.codefromscratch.inventoryassignment.model.Bicycle;
import com.codefromscratch.inventoryassignment.model.Manufacturer;
import com.codefromscratch.inventoryassignment.repository.InventoryRepo;
import com.codefromscratch.inventoryassignment.repository.ManufacturerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {
    private final ManufacturerRepo repo;
    public ManufacturerService(ManufacturerRepo repo) {
        this.repo = repo;
    }

    public Manufacturer create(Manufacturer manufacturer) {
        return repo.save(manufacturer);
    }

    public Manufacturer find(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Manufacturer> findAll() {
        return repo.findAll();
    }

    public void deleteManufacturer(Long id) {
        repo.deleteById(id);
    }

    public Manufacturer updateManufacturer(Manufacturer manufacturer) {
        return repo.save(manufacturer);
    }




}
