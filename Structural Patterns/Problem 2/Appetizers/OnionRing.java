package Appetizers;

import Decorator.Food;
import Decorator.FoodDecorator;

public class OnionRing extends FoodDecorator {
    public OnionRing(Food newFood) {
        super(newFood);
    }

    @Override
    public double foodPrice() {
        return super.foodPrice() + 100.0;
    }

    @Override
    public String foodDescription() {
        return (super.foodDescription() + ", Onion Ring");
    }
}