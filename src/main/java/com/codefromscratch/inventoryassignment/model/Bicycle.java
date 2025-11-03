package com.codefromscratch.inventoryassignment.model;
import jakarta.persistence.*;

@Entity
public class Bicycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String model;

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    String color;
    String name;
    int inStock;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;
    @Override
    public String toString() {
        return "{id:" + id + ", mode:'" + model + "', color:'" + color + "', name:'" + name + "', inStock:" + inStock + "}";
    }
}
