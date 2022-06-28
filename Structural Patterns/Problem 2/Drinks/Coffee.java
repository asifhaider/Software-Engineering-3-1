package Drinks;

import Decorator.Food;
import Decorator.FoodDecorator;

public class Coffee extends FoodDecorator {
    public Coffee(Food newFood) {
        super(newFood);
    }

    @Override
    public double foodPrice() {
        return super.foodPrice() + 50.0;
    }

    @Override
    public String foodDescription() {
        return (super.foodDescription() + ", Coffee");
    }
}
