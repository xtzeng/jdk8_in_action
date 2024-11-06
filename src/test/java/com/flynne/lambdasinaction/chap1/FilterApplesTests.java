package com.flynne.lambdasinaction.chap1;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author xiaoti
 * @date 2024/11/6 03:41
 */
@SpringBootTest
@Slf4j
public class FilterApplesTests {

    private List<FilteringApples.Apple> inventory;

    @BeforeEach
    public void setUp() {
        // Initialize the inventory with sample data
        inventory = Arrays.asList(
                new FilteringApples.Apple(80, "green"),
                new FilteringApples.Apple(155, "green"),
                new FilteringApples.Apple(120, "red")
        );
    }

    @Test
    public void testFilterApples() {
        // Filter green apples from the inventory
        List<FilteringApples.Apple> greenApples = FilteringApples.filterApples(inventory, FilteringApples::isGreenApple);

        // Log the result (optional)
        log.info("Filtering green apples in inventory: {}", greenApples);

        // Assert that the filtered list contains only green apples
        assertEquals(2, greenApples.size(), "The number of green apples should be 2");
        for (FilteringApples.Apple apple : greenApples) {
            assertEquals("green", apple.getColor(), "All filtered apples should be green");
        }
    }

    @Test
    public void testFilterGreenApples() {
        // Filter green apples from the inventory using the old method
        List<FilteringApples.Apple> greenApples = FilteringApples.filterApples(inventory, (FilteringApples.Apple a) -> "green".equals(a.getColor()));

        // Log the result (optional)
        log.info("Filtering green apples in inventory: {}", greenApples);

        // Assert that the filtered list contains only green apples
        assertEquals(2, greenApples.size(), "The number of green apples should be 2");
        for (FilteringApples.Apple apple : greenApples) {
            assertEquals("green", apple.getColor(), "All filtered apples should be green");
        }
    }

    @Test
    public void testFilterHeavyApples() {
        // Filter heavy apples from the inventory
        List<FilteringApples.Apple> heavyApples = FilteringApples.filterApples(inventory, (FilteringApples.Apple a) -> a.getWeight() > 150);

        // Assert that the filtered list contains only heavy apples
        assertEquals(1, heavyApples.size(), "The number of heavy apples should be 2");

        // Assert that all filtered apples are indeed heavy
        for (FilteringApples.Apple apple : heavyApples) {
            assertTrue(apple.getWeight() > 150, "All filtered apples should have a weight greater than 150");
        }
    }
}
