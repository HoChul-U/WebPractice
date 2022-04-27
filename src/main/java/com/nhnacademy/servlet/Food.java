package com.nhnacademy.servlet;

import lombok.NoArgsConstructor;


public class Food {
    private String foodName;
    private int foodMoney;
    private int foodCount;


    public String getFoodName() {
        return foodName;
    }

    public Integer getFoodMoney() {
        return foodMoney;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount-=foodCount;
    }

    public Integer getFoodCount() {
        return foodCount;
    }

    public Food(String foodName, Integer foodCount, Integer foodMoney) {
        this.foodName = foodName;
        this.foodMoney = foodMoney;
        this.foodCount = foodCount;
    }

    @Override
    public String toString() {
        return"<br>"+
            "| 품목 ='" + foodName + "<br>" +
            "| 가격 =" + foodMoney +"<br>"+
            "| 수량 =" + foodCount +"<br>";
    }
}
