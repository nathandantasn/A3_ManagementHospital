package com.management.hospital.managementhospital.dtos;

import javax.validation.constraints.Size;

public class ProductDto {

    @Size(max = 130)
    private String name;

    @Size(max = 256)
    private String description;

    private String brand;

    private double price;

    @Size(max = 10)
    private String date;

    @Size(max = 11)
    private String lote;

    private int skuQuantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getSkuQuantity() {
        return skuQuantity;
    }

    public void setSkuQuantity(int skuQuantity) {
        this.skuQuantity = skuQuantity;
    }

}
