package Drinks;

import Decorator.Food;
import Decorator.FoodDecorator;

public class Coke extends FoodDecorator {
    public Coke(Food newFood) {
        super(newFood);
    }

    @Override
    public double foodPrice() {
        return super.foodPrice() + 30.0;
    }

    @Override
    public String foodDescription() {
        return (super.foodDescription() + ", Coke");
    }
}