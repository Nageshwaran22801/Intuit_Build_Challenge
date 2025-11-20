package com.example.demo.sales_analysis;
import org.junit.jupiter.api.Test;
import com.example.demo.sales.SalesAnalysisService;
import com.example.demo.sales.SalesRecord;

import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;


public class SalesAnalysisTest { @Test
public void testTotalSales() {
    SalesAnalysisService service = new SalesAnalysisService();
    List<SalesRecord> data = Arrays.asList(
            new SalesRecord("Enterprise", "India", "Laptop", "None",
                    2, 0, 0, 0, 0, 50000 * 2),
            new SalesRecord("Enterprise", "US", "Mobile", "None",
                    5, 0, 0, 0, 0, 10000 * 5)
    );
    double total = service.calculateTotalSales(data);
    assertEquals(2 * 50000 + 5 * 10000, total, 0.001);
}

    @Test
    public void testSalesByProduct() {
        SalesAnalysisService service = new SalesAnalysisService();
        List<SalesRecord> data = Arrays.asList(
                new SalesRecord("Enterprise", "India", "Laptop", "None",
                        1, 0, 0, 0, 0, 50000),
                new SalesRecord("Enterprise", "US", "Laptop", "None",
                        1, 0, 0, 0, 0, 60000)
        );
        var map = service.totalSalesByProduct(data);
        assertEquals(110000, map.get("Laptop"), 0.001);
    }

    @Test
    public void testHighestSellingProduct() {
        SalesAnalysisService service = new SalesAnalysisService();
        List<SalesRecord> data = Arrays.asList(
                new SalesRecord("Enterprise", "India", "Laptop", "None",
                        1, 0, 0, 0, 0, 50000),
                new SalesRecord("Enterprise", "US", "Mobile", "None",
                        10, 0, 0, 0, 0, 1000 * 10)
        );
        assertEquals("Laptop", service.highestSellingProduct(data));
    }
}
