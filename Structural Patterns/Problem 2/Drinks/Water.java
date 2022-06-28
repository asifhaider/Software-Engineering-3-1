package Drinks;

import Decorator.Food;
import Decorator.FoodDecorator;

public class Water extends FoodDecorator {
    public Water(Food newFood) {
        super(newFood);
    }

    @Override
    public double foodPrice() {
        return super.foodPrice() + 20.0;
    }

    @Override
    public String foodDescription() {
        return (super.foodDescription() + ", Water");
    }
}
