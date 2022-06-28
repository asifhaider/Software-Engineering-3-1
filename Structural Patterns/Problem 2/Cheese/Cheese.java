package Cheese;

import Decorator.Food;
import Decorator.FoodDecorator;

public class Cheese extends FoodDecorator {
    public Cheese(Food newFood) {
        super(newFood);
    }

    @Override
    public double foodPrice() {
        return super.foodPrice() + 30.0;
    }

    @Override
    public String foodDescription() {
        return (super.foodDescription() + ", Cheese");
    }
}
