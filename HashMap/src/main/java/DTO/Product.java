package DTO;

//

import java.io.Serializable;

public class Product implements Valuable, Serializable {

    private String productCode, productName, supplier, unit;
    private double price;
    private float quantity;
    private boolean hasPromotion;

    public Product() {
    }

    public Product(String productCode, String productName, String supplier, double price, float quantity, boolean hasPromotion) {
        this.productCode = productCode.toUpperCase();
        this.productName = productName;
        this.supplier = supplier;
        this.price = price;
        this.quantity = quantity;
        this.hasPromotion = hasPromotion;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode.toUpperCase();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public boolean isHasPromotion() {
        return hasPromotion;
    }

    public void setHasPromotion(boolean hasPromotion) {
        this.hasPromotion = hasPromotion;
    }

    @Override
    public String toString() {
        return String.format("| %5s | %-20s | %6.1f | %8.0f | %6.0f |", this.productCode,
                this.productName, this.price, this.quantity, this.value());
    }

    @Override
    public float value() {
        return (float) (this.price * this.quantity);
    }

    @Override
    public float vat() {
        return 0.08f * this.value();
    }

    @Override
    public float promotion() {
        return this.hasPromotion ? 0.15f * this.value() : 0;
    }

}
