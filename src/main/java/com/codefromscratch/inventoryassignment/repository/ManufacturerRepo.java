package com.codefromscratch.inventoryassignment.repository;

import com.codefromscratch.inventoryassignment.model.Bicycle;
import com.codefromscratch.inventoryassignment.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepo extends JpaRepository <Manufacturer, Long> {

}
