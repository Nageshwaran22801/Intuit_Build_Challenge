package com.example.demo;

import com.example.demo.producer.BlockingProducerConsumer;
import com.example.demo.producer.manual.ProducerConsumer;
import com.example.demo.sales.SalesAnalysisService;
import com.example.demo.sales.SalesRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

        // Assignment 2 -
        SalesAnalysisService service = new SalesAnalysisService();

        // Load the updated CSV file
        List<SalesRecord> data = service.loadCSV("sales_data.csv");

        System.out.println("=== SALES ANALYSIS REPORT ===\n");

        System.out.println("Total Sales:");
        System.out.println(service.calculateTotalSales(data) + "\n");

        System.out.println("Sales By Product:");
        service.totalSalesByProduct(data).forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();

        System.out.println("Units Sold By Country:");
        service.totalUnitsByCountry(data).forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();

        System.out.println("Highest Selling Product:");
        System.out.println(service.highestSellingProduct(data) + "\n");

        System.out.println("Average Sales By Country:");
        service.averageSalesByCountry(data).forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();

        System.out.println("Average Units Sold By Product:");
        service.averageUnitsSoldByProduct(data).forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();

        System.out.println("Best Country By Sales:");
        System.out.println(service.bestCountryBySales(data) + "\n");

        System.out.println("Least Selling Product:");
        System.out.println(service.leastSellingProduct(data) + "\n");

        System.out.println("Total Discounts By Product:");
        service.totalDiscountsByProduct(data).forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();

        System.out.println("Sale Price Stats By Product:");
        service.salePriceStatsByProduct(data).forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();

        System.out.println("Top Product By Each Country:");
        service.topProductByCountry(data).forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();

        System.out.println("Profit By Product:");
        service.profitByProduct(data).forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();

        System.out.println("Average Discount Percentage:");
        System.out.println(service.averageDiscountPercentage(data) + "%\n");

        System.out.println("Top 5 Products By Sales:");
        service.top5ProductsBySales(data)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        System.out.println();
        System.out.println("=== END OF Assignment 2 ===");
        System.out.println();


        //Assignment 1 -
        // Creating object of ProducerConsumer that create dummy data and creating two threads producer & consumer.
        ProducerConsumer manual = new ProducerConsumer();
        manual.startProcessing();

        // Start blocking queue version
        BlockingProducerConsumer blocking = new BlockingProducerConsumer();
        blocking.startProcessing();

        System.out.println("=== END OF Assignment 1 ===");
        System.out.println();

	}


}
