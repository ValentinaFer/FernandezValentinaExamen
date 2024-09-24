package com.softulp.fernandezvalentinaexamen.modelos;

public class Producto {
    private int code;
    private String description;
    private double price;
    private int stock;

    public Producto(int code, String description, double price, int stock) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
