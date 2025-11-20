package com.example.demo.sales;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.io.InputStream;
import java.io.InputStreamReader;



//This class loads CSV data and performs multiple analytical operations using Streams, Lambdas and Functional programming.
public class SalesAnalysisService {

    // Reads CSV and maps each row into SalesRecord object
    public List<SalesRecord> loadCSV(String fileName) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

            if (inputStream == null) {
                throw new RuntimeException("File not found in classpath: " + fileName);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            return br.lines()
                    .skip(1)  // Skip header
                    .map(line -> line.split(","))
                    .map(arr -> new SalesRecord(
                            arr[0],
                            arr[1],
                            arr[2],
                            arr[3],
                            Double.parseDouble(arr[4]),
                            Double.parseDouble(arr[5]),
                            Double.parseDouble(arr[6]),
                            Double.parseDouble(arr[7]),
                            Double.parseDouble(arr[8]),
                            Double.parseDouble(arr[9])
                    ))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException("Unable to read CSV: " + e.getMessage());
        }
    }


    // Total sales = sum of final Sales column
    public double calculateTotalSales(List<SalesRecord> data) {
        return data.stream()
                .mapToDouble(SalesRecord::getSales)
                .sum();
    }

    // Sales by product (using net Sales column)
    public Map<String, Double> totalSalesByProduct(List<SalesRecord> data) {
        return data.stream()
                .collect(Collectors.groupingBy(
                        SalesRecord::getProduct,
                        Collectors.summingDouble(SalesRecord::getSales)
                ));
    }

    // Total units sold by country
    public Map<String, Double> totalUnitsByCountry(List<SalesRecord> data) {
        return data.stream()
                .collect(Collectors.groupingBy(
                        SalesRecord::getCountry,
                        Collectors.summingDouble(SalesRecord::getUnitsSold)
                ));
    }

    // Highest selling product based on total Sales column
    public String highestSellingProduct(List<SalesRecord> data) {
        return data.stream()
                .collect(Collectors.groupingBy(
                        SalesRecord::getProduct,
                        Collectors.summingDouble(SalesRecord::getSales)
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No Data");
    }


    // Average Sales by Country
    public Map<String, Double> averageSalesByCountry(List<SalesRecord> data) {
        return data.stream()
                .collect(Collectors.groupingBy(
                        SalesRecord::getCountry,
                        Collectors.averagingDouble(SalesRecord::getSales)
                ));
    }

    // Average Units Sold by Product
    public Map<String, Double> averageUnitsSoldByProduct(List<SalesRecord> data) {
        return data.stream()
                .collect(Collectors.groupingBy(
                        SalesRecord::getProduct,
                        Collectors.averagingDouble(SalesRecord::getUnitsSold)
                ));
    }

    // Best Country by Sales
    public String bestCountryBySales(List<SalesRecord> data) {
        return data.stream()
                .collect(Collectors.groupingBy(
                        SalesRecord::getCountry,
                        Collectors.summingDouble(SalesRecord::getSales)
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No Data");
    }

    // Least Selling Product
    public String leastSellingProduct(List<SalesRecord> data) {
        return data.stream()
                .collect(Collectors.groupingBy(
                        SalesRecord::getProduct,
                        Collectors.summingDouble(SalesRecord::getSales)
                ))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No Data");
    }

    // Total Discounts by Product
    public Map<String, Double> totalDiscountsByProduct(List<SalesRecord> data) {
        return data.stream()
                .collect(Collectors.groupingBy(
                        SalesRecord::getProduct,
                        Collectors.summingDouble(SalesRecord::getDiscounts)
                ));
    }

    // Sale Price Stats (min, max, avg)
    public Map<String, DoubleSummaryStatistics> salePriceStatsByProduct(List<SalesRecord> data) {
        return data.stream()
                .collect(Collectors.groupingBy(
                        SalesRecord::getProduct,
                        Collectors.summarizingDouble(SalesRecord::getSalePrice)
                ));
    }

    // Top product for each country (by units sold)
    public Map<String, String> topProductByCountry(List<SalesRecord> data) {
        return data.stream()
                .collect(Collectors.groupingBy(
                        SalesRecord::getCountry,
                        Collectors.groupingBy(
                                SalesRecord::getProduct,
                                Collectors.summingDouble(SalesRecord::getUnitsSold)
                        )
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue()
                                .entrySet()
                                .stream()
                                .max(Map.Entry.comparingByValue())
                                .map(Map.Entry::getKey)
                                .orElse("No Data")
                ));
    }

    // Profit by Product = Gross Sales - Discounts
    public Map<String, Double> profitByProduct(List<SalesRecord> data) {
        return data.stream()
                .collect(Collectors.groupingBy(
                        SalesRecord::getProduct,
                        Collectors.summingDouble(r -> r.getGrossSales() - r.getDiscounts())
                ));
    }

    // Average Discount Percentage
    public double averageDiscountPercentage(List<SalesRecord> data) {
        return data.stream()
                .mapToDouble(r -> (r.getDiscounts() / r.getGrossSales()) * 100)
                .average()
                .orElse(0.0);
    }

    // Top 5 Products by Sales
    public List<Map.Entry<String, Double>> top5ProductsBySales(List<SalesRecord> data) {
        return data.stream()
                .collect(Collectors.groupingBy(
                        SalesRecord::getProduct,
                        Collectors.summingDouble(SalesRecord::getSales)
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
}
