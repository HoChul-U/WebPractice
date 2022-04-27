package com.nhnacademy.servlet;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletContext;

@Slf4j
public class Units {
    private static List<Food> foodList = new ArrayList<>();

    private final static Units Instance = new Units();

    public static List<Food> getFoodList() {
        return foodList;
    }

    public static void inputFood(ServletContext servletContext) {
        Integer onionCount = Integer.valueOf(servletContext.getInitParameter("onion"));
        Integer eggsCount = Integer.valueOf(servletContext.getInitParameter("eggs"));
        Integer welshOnionCount = Integer.valueOf(servletContext.getInitParameter("welshOnion"));
        Integer applesCount = Integer.valueOf(servletContext.getInitParameter("apple"));

        Food onion = new Food("onion", onionCount, 1000);
        Food eggs = new Food("eggs", eggsCount, 2000);
        Food welshOnion = new Food("welshOnion", welshOnionCount, 500);
        Food apple = new Food("apple", applesCount, 2000);

        foodList.add(onion);
        foodList.add(eggs);
        foodList.add(welshOnion);
        foodList.add(apple);

        for (Food food : foodList) {
            servletContext.setAttribute(food.getFoodName(), food);
            log.info(food.getFoodName());
        }

    }

    public static void setFoodList(ServletContext servletContext, String foodName, int number) {
        for (Food food : foodList) {
            if (food.getFoodName().equals(foodName)) {
                food.setFoodCount(number);
                servletContext.setAttribute(food.getFoodName(), food);
            }
        }
    }
}
