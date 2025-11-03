package com.codefromscratch.inventoryassignment.controller;

import com.codefromscratch.inventoryassignment.model.Bicycle;
import com.codefromscratch.inventoryassignment.service.BicycleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/bicycle")
public class InventoryController {
   private final BicycleService bicycleService;
   public InventoryController(BicycleService bicycleService) { this.bicycleService = bicycleService; }

    @GetMapping("/{id}")
    public Bicycle getBicycleId(@PathVariable Long id) {
        return bicycleService.findBicycle(id);
    }
    @GetMapping("/all")
    public List<Bicycle> all() {
        return bicycleService.findAllBicycles();
    }
    @GetMapping("/inStock")
    public List<Bicycle> inStock() {
       ArrayList<Bicycle> list = new ArrayList<>();
       for (Bicycle bicycle : bicycleService.findAllBicycles()) {
           if (bicycle.getInStock() > 0 ) {
               list.add(bicycle);
           }
       }
       return list;
    }
    @DeleteMapping("/removeBicycle/{id}")
    public ResponseEntity<String> removeBicycle(@PathVariable Long id) {
        bicycleService.deleteBicycle(id);
        return ResponseEntity.ok("Bicycle id " + id + " got removed.");
    }
    @PostMapping("/addBicycle")
    public ResponseEntity<Bicycle> addBicycle(@RequestBody Bicycle bicycle) {
       return ResponseEntity.ok(bicycleService.create(bicycle));
    }

}
