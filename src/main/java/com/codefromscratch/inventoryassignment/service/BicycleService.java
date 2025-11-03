package com.codefromscratch.inventoryassignment.service;

import com.codefromscratch.inventoryassignment.model.Bicycle;
import com.codefromscratch.inventoryassignment.repository.InventoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicycleService {
    private final InventoryRepo repo;
    public BicycleService(InventoryRepo repo) {
        this.repo = repo;
    }

    public Bicycle create(Bicycle bicycle) {
        return repo.save(bicycle);
    }

    public Bicycle findBicycle(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Bicycle> findAllBicycles() {
        return repo.findAll();
    }

    public void deleteBicycle(Long id) {
        repo.deleteById(id);
    }

    public Bicycle updateBicycle(Bicycle bicycle) {
        return repo.save(bicycle);
    }




}
