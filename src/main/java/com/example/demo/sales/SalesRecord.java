package com.example.demo.sales;

public class SalesRecord {

    private String segment;
    private String country;
    private String product;
    private String discountBand;
    private double unitsSold;
    private double manufacturingPrice;
    private double salePrice;
    private double grossSales;
    private double discounts;
    private double sales;

    // FULL constructor (used when reading CSV)
    public SalesRecord(String segment, String country, String product, String discountBand,
                       double unitsSold, double manufacturingPrice, double salePrice,
                       double grossSales, double discounts, double sales) {

        this.segment = segment;
        this.country = country;
        this.product = product;
        this.discountBand = discountBand;
        this.unitsSold = unitsSold;
        this.manufacturingPrice = manufacturingPrice;
        this.salePrice = salePrice;
        this.grossSales = grossSales;
        this.discounts = discounts;
        this.sales = sales;
    }

    // ===== GETTERS =====
    public String getSegment() {
        return segment;
    }

    public String getCountry() {
        return country;
    }

    public String getProduct() {
        return product;
    }

    public String getDiscountBand() {
        return discountBand;
    }

    public double getUnitsSold() {
        return unitsSold;
    }

    public double getManufacturingPrice() {
        return manufacturingPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public double getDiscounts() {
        return discounts;
    }

    public double getSales() {
        return sales;
    }

    // Helper: Net sale after discount (Gross Sales - Discounts)
    public double getNetSaleAmount() {
        return grossSales - discounts;
    }
}
