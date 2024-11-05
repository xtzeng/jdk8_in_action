package com.flynne.lambdasinaction.chap1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiaoti
 * @date 2024/11/5 00:36
 */
@Slf4j
public class FilteringApples {


    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        Apple greenApple = inventory.stream().filter(apple -> apple.getColor().equals("green")).findFirst().get();
        log.info("greenApple color: {}", greenApple);
        log.info("Filtering apples in inventory: {}", filterGreenApples(inventory));


    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals("green")) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterRedApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals("red")) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    public boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public boolean isRedApple(Apple apple) {
        return "red".equals(apple.getColor());
    }

    public boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Apple {
        private int weight = 0;
        private String color = "";
    }
}