package com.flynne.lambdasinaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaoti
 * @date 2024/11/6 20:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apple {

    private int weight = 0;
    private String color = "";

    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
